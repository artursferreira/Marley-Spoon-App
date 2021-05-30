package com.artur.marleyspoon.main.data.datasource.remote

import com.artur.marleyspoon.main.data.repository.models.RecipesResponse
import com.contentful.java.cda.CDAArray

interface RemoteDataSource {

    suspend fun getRecipes() : CDAArray
}