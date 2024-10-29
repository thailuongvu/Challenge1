package com.example.myapplication456.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication456.data.api.RetrofitInstance
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CurrencyViewModel : ViewModel() {
    private val _result = MutableStateFlow("")
    val result: StateFlow<String> get() = _result

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> get() = _error

    fun convertCurrency(amount: Double, fromCurrency: String, toCurrency: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.convertCurrency(
                    toCurrency = toCurrency,
                    fromCurrency = fromCurrency,
                    amount = amount
                )
                if (response.success && response.result != null) {
                    _result.value = "${response.result} $toCurrency"
                    _error.value = null
                } else {
                    _error.value = "Conversion failed. Please check your input or API key."
                }
            } catch (e: Exception) {
                _error.value = "Error fetching data. Check your network connection."
            }
        }
    }
}


