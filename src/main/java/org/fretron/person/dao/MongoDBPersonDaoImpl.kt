package org.fretron.person.dao

import com.fasterxml.jackson.databind.ObjectMapper
import com.mongodb.BasicDBObject
import com.mongodb.MongoClient
import com.mongodb.client.MongoDatabase
import com.mongodb.client.model.Filters
import com.mongodb.util.JSON
import org.bson.Document
import org.bson.conversions.Bson
import org.fretron.person.constants.AppConstants
import org.fretron.person.exceptions.MongoDBException
import org.fretron.person.model.Person
import java.util.*
import kotlin.jvm.Throws


class MongoDBPersonDaoImpl : PersonDao {

    var mongoClient: MongoClient? = null
    var mongoDatabase: MongoDatabase? = null
    private val mapper: ObjectMapper = ObjectMapper()

    private fun createConnection() {
        mongoClient = MongoClient("127.0.0.1", 27017)
        mongoDatabase = mongoClient?.getDatabase("personDB")
    }

    private fun closeConnection() {
        mongoClient?.close()
    }

    private fun generatePersonId(): UUID {
        return UUID.randomUUID()
    }

    @Throws(MongoDBException::class)
    override fun addPerson(person: Person): Boolean {
        createConnection()
        val collection = mongoDatabase?.getCollection("person")
        val personToAdd = mapper.readValue(person.toString(), Person::class.java)
        return if (personToAdd != null) {
            val document = Document.parse(personToAdd.toString())
            document["_id"] = generatePersonId().toString()
            collection?.insertOne(document)
            closeConnection()
            true
        } else false
    }

    @Throws(MongoDBException::class)
    override fun deletePerson(id: String): Boolean {
        createConnection()
        val collection = mongoDatabase?.getCollection("person")
        val mongoCollection = collection?.deleteOne(Filters.eq("_id", id))
        closeConnection()
        if (mongoCollection?.deletedCount == "1".toLong()) return true
        else throw MongoDBException("${AppConstants.PERSON_NOT_DELETED} With Id : $id")
    }

    @Throws(MongoDBException::class)
    override fun updatePerson(id: String, person: Person): Boolean {
        createConnection()
        val collection = mongoDatabase?.getCollection("person")
        val query = BasicDBObject()
        query["_id"] = id
        val personDocument = Document.parse(person.toString())
        val update: Bson = Document("\$set", personDocument)
        val mongoCollection = collection?.findOneAndUpdate(query, update)
        closeConnection()
        return true
    }

    @Throws(MongoDBException::class)
    override fun getPerson(id: String): Person? {
        createConnection()
        val collection = mongoDatabase?.getCollection("person")
        var person: Person? = null
        val query = BasicDBObject()
        query["_id"] = id
        collection!!.find(query).iterator().use { cur ->
            while (cur.hasNext()) {
                val doc = cur.next()
                doc.remove("_id")
                val json = JSON.serialize(doc)
                person = mapper.readValue(json, Person::class.java)
            }
        }
        closeConnection()
        if (person == null) throw MongoDBException("${AppConstants.PERSON_NOT_FOUND} At Id : $id")
        return person
    }

    @Throws(MongoDBException::class)
    override fun getAllPersons(): ArrayList<Person> {
        val allPersons: ArrayList<Person> = ArrayList()
        createConnection()
        val collection = mongoDatabase?.getCollection("person")
        collection!!.find().iterator().use { cur ->
            while (cur.hasNext()) {
                val doc = cur.next()
                doc.remove("_id")
                val json = JSON.serialize(doc)
                val person = mapper.readValue(json, Person::class.java)
                allPersons.add(person)
            }
        }
        closeConnection()
        return allPersons
    }

}