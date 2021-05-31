package com.artur.marleyspoon.main.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artur.marleyspoon.databinding.ActivityMainBinding
import com.artur.marleyspoon.detail.DetailActivity
import com.artur.marleyspoon.main.presentation.model.RecipeView
import com.artur.marleyspoon.main.presentation.ui.adapter.RecipeAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), RecipeAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    private val recipeAdapter = RecipeAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recipesRecyclerview.adapter = recipeAdapter

        viewModel.getRecipes()

        viewModel.recipesLiveData.observe(this, {
            if (it.isNullOrEmpty()) {
                //show error
            } else {
                recipeAdapter.submitList(it)
            }
        })
    }

    override fun onItemClicked(recipeItem: RecipeView) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(EXTRA_RECIPE, recipeItem)
        }
        startActivity(intent)
    }

    companion object {
        const val EXTRA_RECIPE = "extra_recipe"
    }
}