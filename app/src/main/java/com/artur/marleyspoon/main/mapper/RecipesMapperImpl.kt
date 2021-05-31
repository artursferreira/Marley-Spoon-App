package com.artur.marleyspoon.main.mapper

import com.artur.marleyspoon.main.domain.models.Recipe
import com.artur.marleyspoon.main.presentation.model.RecipeView
import com.artur.marleyspoon.util.Constants.RECIPE_CALORIES
import com.artur.marleyspoon.util.Constants.RECIPE_CHEF
import com.artur.marleyspoon.util.Constants.RECIPE_DESCRIPTION
import com.artur.marleyspoon.util.Constants.RECIPE_NAME
import com.artur.marleyspoon.util.Constants.RECIPE_PHOTO
import com.artur.marleyspoon.util.Constants.RECIPE_TAGS
import com.artur.marleyspoon.util.Constants.RECIPE_TITLE
import com.contentful.java.cda.CDAArray
import com.contentful.java.cda.CDAAsset
import com.contentful.java.cda.CDAEntry
import com.contentful.java.cda.LocalizedResource
import com.contentful.java.cda.image.ImageOption

internal class RecipesMapperImpl : RecipesMapper {

    override fun mapRemoteRecipeToDomain(recipesResponse: CDAArray): List<Recipe> {
        return recipesResponse.items()?.map {
            Recipe(
                id = it?.id(),
                title = (it as LocalizedResource).getField<String>(RECIPE_TITLE),
                calories = it.getField<Double>(RECIPE_CALORIES),
                chefName = it.getField<CDAEntry>(RECIPE_CHEF)?.getField<String>(RECIPE_NAME),
                description = it.getField<String>(RECIPE_DESCRIPTION),
                 imageUrl = it.getField<CDAAsset>(RECIPE_PHOTO)
                     ?.urlForImageWith(ImageOption.https()),
                tags = it.getField<ArrayList<CDAEntry>>(RECIPE_TAGS)
                ?.map { tag -> tag.getField(RECIPE_NAME) }
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