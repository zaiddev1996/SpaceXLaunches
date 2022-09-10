package zaiddev1996.android.moneseassignment.data.models.rocket

import com.google.gson.annotations.SerializedName


data class Isp (

  @SerializedName("sea_level" ) var seaLevel : Int? = null,
  @SerializedName("vacuum"    ) var vacuum   : Int? = null

)