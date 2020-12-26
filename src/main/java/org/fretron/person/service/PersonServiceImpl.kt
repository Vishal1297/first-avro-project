package org.fretron.person.service

import org.fretron.person.constants.AppConstants
import org.fretron.person.dao.PersonDao
import org.fretron.person.exceptions.FretronException
import org.fretron.person.model.Person
import kotlin.jvm.Throws

class PersonServiceImpl(private val personDaoImpl: PersonDao) : PersonService {

    @Throws(FretronException::class)
    override fun addPerson(person: Person): Boolean {
        if (person.name == null || person.name.isEmpty() || person.age < 1) throw FretronException(AppConstants.INVALID_PERSON_NAME_OR_AGE)
        return personDaoImpl.addPerson(person)
    }

    @Throws(FretronException::class)
    override fun deletePerson(id: String): Boolean {
        if (id.isEmpty()) throw FretronException(AppConstants.INVALID_PERSON_ID)
        return personDaoImpl.deletePerson(id)
    }

    @Throws(FretronException::class)
    override fun updatePerson(id: String, person: Person): Boolean {
        if (id.isEmpty()) throw FretronException(AppConstants.INVALID_PERSON_ID)
        if (person.name == null || person.name.isEmpty() || person.age < 1) throw FretronException(AppConstants.INVALID_PERSON_NAME_OR_AGE)
        return personDaoImpl.updatePerson(id, person)
    }

    @Throws(FretronException::class)
    override fun getPerson(id: String): Person? {
        if (id.isEmpty()) throw FretronException()
        return personDaoImpl.getPerson(id)
    }

    @Throws(FretronException::class)
    override fun getAllPersons(): List<Person> {
        return personDaoImpl.getAllPersons()
    }


}