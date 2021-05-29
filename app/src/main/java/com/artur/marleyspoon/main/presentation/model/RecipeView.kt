package com.artur.marleyspoon.main.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RecipeView(
    val id: String? = null,
    val title: String? = null,
    val calories: Int? = null,
    val chefName: String? = null,
    val description: String? = null,
    val imageUrl: String? = null,
    val tags: List<String>? = emptyList()
) : Parcelable