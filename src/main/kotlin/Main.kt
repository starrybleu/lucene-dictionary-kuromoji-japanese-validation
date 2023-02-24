import org.apache.lucene.analysis.ja.JapaneseTokenizer
import org.apache.lucene.analysis.ja.dict.UserDictionary
import java.io.StringReader


fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    var counter = 0
    getResourceAsText("user_dict_ja2.txt")?.lines()?.forEach {
        try {
            var dict = UserDictionary.open(StringReader(it))
            val tokenizer = JapaneseTokenizer(dict, true, JapaneseTokenizer.Mode.NORMAL)
        } catch (e: RuntimeException) {
            println("line with problem : ${it}")
            counter += 1
        }
    }
    println("counter: ${counter}")
}

fun getResourceAsText(path: String): String? = object {}.javaClass.getResource(path)?.readText()
