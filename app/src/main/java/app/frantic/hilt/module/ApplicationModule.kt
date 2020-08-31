package app.frantic.hilt.utils

import app.frantic.hilt.BuildConfig
import app.frantic.hilt.network.ApiService
import app.frantic.hilt.network.API_URL.BASEURL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {

    @Provides
    fun provideBaseUrl() = BuildConfig.BASE_URL

    @Provides
    @Singleton
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient
        .Builder()
        .build()


    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        BASE_URL: String
    ): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASEURL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(
        ApiService::class.java)

//    @Provides
//    @Singleton
//    fun provideApiHelper(apiHelper: ApiHelperImpl): ApiHelper = apiHelper

}