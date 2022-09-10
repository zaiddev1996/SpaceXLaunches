package zaiddev1996.android.moneseassignment.data.models.rocket

import com.google.gson.annotations.SerializedName


data class Mass (

  @SerializedName("kg" ) var kg : Int? = null,
  @SerializedName("lb" ) var lb : Int? = null

)