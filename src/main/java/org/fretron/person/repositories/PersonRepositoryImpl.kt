package org.fretron.person.repositories

import org.fretron.person.model.Person
import java.util.*
import java.util.stream.Collectors

class PersonRepositoryImpl : PersonRepository {

    companion object {
        var personsList: ArrayList<Person> = arrayListOf()
    }

    override fun addPerson(person: Person): Boolean {
        return personsList.add(person)
    }

    override fun deletePerson(id: String): Boolean {
        personsList = personsList.stream().filter { person -> person.id != id }.collect(Collectors.toList()) as ArrayList<Person>
        return true
    }

    override fun updatePerson(id: String, person: Person): Boolean {
        val index = personsList.indexOfFirst { it.id == id }
        personsList[index] = person
        return index != -1
    }

    override fun getPerson(id: String): Person? {
        return personsList.stream().filter { person -> person.id == id }.findFirst().orElse(null)
    }

    override fun getAllPersons(): List<Person> {
        return personsList
    }


}