package com.example.cryptoapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.repository.CryptoRepositoryImpl
import com.example.cryptoapp.domain.repository.CryptoRepository
import com.example.cryptoapp.util.Resource
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CryptoCurrencyListingsViewModel: ViewModel() {

    var state by mutableStateOf(CryptoCurrencyListingScreenState())
        private set // mozes samo ovde da ga menjas

    private var repository: CryptoRepository = CryptoRepositoryImpl()

    private var job: Job? = null

    init {
        getAllCryptoListings()
    }

    private fun getAllCryptoListings(){

        job?.cancel()
        job = viewModelScope.launch {

            state = state.copy(isLoading = true)
            val response = repository.getAllCryptoListings()

            when (response) {

                is Resource.Success -> {
                    state = state.copy(
                        currencyListings = response.data ?: emptyList(),
                        isLoading = false
                    )

                }
                is Resource.Error -> {

                    state = state.copy(
                        isLoading = false

                    )

                }

            }
        }

    }
}