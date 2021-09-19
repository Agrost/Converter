package com.example.converter.di.home

import com.example.converter.di.scope.FragmentScope
import com.example.converter.presentation.fragments.HomeFragment
import dagger.Subcomponent

@Subcomponent(modules = [HomeViewModelModule::class])
@FragmentScope
interface HomeComponent {

    fun inject(homeFragment: HomeFragment)

    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeComponent
    }
}