import com.google.gson.annotations.SerializedName

data class FullGeoModel(
    @SerializedName("type") var type: String?, //FeatureCollection
    @SerializedName("geocoding") var geocoding: Geocoding?,
    @SerializedName("features") var features: List<Feature?>?
)

data class Geocoding(
    @SerializedName("creation_date") var creationDate: String?, //2016-10-12
    @SerializedName("generator") var generator: Generator?,
    @SerializedName("license") var license: String? //ODbL (see http://www.openstreetmap.org/copyright)
)

data class Generator(
    @SerializedName("author") var author: Author?,
    @SerializedName("package") var packageX: String?, //fences-builder
    @SerializedName("version") var version: String? //0.1.2
)

data class Author(
    @SerializedName("name") var name: String? //Mapzen
)

data class Feature(
    @SerializedName("id") var id: Int?, //1311816
    @SerializedName("osm_type") var osmType: String?, //relation
    @SerializedName("type") var type: String?, //Feature
    @SerializedName("name") var name: String?, //Namur
    @SerializedName("properties") var properties: Properties?,
    @SerializedName("geometry") var geometry: Geometry?
)

data class Geometry(
    @SerializedName("type") var type: String?, //MultiPolygon
    @SerializedName("coordinates") var coordinates: List<List<List<List<Double?>?>?>?>?
)

data class Properties(
    @SerializedName("name") var name: String?, //Namur
    @SerializedName("name:ca") var nameca: String?, //Província de Namur
    @SerializedName("name:de") var namede: String?, //Namur
    @SerializedName("name:en") var nameen: String?, //Namur
    @SerializedName("name:fr") var namefr: String?, //Namur
    @SerializedName("name:nl") var namenl: String?, //Namen
    @SerializedName("name:ru") var nameru: String?, //Намюр
    @SerializedName("name:wa") var namewa: String?, //Nameur
    @SerializedName("ref:INS") var refINS: String?, //90000
    @SerializedName("boundary") var boundary: String?, //administrative
    @SerializedName("wikidata") var wikidata: String?, //Q134121
    @SerializedName("ISO3166-2") var iSO31662: String?, //BE-WNA
    @SerializedName("wikipedia") var wikipedia: String?, //fr:Province de Namur
    @SerializedName("admin_level") var adminLevel: String?, //6
    @SerializedName("border_type") var borderType: String?, //departement
    @SerializedName("boundary_type") var boundaryType: String? //state
)