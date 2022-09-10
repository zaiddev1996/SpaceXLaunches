package zaiddev1996.android.moneseassignment.data.models.rocket

import com.google.gson.annotations.SerializedName


data class Payloads (

  @SerializedName("composite_fairing" ) var compositeFairing : CompositeFairing? = CompositeFairing(),
  @SerializedName("option_1"          ) var option1          : String?           = null

)