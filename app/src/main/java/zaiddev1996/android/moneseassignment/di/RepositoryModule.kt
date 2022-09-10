package zaiddev1996.android.moneseassignment.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import zaiddev1996.android.moneseassignment.data.repo.SpaceXRepo
import zaiddev1996.android.moneseassignment.data.repo.SpaceXRepoImp

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun repo(spaceXRepoImp: SpaceXRepoImp): SpaceXRepo
}