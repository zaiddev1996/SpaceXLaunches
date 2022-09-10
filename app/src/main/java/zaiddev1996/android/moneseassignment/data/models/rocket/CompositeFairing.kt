package zaiddev1996.android.moneseassignment.data.models.rocket

import com.google.gson.annotations.SerializedName


data class CompositeFairing (

  @SerializedName("height"   ) var height   : Height?   = Height(),
  @SerializedName("diameter" ) var diameter : Diameter? = Diameter()

)