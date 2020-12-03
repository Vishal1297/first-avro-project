package org.fretron.dao

import org.fretron.model.Person
import java.util.*

class PersonDaoImpl : PersonDao {

    companion object {
        var personsList: ArrayList<Person> = arrayListOf()
    }

    override fun addPerson(person: Person): Boolean {
        return personsList.add(person)
    }

    override fun deletePerson(id: String): Boolean {
        val havePerson: Optional<Person> = getPerson(id)
        return if (havePerson.isPresent) personsList.remove(havePerson.get())
        else false
    }

    override fun updatePerson(id: String, person: Person): Boolean {
        val index = personsList.indexOfFirst { it.id == id }
        personsList[index] = person
        return index != -1
    }

    override fun getPerson(id: String): Optional<Person> {
        return personsList.stream().filter { person -> person.id == id }.findFirst()
    }

    override fun getAllPersons(): List<Person> {
        return personsList
    }


}