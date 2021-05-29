package com.artur.marleyspoon.main.data.datasource.remote

import com.artur.marleyspoon.main.data.repository.models.RecipesResponse
import com.artur.marleyspoon.main.data.repository.service.RecipeService

class RemoteDataSourceImpl(private val recipeService: RecipeService) : RemoteDataSource {
    override suspend fun getRecipes(): RecipesResponse =
        recipeService.getRecipes(contentType = "recipe")
}