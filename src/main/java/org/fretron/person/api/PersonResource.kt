package org.fretron.person.api

import com.fasterxml.jackson.databind.ObjectMapper
import org.fretron.person.constants.AppConstants
import org.fretron.person.dao.MongoDBPersonDaoImpl
import org.fretron.person.model.Person
import org.fretron.person.service.PersonService
import org.fretron.person.service.PersonServiceImpl
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/person/v1")
class PersonResource(private var personServiceImpl: PersonService) {

    private val mapper = ObjectMapper()

    constructor() : this(PersonServiceImpl(MongoDBPersonDaoImpl()))

    @POST
    @Path("/person")
    @Produces(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addPerson(request: String): Response {
        val person = mapper.readValue(request, Person::class.java)
        return if (personServiceImpl.addPerson(person)) Response.ok(AppConstants.PERSON_ADDED).build()
        else Response.ok(AppConstants.PERSON_NOT_ADDED).build()
    }

    @GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    fun getPerson(@QueryParam("id") id: String): Response {
        val person = personServiceImpl.getPerson(id)
        return Response.ok(person.toString()).build()
    }

    @GET
    @Path("/persons")
    @Produces(MediaType.APPLICATION_JSON)
    fun getAllPersons(): Response {
        val personsList = personServiceImpl.getAllPersons()
        return Response.ok(personsList.toString()).build()
    }

    @PUT
    @Path("/person")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    fun updatePerson(@QueryParam("id") id: String, request: String): Response {
        val person = mapper.readValue(request, Person::class.java)
        return if (person != null) {
            if (personServiceImpl.updatePerson(id, person)) Response.ok(AppConstants.PERSON_UPDATED).build()
            else Response.ok(AppConstants.PERSON_NOT_UPDATED).build()
        } else {
            Response.ok(AppConstants.PERSON_NOT_UPDATED).build()
        }
    }

    @DELETE
    @Path("/person")
    @Produces(MediaType.TEXT_PLAIN)
    fun deletePerson(@QueryParam("id") id: String): Response {
        return if (personServiceImpl.deletePerson(id)) Response.ok(AppConstants.PERSON_DELETED).build()
        else Response.ok(AppConstants.PERSON_NOT_DELETED).build()
    }


}
