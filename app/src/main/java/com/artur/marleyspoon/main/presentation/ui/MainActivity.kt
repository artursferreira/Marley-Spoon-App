package com.artur.marleyspoon.main.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import com.artur.marleyspoon.databinding.ActivityMainBinding
import com.artur.marleyspoon.detail.DetailActivity
import com.artur.marleyspoon.main.presentation.model.RecipeView
import com.artur.marleyspoon.main.presentation.ui.adapter.RecipeAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), RecipeAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    private val recipeAdapter = RecipeAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recipesRecyclerview.adapter = recipeAdapter

        viewModel.recipesLiveData.observe(this, {
            showItems(it)
        })
    }

    override fun onItemClicked(recipeItem: RecipeView) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(EXTRA_RECIPE, recipeItem)
        }
        startActivity(intent)
    }

    fun showItems(list : List<RecipeView>) {
        binding.progressCircular.visibility = GONE
        if (list.isNullOrEmpty()) {
            binding.recipesEmpty.visibility = VISIBLE
            binding.recipesRecyclerview.visibility = GONE
        } else {
            recipeAdapter.submitList(list)
            binding.recipesEmpty.visibility = GONE
            binding.recipesRecyclerview.visibility = VISIBLE
        }
    }

    companion object {
        const val EXTRA_RECIPE = "extra_recipe"
    }
}