package com.artur.marleyspoon.main.di

import com.artur.marleyspoon.main.presentation.ui.MainViewModel
import com.artur.marleyspoon.main.data.datasource.remote.RemoteDataSource
import com.artur.marleyspoon.main.data.datasource.remote.RemoteDataSourceImpl
import com.artur.marleyspoon.main.data.repository.RecipeRepositoryImpl
import com.artur.marleyspoon.main.data.repository.service.RecipeService
import com.artur.marleyspoon.main.domain.repository.RecipeRepository
import com.artur.marleyspoon.main.mapper.RecipesMapper
import com.artur.marleyspoon.main.mapper.RecipesMapperImpl
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val mainModule = module {

    single<RemoteDataSource> { RemoteDataSourceImpl(recipeService = get()) }

    single<RecipesMapper> { RecipesMapperImpl() }

    single<RecipeRepository> {
        RecipeRepositoryImpl(
            recipesMapper = get(),
            remoteDataSource = get()
        )
    }

    viewModel { MainViewModel(recipesMapper = get(), recipeRepository = get()) }

    single { get<Retrofit>().create(RecipeService::class.java) }
}