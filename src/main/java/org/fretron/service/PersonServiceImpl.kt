package org.fretron.service

import org.fretron.dao.PersonDaoImpl
import org.fretron.model.Person
import java.util.*

class PersonServiceImpl : PersonService {

    private val personDaoImpl = PersonDaoImpl()

    override fun addPerson(person: Person): Boolean {
        return personDaoImpl.addPerson(person)
    }

    override fun deletePerson(id: String): Boolean {
        return personDaoImpl.deletePerson(id)
    }

    override fun updatePerson(id: String, person: Person): Boolean {
        return personDaoImpl.updatePerson(id, person)
    }

    override fun getPerson(id: String): Optional<Person> {
        return personDaoImpl.getPerson(id)
    }

    override fun getAllPersons(): List<Person> {
        return personDaoImpl.getAllPersons()
    }


}