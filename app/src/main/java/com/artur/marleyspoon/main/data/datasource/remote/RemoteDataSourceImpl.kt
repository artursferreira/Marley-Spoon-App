package com.artur.marleyspoon.main.data.datasource.remote

import com.artur.marleyspoon.main.domain.models.Recipe
import com.artur.marleyspoon.main.mapper.RecipesMapper
import com.artur.marleyspoon.util.Constants.CONTENTFUL_CONTENT_TYPE_RECIPE
import com.artur.marleyspoon.util.Result
import com.contentful.java.cda.CDAArray
import com.contentful.java.cda.CDAClient
import com.contentful.java.cda.CDAEntry

class RemoteDataSourceImpl(
    private val cdaClient: CDAClient,
    private val recipesMapper: RecipesMapper,
) : RemoteDataSource {
    override suspend fun getRecipes(): Result<List<Recipe>> {
        return try {
            val result = cdaClient.fetch(CDAEntry::class.java)
                .withContentType(CONTENTFUL_CONTENT_TYPE_RECIPE)
                .include(2)
                .all()
            Result.Success(recipesMapper.mapRemoteRecipeToDomain(result))
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}