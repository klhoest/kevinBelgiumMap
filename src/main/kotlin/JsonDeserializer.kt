import com.google.gson.Gson
import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.io.IOException

class JsonDeserializer<T>(private val gson: Gson) {

    /**
     * @return a pojo of generic type
     * this method is long but java/kotlin does not handle file in a very elegant way
     */
    fun extractPojo(name: String, type: Class<T>): T? {

        var fileReader: FileReader? = null
        try {
            val file: File? = File(name)
            fileReader = FileReader(file)
            if (fileReader != null) { //java methods are not null safe
                val result = gson.fromJson(fileReader, type)
                fileReader.close()
                return result
            }
        } catch (ex: Exception) {
            //see https://discuss.kotlinlang.org/t/does-kotlin-have-multi-catch/486/4
            when (ex) {
                is FileNotFoundException,
                is IOException -> {
                    println(ex.message)
                }
                else -> throw ex
            }
        } finally {
            fileReader?.close()
        }
        return null
    }
}