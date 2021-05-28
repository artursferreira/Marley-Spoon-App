package com.artur.marleyspoon.data.repository

import com.artur.marleyspoon.data.datasource.remote.RemoteDataSource

class RecipeRepositoryImpl(private val remoteDataSource: RemoteDataSource) : RecipeRepository {
}