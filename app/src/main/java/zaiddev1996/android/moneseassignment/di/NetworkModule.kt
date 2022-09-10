package zaiddev1996.android.moneseassignment.di

import android.util.Log
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import zaiddev1996.android.moneseassignment.data.api.ApiServices
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private var gson = GsonBuilder()
        .setLenient()
        .create()

    private val baseRetrofitBuilder: Retrofit.Builder = Retrofit.Builder()
        .baseUrl("https://api.spacexdata.com/v4/")
        .addConverterFactory(GsonConverterFactory.create(gson))

    private fun getOkHttpClient(): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
        builder.connectTimeout(30, TimeUnit.SECONDS)
        builder.readTimeout(30, TimeUnit.SECONDS)
        builder.writeTimeout(30, TimeUnit.SECONDS)
        builder.addInterceptor(loggingInterceptor())
        return builder.build()
    }

    private fun loggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor { message -> Log.d("RAW_RESPONSE", message) }
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor
    }


    @Provides
    @Singleton
    fun provideApiService(): ApiServices {
        return baseRetrofitBuilder.client(getOkHttpClient())
            .build()
            .create(ApiServices::class.java)
    }

}