import com.sun.net.httpserver.HttpServer
import org.fretron.person.api.PersonResource
import org.fretron.person.constants.AppConstants
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig
import java.net.URI
import javax.ws.rs.core.UriBuilder

class Server {

    private val PORT = AppConstants.PORT
    private val HOST_NAME = AppConstants.HOST_NAME

    fun startServer(): HttpServer {
        val config = ResourceConfig(PersonResource::class.java)
        return JdkHttpServerFactory.createHttpServer(getBaseURI(), config)
    }

    private fun getBaseURI(): URI {
        return UriBuilder.fromUri(HOST_NAME).port(PORT).build()
    }
}

fun main() {
    println("Starting HTTP Server...")
    val server = Server()
    server.startServer()
    println("Done...")
}