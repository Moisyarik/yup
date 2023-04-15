import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

fun langsetup() {
    print("Type your preferred language (ONLY Russian works now): ")
    lang = readln()
    lang = lang.lowercase()
    return
}

fun russianlang(){
    print("Назовите своё имя, чтобы мы могли к вам обращаться: ")
    name = readln()
    println("Здравствуйте, $name!")
    print("Введите город, в котором хотите узнать погоду: ")
    city = readln()
    print("Погода в городе $city: ")
    weatherrequest()
}

fun georequest(){
    val client = HttpClient.newBuilder().build();
    val request = HttpRequest.newBuilder()
        .uri(URI.create("http://api.openweathermap.org/geo/1.0/direct?q=$city&appid=cd769554cf380013216c614d0e5fe421"))
        .build();

    val response = client.send(request, HttpResponse.BodyHandlers.ofString());
    geo = response.body()
    println(response.body())
}

fun weatherrequest(){
    georequest()
    val client = HttpClient.newBuilder().build();
    val request = HttpRequest.newBuilder()
        .uri(URI.create("http://api.openweathermap.org/data/2.5/weather?lat=$geo&lang=$lang&appid=4e968e41a1054c130648695150446377")) //set lat!
        .build();

    val response = client.send(request, HttpResponse.BodyHandlers.ofString());
    println(response.body())
}

/*val map = geo.split(",").associate {
    val (left, right) = it.split("=")
    left to right.toInt()
}*/

var city : String = "Moscow"
var geo : String = "N|S"
var lang = "english"
var name = "User"

fun main() {

    langsetup()
    if (lang == "russian"){
        russianlang()
    } else if (lang == "english"){
        println("This is English Language, but it's not supported yet. Program aborted.")
    } else {
        print("No such language is supported yet. Program aborted.")
    }
}