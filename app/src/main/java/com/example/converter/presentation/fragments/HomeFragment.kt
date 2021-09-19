package com.example.converter.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.converter.R
import com.example.converter.data.Answer
import com.example.converter.domain.entity.CurrencyDto
import com.example.converter.databinding.FragmentHomeBinding
import com.example.converter.di.DaggerViewModelFactory
import com.example.converter.di.appComponent
import com.example.converter.presentation.recycler.RecyclerAdapter
import com.example.converter.presentation.viewmodels.HomeViewModel
import javax.inject.Inject


class HomeFragment : Fragment() {

    companion object {
        const val CURRENCY_CHAR_CODE = "CURRENCY_CHAR_CODE"
        const val CURRENCY_VALUE = "CURRENCY_VALUE"
    }

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel by lazy {
        ViewModelProvider(requireActivity(), viewModelFactory)[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDagger()
        getRecycler()
    }

    private fun initDagger() {
        requireActivity().appComponent
            .registerHomeComponent()
            .create()
            .inject(this)
    }

    private fun getRecycler() {
        val recyclerAdapter = RecyclerAdapter(
            fragmentTransaction = {
                fragmentTransaction(it)
            }
        )
        homeViewModel.getAnswer().observe(viewLifecycleOwner) {
            if (it is Answer.Success) {
                recyclerAdapter.items = it.jsonResponseDto
                    .currenciesList
                    .values
                    .toMutableList()
            } else {
                //Add shimmer
            }
        }
        binding.cardRecycler.adapter = recyclerAdapter
    }


    private fun fragmentTransaction(currencyDto: CurrencyDto) {
        val fragment = SignFragment()
        val args = Bundle()
        args.putString(CURRENCY_CHAR_CODE, currencyDto.charCode)
        args.putDouble(CURRENCY_VALUE, currencyDto.value)
        val backStateName = fragment.javaClass.name
        fragment.arguments = args
        parentFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_content_main, fragment)
            .addToBackStack(backStateName)
            .commit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}