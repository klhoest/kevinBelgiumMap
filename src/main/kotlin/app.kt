import com.google.gson.Gson

const val PROVINCE_FILE_NAME = "belgium/admin_level_6.geojson"
const val REGION_FILE_NAME = "belgium/admin_level_4.geojson"
const val BRUSSELS_REGION_ID = 54094

val gson = Gson()

fun main(args: Array<String>) {
    val jsonDeserializer = JsonDeserializer<FullGeoModel>(gson)
    val fullGeoModel = jsonDeserializer.extractPojo(PROVINCE_FILE_NAME, FullGeoModel::class.java)
    if (fullGeoModel == null) {
        println("could not open $PROVINCE_FILE_NAME")
        return
    }

    val regions = jsonDeserializer.extractPojo(REGION_FILE_NAME, FullGeoModel::class.java)
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
    val outputJson: String = gson.toJson(fullGeoModel)
}