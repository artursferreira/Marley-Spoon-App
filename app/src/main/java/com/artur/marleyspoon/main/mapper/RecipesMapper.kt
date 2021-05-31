package com.artur.marleyspoon.main.mapper

import com.artur.marleyspoon.main.domain.models.Recipe
import com.artur.marleyspoon.main.presentation.model.RecipeView
import com.contentful.java.cda.CDAArray

interface RecipesMapper {

    fun mapRemoteRecipeToDomain(recipesResponse: CDAArray): List<Recipe>

    fun mapDomainRecipesToPresentation(domainRecipes: List<Recipe>) : List<RecipeView>

    fun mapDomainRecipeToPresentation(domainRecipe: Recipe) : RecipeView

}