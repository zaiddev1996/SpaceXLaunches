package zaiddev1996.android.moneseassignment.data.models.rocket

import com.google.gson.annotations.SerializedName


data class LandingLegs (

  @SerializedName("number"   ) var number   : Int?    = null,
  @SerializedName("material" ) var material : String? = null

)