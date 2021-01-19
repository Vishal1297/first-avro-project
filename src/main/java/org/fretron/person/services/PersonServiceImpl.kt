package org.fretron.person.services

import org.fretron.person.repositories.PersonRepository
import org.fretron.person.model.Person
import javax.ws.rs.NotAllowedException

class PersonServiceImpl(private val personRepositoryImpl: PersonRepository) : PersonService {

    override fun addPerson(person: Person): Boolean {
        if (person.id.isEmpty()) throw NotAllowedException("Id Not Provided")
        if (person.name == null || person.name.isEmpty()) throw NotAllowedException("Name Not Provided")
        return personRepositoryImpl.addPerson(person)
    }

    override fun deletePerson(id: String): Boolean {
        if (id.isEmpty()) throw NotAllowedException("Id Not Provided")
        return personRepositoryImpl.deletePerson(id)
    }

    override fun updatePerson(id: String, person: Person): Boolean {
        if (person.id.isEmpty()) throw NotAllowedException("Id Not Provided")
        if (person.name == null || person.name.isEmpty()) throw NotAllowedException("Name Not Provided")
        return personRepositoryImpl.updatePerson(id, person)
    }

    override fun getPerson(id: String): Person? {
        if (id.isEmpty()) throw NotAllowedException("Id Not Provided")
        return personRepositoryImpl.getPerson(id)
    }

    override fun getAllPersons(): List<Person> {
        return personRepositoryImpl.getAllPersons()
    }


}