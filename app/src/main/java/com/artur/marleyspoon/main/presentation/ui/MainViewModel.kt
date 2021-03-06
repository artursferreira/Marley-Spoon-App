package com.artur.marleyspoon.main.presentation.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artur.marleyspoon.main.data.repository.models.RecipesResponse
import com.artur.marleyspoon.main.domain.repository.RecipeRepository
import com.artur.marleyspoon.main.mapper.RecipesMapper
import com.artur.marleyspoon.main.presentation.model.RecipeView
import com.artur.marleyspoon.util.Result
import com.artur.marleyspoon.util.succeeded
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val recipesMapper: RecipesMapper,
    private val recipeRepository: RecipeRepository
) : ViewModel() {

    val recipesLiveData: LiveData<List<RecipeView>>
        get() = _recipesLiveData
    private val _recipesLiveData: MutableLiveData<List<RecipeView>> = MutableLiveData()

    init {
        getRecipes()
    }

    private fun getRecipes() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = recipeRepository.getRecipes()
            if (result.succeeded) {
                val list =
                    recipesMapper.mapDomainRecipesToPresentation((result as Result.Success).data)
                _recipesLiveData.postValue(list)
            } else {
                _recipesLiveData.postValue(emptyList())
            }
        }
    }

}