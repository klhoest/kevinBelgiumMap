import com.google.gson.Gson
import java.io.FileReader
import java.io.File
import java.io.Reader

val gson = Gson()

fun main(args: Array<String>) {
    val inputProvince : File? = File("belgium/admin_level_6.geojson")
    val reader : Reader? = FileReader(inputProvince)
    if (reader == null) {
        println("could not open inputProvince file")
        return
    }
    val fullGeoModel = gson.fromJson(reader, FullGeoModel::class.java)
    print(fullGeoModel.type)

}