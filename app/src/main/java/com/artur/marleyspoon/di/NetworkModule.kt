package com.artur.marleyspoon.di

import com.artur.marleyspoon.BuildConfig
import com.artur.marleyspoon.data.service.RecipeService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://cdn.contentful.com/spaces/${BuildConfig.SPACE_ID}/environments/${BuildConfig.ENVIRONMENT_ID}/"

val networkModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(RecipeService::class.java) }

}