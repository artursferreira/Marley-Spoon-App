package com.artur.marleyspoon.main.data.repository

import com.artur.marleyspoon.main.data.datasource.remote.RemoteDataSource
import com.artur.marleyspoon.main.data.repository.models.RecipesResponse
import com.artur.marleyspoon.main.domain.models.Recipe
import com.artur.marleyspoon.main.domain.repository.RecipeRepository
import com.artur.marleyspoon.main.mapper.RecipesMapper

class RecipeRepositoryImpl(
    private val recipesMapper: RecipesMapper,
    private val remoteDataSource: RemoteDataSource
) : RecipeRepository {

    override suspend fun getRecipes(): List<Recipe> =
        recipesMapper.mapRemoteRecipeToDomain(remoteDataSource.getRecipes())

}