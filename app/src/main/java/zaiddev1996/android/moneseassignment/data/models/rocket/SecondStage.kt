package zaiddev1996.android.moneseassignment.data.models.rocket

import com.google.gson.annotations.SerializedName


data class SecondStage (

  @SerializedName("thrust"           ) var thrust         : Thrust?   = Thrust(),
  @SerializedName("payloads"         ) var payloads       : Payloads? = Payloads(),
  @SerializedName("reusable"         ) var reusable       : Boolean?  = null,
  @SerializedName("engines"          ) var engines        : Int?      = null,
  @SerializedName("fuel_amount_tons" ) var fuelAmountTons : Double?   = null,
  @SerializedName("burn_time_sec"    ) var burnTimeSec    : Int?      = null

)