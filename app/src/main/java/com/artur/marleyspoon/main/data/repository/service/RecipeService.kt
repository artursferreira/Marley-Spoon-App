package com.artur.marleyspoon.main.data.repository.service

import com.artur.marleyspoon.BuildConfig
import com.artur.marleyspoon.main.data.repository.models.RecipesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeService {

    @GET("entries")
    suspend fun getRecipes(
        @Query("access_token") accessToken: String = BuildConfig.ACCESS_TOKEN,
        @Query("content_type") contentType: String
    ): RecipesResponse

}