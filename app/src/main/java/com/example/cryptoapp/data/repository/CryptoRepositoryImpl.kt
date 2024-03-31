package com.example.cryptoapp.data.repository

import com.example.cryptoapp.data.remote.RetrofitInstance
import com.example.cryptoapp.domain.model.CryptoData
import com.example.cryptoapp.domain.repository.CryptoRepository
import com.example.cryptoapp.util.Resource

class CryptoRepositoryImpl : CryptoRepository {
    override suspend fun getAllCryptoListings(): Resource<List<CryptoData>> {
        try {
            val response = RetrofitInstance.cryptoApi.getAllCryptoListings()

            if (response.isSuccessful) {
                return Resource.Success(response.body()?.data)
            }

            return Resource.Error("Response nije succesful")

        } catch (e: Exception) {
            e.printStackTrace()
            return Resource.Error("Nema neta")
        }
    }
}