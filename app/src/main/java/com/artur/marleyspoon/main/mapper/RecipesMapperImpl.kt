package com.artur.marleyspoon.main.mapper

import com.artur.marleyspoon.main.data.repository.models.RecipesResponse
import com.artur.marleyspoon.main.domain.models.Recipe
import com.artur.marleyspoon.main.presentation.model.RecipeView

internal class RecipesMapperImpl : RecipesMapper {

    override fun mapRemoteRecipeToDomain(recipesResponse: RecipesResponse): List<Recipe> {
        return recipesResponse.items?.map {
            Recipe(
                id = it?.sys?.id,
                title = it?.fields?.title,
                calories = it?.fields?.calories,
                /* chefName = it?.fields?.chef?.,*/
                description = it?.fields?.description,
                /* imageUrl = it?.fields?.photo?.sys*/
            )
        } ?: emptyList()
    }

    override fun mapDomainRecipesToPresentation(domainRecipes: List<Recipe>): List<RecipeView> {
        return domainRecipes.map { mapDomainRecipeToPresentation(it) }
    }

    override fun mapDomainRecipeToPresentation(domainRecipe: Recipe): RecipeView {
        return RecipeView(
            id = domainRecipe.id,
            title = domainRecipe.title,
            calories = domainRecipe.calories,
            chefName = domainRecipe.chefName,
            description = domainRecipe.description,
            imageUrl = domainRecipe.imageUrl,
            tags = domainRecipe.tags
        )
    }
}