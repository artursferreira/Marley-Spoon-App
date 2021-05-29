package com.artur.marleyspoon.main.domain.repository

import com.artur.marleyspoon.main.domain.models.Recipe

interface RecipeRepository {

    suspend fun getRecipes() : List<Recipe>

}