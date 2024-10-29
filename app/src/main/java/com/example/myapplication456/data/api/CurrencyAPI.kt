package com.example.myapplication456.data.api

import com.example.myapplication456.utils.Constants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


class AuthInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("apikey", apiKey)  // Use "apikey" as the header key
            .build()
        return chain.proceed(request)
    }
}
interface CurrencyAPI {
    @GET("convert")
    suspend fun convertCurrency(
        @Query("to") toCurrency: String,
        @Query("from") fromCurrency: String,
        @Query("amount") amount: Double
    ): ConvertResponse
}

object RetrofitInstance {

    private val client = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor(Constants.ACCESS_KEY))  // Replace with your actual API key
        .build()
    val api: CurrencyAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.apilayer.com/exchangerates_data/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrencyAPI::class.java)
    }
}
data class ConvertResponse(
    val success: Boolean,
    val result: Double?
)
