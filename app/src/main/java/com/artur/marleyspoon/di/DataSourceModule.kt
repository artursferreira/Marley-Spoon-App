package com.artur.marleyspoon.di

import com.artur.marleyspoon.data.datasource.remote.RemoteDataSource
import com.artur.marleyspoon.data.datasource.remote.RemoteDataSourceImpl
import org.koin.dsl.module


val dataSourceModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl(recipeService = get()) }
}