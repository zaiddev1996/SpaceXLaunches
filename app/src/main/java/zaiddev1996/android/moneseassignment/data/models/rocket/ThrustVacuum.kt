package zaiddev1996.android.moneseassignment.data.models.rocket

import com.google.gson.annotations.SerializedName


data class ThrustVacuum (

  @SerializedName("kN"  ) var kN  : Int? = null,
  @SerializedName("lbf" ) var lbf : Int? = null

)