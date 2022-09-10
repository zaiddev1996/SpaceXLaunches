package zaiddev1996.android.moneseassignment.data.models.rocket

import com.google.gson.annotations.SerializedName


data class Thrust (

  @SerializedName("kN"  ) var kN  : Int? = null,
  @SerializedName("lbf" ) var lbf : Int? = null

)