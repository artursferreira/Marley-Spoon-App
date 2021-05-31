package com.artur.marleyspoon.main.domain.repository

import com.artur.marleyspoon.main.domain.models.Recipe
import com.artur.marleyspoon.util.Result

interface RecipeRepository {

    suspend fun getRecipes() : Result<List<Recipe>>

}