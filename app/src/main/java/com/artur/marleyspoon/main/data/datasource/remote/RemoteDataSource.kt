package com.artur.marleyspoon.main.data.datasource.remote

import com.artur.marleyspoon.main.domain.models.Recipe
import com.artur.marleyspoon.util.Result

interface RemoteDataSource {

    suspend fun getRecipes() : Result<List<Recipe>>
}