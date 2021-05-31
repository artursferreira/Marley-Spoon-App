package com.artur.marleyspoon.main

import com.artur.marleyspoon.main.domain.models.Recipe
import com.artur.marleyspoon.main.mapper.RecipesMapper
import com.artur.marleyspoon.main.mapper.RecipesMapperImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Test

@ExperimentalCoroutinesApi
class RecipesMapperUnitTest {

    private val recipesMapper: RecipesMapper = RecipesMapperImpl()

    @Test
    fun `assert map remote to domain has correct data`() = runBlockingTest {

    }

    @Test
    fun `assert map domain to presentation has correct data`() = runBlockingTest {

        val domainRecipe = Recipe(
            id = "0",
            title = "Title",
            calories = 10.0,
            chefName = "Chef Name",
            description = "description",
            imageUrl = "image",
            tags = listOf("tag1", "tag2")
        )

        val domainRecipe2 = domainRecipe.copy(id = "1")

        val domainList = listOf(domainRecipe, domainRecipe2)

        val presentationList = recipesMapper.mapDomainRecipesToPresentation(domainList)

        val recipe = presentationList.first()

        assertEquals(
            "Presentation list size is not the same as domain list",
            domainList.size,
            presentationList.size
        )

        assertEquals(
            "Presentation recipe id is not the same as domain recipe",
            domainRecipe.id,
            recipe.id
        )

        assertEquals(
            "Presentation recipe title is not the same as domain recipe",
            domainRecipe.title,
            recipe.title
        )

        assertEquals(
            "Presentation recipe calories is not the same as domain recipe",
            domainRecipe.calories,
            recipe.calories
        )
        assertEquals(
            "Presentation recipe chefName is not the same as domain recipe",
            domainRecipe.chefName,
            recipe.chefName
        )
        assertEquals(
            "Presentation recipe description is not the same as domain recipe",
            domainRecipe.description,
            recipe.description
        )
        assertEquals(
            "Presentation recipe imageUrl is not the same as domain recipe",
            domainRecipe.imageUrl,
            recipe.imageUrl
        )

        assertEquals(
            "Presentation recipe tags is not the same as domain recipe",
            domainRecipe.tags,
            recipe.tags
        )

    }

}