package com.example.converter.di

import com.example.converter.data.cache.HomeCache
import com.example.converter.data.cache.HomeCacheImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface CacheModule {
    @Binds
    @Singleton
    fun bindsCachePage(memoryCacheImpl: HomeCacheImpl): HomeCache
}