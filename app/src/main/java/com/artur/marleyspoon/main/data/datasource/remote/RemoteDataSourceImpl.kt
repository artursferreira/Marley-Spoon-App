package com.artur.marleyspoon.main.data.datasource.remote

import com.artur.marleyspoon.util.Constants.CONTENTFUL_CONTENT_TYPE_RECIPE
import com.contentful.java.cda.CDAArray
import com.contentful.java.cda.CDAClient
import com.contentful.java.cda.CDAEntry

class RemoteDataSourceImpl(private val cdaClient: CDAClient) : RemoteDataSource {
    override suspend fun getRecipes(): CDAArray {
        return cdaClient.fetch(CDAEntry::class.java)
            .withContentType(CONTENTFUL_CONTENT_TYPE_RECIPE)
            .include(2)
            .all()
    }
}