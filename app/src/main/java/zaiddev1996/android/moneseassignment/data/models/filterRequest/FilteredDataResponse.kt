package zaiddev1996.android.moneseassignment.data.models.filterRequest

import com.google.gson.annotations.SerializedName
import zaiddev1996.android.moneseassignment.data.models.Launch
import zaiddev1996.android.moneseassignment.data.models.rocket.Height

data class FilteredDataResponse(
    @SerializedName("docs") var docs: ArrayList<Launch>,
) {
}