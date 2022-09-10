package zaiddev1996.android.moneseassignment.data.models.rocket

import com.google.gson.annotations.SerializedName


data class Engines (

  @SerializedName("isp"              ) var isp            : Isp?            = Isp(),
  @SerializedName("thrust_sea_level" ) var thrustSeaLevel : ThrustSeaLevel? = ThrustSeaLevel(),
  @SerializedName("thrust_vacuum"    ) var thrustVacuum   : ThrustVacuum?   = ThrustVacuum(),
  @SerializedName("number"           ) var number         : Int?            = null,
  @SerializedName("type"             ) var type           : String?         = null,
  @SerializedName("version"          ) var version        : String?         = null,
  @SerializedName("layout"           ) var layout         : String?         = null,
  @SerializedName("engine_loss_max"  ) var engineLossMax  : Int?            = null,
  @SerializedName("propellant_1"     ) var propellant1    : String?         = null,
  @SerializedName("propellant_2"     ) var propellant2    : String?         = null,
  @SerializedName("thrust_to_weight" ) var thrustToWeight : Int?            = null

)