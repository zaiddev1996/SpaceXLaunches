package zaiddev1996.android.moneseassignment.data.models.rocket

import com.google.gson.annotations.SerializedName


data class FirstStage (

  @SerializedName("thrust_sea_level" ) var thrustSeaLevel : ThrustSeaLevel? = ThrustSeaLevel(),
  @SerializedName("thrust_vacuum"    ) var thrustVacuum   : ThrustVacuum?   = ThrustVacuum(),
  @SerializedName("reusable"         ) var reusable       : Boolean?        = null,
  @SerializedName("engines"          ) var engines        : Int?            = null,
  @SerializedName("fuel_amount_tons" ) var fuelAmountTons : Double?         = null,
  @SerializedName("burn_time_sec"    ) var burnTimeSec    : Int?            = null

)