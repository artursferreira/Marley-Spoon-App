package com.artur.marleyspoon.main.data.datasource.remote

import com.artur.marleyspoon.main.data.repository.models.RecipesResponse

interface RemoteDataSource {

    suspend fun getRecipes() : RecipesResponse
}