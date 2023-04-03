fun LangSetup() {
    print("Type your preferred language (ONLY Russian works now): ")
    lang = readln()
    lang = lang.lowercase()
    return
}

fun RussianLang(){
    print("Назовите своё имя, чтобы мы могли к вам обращаться: ")
    name = readln()
    println("Здравствуйте, $name!")

}
var lang = "english"
var name = "User"

fun main() {
    LangSetup()
    if (lang == "russian"){
    RussianLang()
    } else if (lang == "english"){
        println("This is English Language, but it's not supported yet. Program aborted.")
    } else {
        print("No such language is supported yet. Program aborted.")
    }
}