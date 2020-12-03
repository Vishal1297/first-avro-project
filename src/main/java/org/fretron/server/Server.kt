import com.sun.net.httpserver.HttpServer
import org.fretron.api.ApiResource
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig
import java.net.URI
import javax.ws.rs.core.UriBuilder

class Server {

    private val PORT = 8080
    private val HOST_NAME = "http://localhost/"

    fun startServer(): HttpServer {
        val config = ResourceConfig(ApiResource::class.java)
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
}