package org.fretron.person.api

import com.fasterxml.jackson.databind.ObjectMapper
import org.fretron.person.dao.PersonDao
import org.fretron.person.dao.PersonDaoImpl
import org.fretron.person.model.Person
import org.fretron.person.service.PersonService
import org.fretron.person.service.PersonServiceImpl
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/person/v1")
class PersonResource(private var personServiceImpl: PersonService) {

    private val mapper = ObjectMapper()

    constructor() : this(PersonServiceImpl(PersonDaoImpl()))

    @POST
    @Path("/person")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addPerson(request: String): Response {
        val person = mapper.readValue(request, Person::class.java)
        return if (personServiceImpl.addPerson(person)) Response.ok("Person Added!!").build()
        else Response.status(Response.Status.INTERNAL_SERVER_ERROR).build()
    }

    @GET
    @Path("/person")
    @Produces(MediaType.APPLICATION_JSON)
    fun getPerson(@QueryParam("id") id: String): Response {
        val person = personServiceImpl.getPerson(id) ?: return Response.status(Response.Status.NOT_FOUND).build()
        return Response.ok(person.toString()).build()
    }

    @GET
    @Path("/persons")
    @Produces(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON)
    fun getAllPersons(): Response {
        val personsList = personServiceImpl.getAllPersons().toString()
        return Response.ok(personsList).build()
    }

    @PUT
    @Path("/person")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    fun updatePerson(@QueryParam("id") id: String, request: String): Response {
        val person = mapper.readValue(request, Person::class.java)
        return if (person != null) {
            if (personServiceImpl.updatePerson(id, person)) Response.ok("Person Updated!!").build()
            else Response.status(Response.Status.INTERNAL_SERVER_ERROR).build()
        } else {
            Response.status(Response.Status.NOT_MODIFIED).build()
        }
    }

    @DELETE
    @Path("/person")
    @Produces(MediaType.TEXT_PLAIN)
    fun deletePerson(@QueryParam("id") id: String): Response {
        return if (personServiceImpl.deletePerson(id)) Response.ok("Person Deleted!!").build()
        else Response.status(Response.Status.NOT_MODIFIED).build()
    }


}
