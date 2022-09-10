package zaiddev1996.android.moneseassignment.data.repo

import zaiddev1996.android.moneseassignment.data.models.Either
import zaiddev1996.android.moneseassignment.data.models.Launch
import zaiddev1996.android.moneseassignment.data.models.rocket.Rocket

interface SpaceXRepo {

    suspend fun callGetLaunchesApi(): Either<ArrayList<Launch>>
    suspend fun callGetFilteredLaunchesApi(): Either<ArrayList<Launch>>
    suspend fun callGetRocketDetailsApi(rocketId: String): Either<Rocket>

}