package com.artur.marleyspoon.main.mapper

import android.widget.RemoteViews
import com.artur.marleyspoon.main.data.repository.models.RecipesResponse
import com.artur.marleyspoon.main.domain.models.Recipe
import com.artur.marleyspoon.main.presentation.model.RecipeView

interface RecipesMapper {

    fun mapRemoteRecipeToDomain(recipesResponse: RecipesResponse): List<Recipe>

    fun mapDomainRecipesToPresentation(domainRecipes: List<Recipe>) : List<RecipeView>

    fun mapDomainRecipeToPresentation(domainRecipe: Recipe) : RecipeView

}