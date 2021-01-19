package org.fretron.person.repositories

import org.fretron.person.model.Person

interface PersonRepository {

    fun addPerson(person: Person): Boolean
    fun deletePerson(id: String): Boolean
    fun updatePerson(id: String, person: Person): Boolean
    fun getPerson(id: String): Person?
    fun getAllPersons(): List<Person>

}