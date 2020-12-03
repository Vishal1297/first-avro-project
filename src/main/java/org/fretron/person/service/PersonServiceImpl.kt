package org.fretron.person.service

import org.fretron.person.dao.PersonDao
import org.fretron.person.model.Person
import javax.inject.Inject
import javax.ws.rs.Path

class PersonServiceImpl(private val personDaoImpl: PersonDao) : PersonService {

    override fun addPerson(person: Person): Boolean {
        return personDaoImpl.addPerson(person)
    }

    override fun deletePerson(id: String): Boolean {
        return personDaoImpl.deletePerson(id)
    }

    override fun updatePerson(id: String, person: Person): Boolean {
        return personDaoImpl.updatePerson(id, person)
    }

    override fun getPerson(id: String): Person? {
        return personDaoImpl.getPerson(id)
    }

    override fun getAllPersons(): List<Person> {
        return personDaoImpl.getAllPersons()
    }


}