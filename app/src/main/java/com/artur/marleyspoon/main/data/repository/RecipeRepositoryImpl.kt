package com.artur.marleyspoon.main.data.repository

import com.artur.marleyspoon.main.data.datasource.remote.RemoteDataSource
import com.artur.marleyspoon.main.data.repository.models.RecipesResponse
import com.artur.marleyspoon.main.domain.models.Recipe
import com.artur.marleyspoon.main.domain.repository.RecipeRepository
import com.artur.marleyspoon.main.mapper.RecipesMapper
import com.artur.marleyspoon.util.Result
import com.artur.marleyspoon.util.succeeded
import com.contentful.java.cda.CDAArray

class RecipeRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
) : RecipeRepository {

    override suspend fun getRecipes(): Result<List<Recipe>> = remoteDataSource.getRecipes()


}