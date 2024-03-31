package com.example.cryptoapp.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun CryptoCurrencyListingsScreen(
    state : CryptoCurrencyListingScreenState
) {

    if(!state.isLoading){
        Text(state.currencyListings[4].toString())
    }

}