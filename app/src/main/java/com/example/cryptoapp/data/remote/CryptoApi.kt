package com.example.cryptoapp.data.remote

import com.example.cryptoapp.domain.model.CryptoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoApi {

    @GET("cryptocurrency/listings/latest")
    suspend fun getAllCryptoListings(
        @Query("CMC_PRO_API_KEY")
        apiKey: String = ApiValues.API_KEY,
        @Query("sort") sort : String = "market_cap",
    ) : Response<CryptoResponse>

}