import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun main() {

    val client = HttpClient.newBuilder().build();
    val request = HttpRequest.newBuilder()
        .uri(URI.create("http://api.openweathermap.org/data/2.5/forecast?id=524901&appid=4e968e41a1054c130648695150446377"))
        .build();

    val response = client.send(request, HttpResponse.BodyHandlers.ofString());
    println(response.body())
}