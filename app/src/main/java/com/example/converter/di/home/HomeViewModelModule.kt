package com.example.converter.di.home

import androidx.lifecycle.ViewModel
import com.example.converter.data.remote.HomeRemoteSource
import com.example.converter.data.remote.HomeRemoteSourceImpl
import com.example.converter.data.repository.HomeRepository
import com.example.converter.data.repository.HomeRepositoryImpl
import com.example.converter.di.keys.ViewModelKey
import com.example.converter.di.scope.FragmentScope
import com.example.converter.presentation.viewmodels.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewModelModule {

    @ViewModelKey(HomeViewModel::class)
    @FragmentScope
    @IntoMap
    @Binds
    abstract fun bindsHomeViewModule(
        homeViewModel: HomeViewModel
    ): ViewModel

    @Binds
    @FragmentScope
    abstract fun bindsPageRepository(
        homeRepositoryImpl: HomeRepositoryImpl
    ): HomeRepository

    @Binds
    @FragmentScope
    abstract fun bindsPageRemoteSource(
        homeRemoteSource: HomeRemoteSourceImpl
    ): HomeRemoteSource
}