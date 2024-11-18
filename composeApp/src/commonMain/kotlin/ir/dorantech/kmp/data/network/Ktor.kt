package ir.dorantech.kmp.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.statement.HttpResponse
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.setBody
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

expect fun provideHttpClientEngineFactory(): HttpClientEngineFactory<*>

object Ktor {
    suspend fun simpleGet(): String {
        val client = HttpClient(provideHttpClientEngineFactory())
        val response: HttpResponse = client.get("https://ktor.io/")
        println(response.status)
        println(response.bodyAsText())
        client.close()
        return response.status.toString()
    }

    //    implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
    @Serializable
    data class KeyValue(
        val key: String,
        val value: String
    )

    suspend fun simplePost(): String {
        val client = HttpClient {
            install(ContentNegotiation) {
                json()
            }
        }

        val requestBody =
            KeyValue("userId", "1840")
        Json.encodeToString(requestBody)

        val response: HttpResponse = client.post("https://jsonplaceholder.typicode.com/posts") {
            contentType(ContentType.Application.Json)
            setBody(requestBody)
        }

        val responseBody = response.bodyAsText()
        println(responseBody)

        client.close()
        return response.status.toString()
    }
}