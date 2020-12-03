package org.fretron.service

import org.fretron.model.Person
import java.util.*

interface PersonService {

    fun addPerson(person: Person): Boolean
    fun deletePerson(id: String): Boolean
    fun updatePerson(id: String, person: Person): Boolean
    fun getPerson(id: String): Optional<Person>
    fun getAllPersons(): List<Person>

}