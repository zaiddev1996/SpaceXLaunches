package zaiddev1996.android.moneseassignment.data.api

import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*
import zaiddev1996.android.moneseassignment.data.models.Launch
import zaiddev1996.android.moneseassignment.data.models.filterRequest.FilterRequestBody
import zaiddev1996.android.moneseassignment.data.models.filterRequest.FilteredDataResponse
import zaiddev1996.android.moneseassignment.data.models.filterRequest.Success
import zaiddev1996.android.moneseassignment.data.models.rocket.Rocket

interface ApiServices {
    @GET("launches")
    suspend fun getLaunches(): Response<ArrayList<Launch>>

    @POST("launches/query")
    suspend fun getFilteredLaunches(@Body body: FilterRequestBody): Response<FilteredDataResponse>

    @GET("rockets/{rocketId}")
    suspend fun getRocketDetails(
        @Path("rocketId") rocketId: String
    ): Response<Rocket>
}