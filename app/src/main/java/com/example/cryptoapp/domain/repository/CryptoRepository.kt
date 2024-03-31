package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.domain.model.CryptoData
import com.example.cryptoapp.util.Resource

interface CryptoRepository {

    suspend fun getAllCryptoListings(): Resource<List<CryptoData>>

}