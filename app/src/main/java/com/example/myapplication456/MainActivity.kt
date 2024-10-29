package com.example.myapplication456


import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myapplication456.databinding.ActivityMainBinding
import com.example.myapplication456.ui.CurrencyViewModel
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CurrencyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ArrayAdapter.createFromResource(
            this,
            R.array.currency_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerFromCurrency.adapter = adapter
            binding.spinnerToCurrency.adapter = adapter
        }

        binding.btnConvert.setOnClickListener {
            val amount = binding.etAmount.text.toString().toDoubleOrNull()
            val fromCurrency = binding.spinnerFromCurrency.selectedItem.toString()
            val toCurrency = binding.spinnerToCurrency.selectedItem.toString()

            if (amount != null) {
                viewModel.convertCurrency( amount, fromCurrency, toCurrency)

            } else {
                binding.tvResult.text = "0"
                Toast.makeText(this, "Please enter a valid amount ", Toast.LENGTH_SHORT).show()

            }
        }
//
        // Collect ViewModel states and update UI
        lifecycleScope.launch {
            viewModel.result.collect { result ->
                val content = SpannableString(result)
                content.setSpan(UnderlineSpan(), 0, content.length, 0)
                binding.tvResult.text = content
            }
        }
//
        lifecycleScope.launch {
            viewModel.error.collect { error ->
                binding.tvError.text = error
            }
        }
    }


    }






