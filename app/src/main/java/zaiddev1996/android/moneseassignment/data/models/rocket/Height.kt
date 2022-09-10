package zaiddev1996.android.moneseassignment.data.models.rocket

import com.google.gson.annotations.SerializedName


data class Height (

  @SerializedName("meters" ) var meters : Double? = null,
  @SerializedName("feet"   ) var feet   : Double? = null

)