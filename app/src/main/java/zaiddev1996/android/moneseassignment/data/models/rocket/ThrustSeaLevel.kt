package zaiddev1996.android.moneseassignment.data.models.rocket

import com.google.gson.annotations.SerializedName


data class ThrustSeaLevel (

  @SerializedName("kN"  ) var kN  : Int? = null,
  @SerializedName("lbf" ) var lbf : Int? = null

)