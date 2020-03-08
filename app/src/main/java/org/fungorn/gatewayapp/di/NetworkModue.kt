package org.fungorn.gatewayapp.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import org.fungorn.gatewayapp.BuildConfig
import org.fungorn.gatewayapp.data.api.GatewayService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { provideGatewayService(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

fun provideOkHttpClient(/*authInterceptor: AuthInterceptor*/): OkHttpClient =
    OkHttpClient().newBuilder()
        //.addInterceptor(authInterceptor)
        .build()

fun provideGatewayService(retrofit: Retrofit): GatewayService =
    retrofit.create(GatewayService::class.java)