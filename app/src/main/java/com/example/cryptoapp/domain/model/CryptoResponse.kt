package com.example.cryptoapp.domain.model

data class CryptoResponse(
    val `data`: List<CryptoData>?,
    val status: Status?
)