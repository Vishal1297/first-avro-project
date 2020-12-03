package org.fretron.person.service

import org.fretron.person.model.Person
import javax.ws.rs.Path

@Path(value = "personService")
interface PersonService {

    fun addPerson(person: Person): Boolean
    fun deletePerson(id: String): Boolean
    fun updatePerson(id: String, person: Person): Boolean
    fun getPerson(id: String): Person?
    fun getAllPersons(): List<Person>

}