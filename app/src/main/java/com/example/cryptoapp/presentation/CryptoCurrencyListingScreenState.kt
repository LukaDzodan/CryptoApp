package com.example.cryptoapp.presentation

import com.example.cryptoapp.domain.model.CryptoData
import retrofit2.http.Query

data class CryptoCurrencyListingScreenState(

    val currencyListings : List<CryptoData> = emptyList(),
    val isLoading : Boolean = true,
    val query: String = "",
)
