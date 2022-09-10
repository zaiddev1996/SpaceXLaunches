package zaiddev1996.android.moneseassignment.data.models

import com.google.gson.annotations.SerializedName

data class Launch(
    @SerializedName("rocket") var rocket: String? = null,
    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("date_unix") var dateUnix: Long? = null,

    )
