import com.google.gson.Gson
import java.io.IOException

const val PROVINCE_FILE_NAME = "belgium/admin_level_6.geojson"
const val REGION_FILE_NAME = "belgium/admin_level_4.geojson"
const val OUTPUT_FILE_NAME = "belgium/output.geojson"
const val BRUSSELS_REGION_ID = 54094

val gson = Gson()

fun main(args: Array<String>) {
    val jsonSerializer = JsonSerializer<FullGeoModel>(gson)
    val fullGeoModel = jsonSerializer.extractPojo(PROVINCE_FILE_NAME, FullGeoModel::class.java)
    if (fullGeoModel == null) {
        println("could not open $PROVINCE_FILE_NAME")
        return
    }

    val regions = jsonSerializer.extractPojo(REGION_FILE_NAME, FullGeoModel::class.java)
    if (regions == null) {
        println("could not open $REGION_FILE_NAME")
        return
    }
    val brusselsRegion = regions.features.find { it -> it.id == BRUSSELS_REGION_ID }
    if (brusselsRegion == null) {
        println("could not find any region with id = $BRUSSELS_REGION_ID")
        return
    }

    fullGeoModel.features += brusselsRegion

    try {
        jsonSerializer.writeJson(OUTPUT_FILE_NAME, fullGeoModel)
    } catch (ex : IOException) {
        println("could not save result inside of $OUTPUT_FILE_NAME")
    }
}