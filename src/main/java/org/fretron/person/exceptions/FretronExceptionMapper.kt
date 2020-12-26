package org.fretron.person.exceptions

import org.fretron.person.constants.AppConstants.NOT_FOUND
import javax.inject.Inject
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class FretronExceptionMapper @Inject constructor() : ExceptionMapper<FretronException> {
    override fun toResponse(exception: FretronException?): Response {
        when (exception) {
            is MongoDBException -> {
                println("MONGODB EXCEPTION")
                return Response.serverError().build()
            }
            is NotAllowedException -> {
                println(exception)
                println("NOT ALLOWED EXCEPTION: ${exception.message}")
                return Response.ok(
                    org.fretron.person.exceptions.Response.error(exception.message).toString(),
                    MediaType.APPLICATION_JSON
                ).build()
            }
            is ResourceNotFoundException -> {
                return Response.ok(
                    org.fretron.person.exceptions.Response.error(NOT_FOUND).toString(),
                    MediaType.APPLICATION_JSON
                ).build()
            }
            else -> {
                println(exception)
                println("NONE FROM SYSTEM DEFINE EXCEPTION")
                return Response.serverError().build()
            }
        }
    }
}