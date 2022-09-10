package zaiddev1996.android.moneseassignment.data.repo

import okhttp3.MultipartBody
import zaiddev1996.android.moneseassignment.data.models.Either
import zaiddev1996.android.moneseassignment.data.api.ApiServices
import zaiddev1996.android.moneseassignment.data.models.Launch
import zaiddev1996.android.moneseassignment.data.models.filterRequest.FilterRequestBody
import zaiddev1996.android.moneseassignment.data.models.filterRequest.FilteredDataResponse
import zaiddev1996.android.moneseassignment.data.models.filterRequest.Options
import zaiddev1996.android.moneseassignment.data.models.filterRequest.Success
import zaiddev1996.android.moneseassignment.data.models.rocket.Rocket
import java.lang.Exception
import javax.inject.Inject

class SpaceXRepoImp @Inject constructor(
    private val apiServices: ApiServices
) : SpaceXRepo {
    override suspend fun callGetLaunchesApi(): Either<ArrayList<Launch>> {

        return try {
            val response = apiServices.getLaunches()
            if (response.isSuccessful) {
                if (response.code() == 200) {
                    Either.success(response.body()!!)
                } else {
                    Either.error(response.message())
                }
            } else {
                Either.error("Something went wrong.. Please check your connection.")
            }
        } catch (e: Exception) {
            Either.error("Something went wrong.. Please check your connection.")
        }

    }

    override suspend fun callGetFilteredLaunchesApi(): Either<ArrayList<Launch>> {

        return try {
            val response =
                apiServices.getFilteredLaunches(FilterRequestBody(Success(true), Options(100000)))
            if (response.isSuccessful) {
                if (response.code() == 200) {
                    Either.success(response.body()!!.docs)
                } else {
                    Either.error(response.message())
                }
            } else {
                Either.error("Something went wrong.. Please check your connection.")
            }
        } catch (e: Exception) {
            Either.error("Something went wrong.. Please check your connection.")
        }

    }

    override suspend fun callGetRocketDetailsApi(rocketId: String): Either<Rocket> {
        return try {
            val response = apiServices.getRocketDetails(rocketId)
            if (response.isSuccessful) {
                if (response.code() == 200) {
                    Either.success(response.body()!!)
                } else {
                    Either.error(response.message())
                }
            } else {
                Either.error("Something went wrong.. Please check your connection.")
            }
        } catch (e: Exception) {
            Either.error("Something went wrong.. Please check your connection.")
        }

    }
}