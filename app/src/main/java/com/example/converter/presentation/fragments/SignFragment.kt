package com.example.converter.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.converter.databinding.FragmentSignBinding
import java.text.DecimalFormat


class SignFragment : Fragment() {

    private var _binding: FragmentSignBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignBinding.inflate(inflater, container, false)
        val currencyValue = arguments?.getDouble(HomeFragment.CURRENCY_VALUE)
        val currencyName = arguments?.getString(HomeFragment.CURRENCY_CHAR_CODE)
        setListeners(currencyName, currencyValue)
        return binding.root
    }

    private fun setListeners(currencyName: String?, currencyValue: Double?) {
        binding.converterResultCurrency.text = currencyName
        binding.converterInputRub.addTextChangedListener {
            val convertedValue = binding.converterInputRub.text.toString()
            if (convertedValue != "" && currencyValue != null) {
                val numValue = convertedValue.toDouble()
                val multiply = currencyValue * numValue
                val convertedSum = DecimalFormat("#0.0000").format(multiply)
                binding.converterResultOutput.text = convertedSum.toString()
            } else {
                binding.converterResultOutput.text = ""
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}