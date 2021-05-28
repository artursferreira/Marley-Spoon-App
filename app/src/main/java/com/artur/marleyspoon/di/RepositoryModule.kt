package com.artur.marleyspoon.di


import com.artur.marleyspoon.data.repository.RecipeRepository
import com.artur.marleyspoon.data.repository.RecipeRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<RecipeRepository> {
        RecipeRepositoryImpl(
            remoteDataSource = get()
        )
    }
}