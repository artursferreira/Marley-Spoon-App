package com.artur.marleyspoon.main.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(
    val id: String? = null,
    val title: String? = null,
    val calories: Double? = null,
    val chefName: String? = null,
    val description: String? = null,
    val imageUrl: String? = null,
    val tags: List<String>? = emptyList()
) : Parcelable