package com.artur.marleyspoon.main.di

import com.artur.marleyspoon.BuildConfig
import com.artur.marleyspoon.main.presentation.ui.MainViewModel
import com.artur.marleyspoon.main.data.datasource.remote.RemoteDataSource
import com.artur.marleyspoon.main.data.datasource.remote.RemoteDataSourceImpl
import com.artur.marleyspoon.main.data.repository.RecipeRepositoryImpl
import com.artur.marleyspoon.main.domain.repository.RecipeRepository
import com.artur.marleyspoon.main.mapper.RecipesMapper
import com.artur.marleyspoon.main.mapper.RecipesMapperImpl
import com.contentful.java.cda.CDAClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val recipeModule = module {

    single<RemoteDataSource> { RemoteDataSourceImpl(cdaClient = get(), recipesMapper = get()) }

    single<RecipesMapper> { RecipesMapperImpl() }

    single<RecipeRepository> {
        RecipeRepositoryImpl(
            remoteDataSource = get()
        )
    }

    viewModel { MainViewModel(recipesMapper = get(), recipeRepository = get()) }

    single {
        CDAClient.builder()
            .setSpace(BuildConfig.SPACE_ID)
            .setEnvironment(BuildConfig.ENVIRONMENT_ID)
            .setToken(BuildConfig.ACCESS_TOKEN)
            .build()
    }
}