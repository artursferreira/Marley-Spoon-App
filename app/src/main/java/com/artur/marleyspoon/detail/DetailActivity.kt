package com.artur.marleyspoon.detail

import android.graphics.Color
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import com.artur.marleyspoon.databinding.ActivityDetailBinding
import com.artur.marleyspoon.main.presentation.model.RecipeView
import com.artur.marleyspoon.main.presentation.ui.MainActivity.Companion.EXTRA_RECIPE
import com.bumptech.glide.Glide


class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupViews() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.collapsingToolbar.setExpandedTitleColor(Color.TRANSPARENT)

        val recipe = intent.getParcelableExtra<RecipeView>(EXTRA_RECIPE)

        recipe?.let {
            with(binding) {

                Glide.with(this@DetailActivity)
                    .load(it.imageUrl)
                    .into(recipeImageview)

                recipeTitle.text = it.title
                recipeChef.text = it.chefName
                recipeChef.visibility = if (it.chefName?.isNotEmpty() == true) VISIBLE else GONE
                recipeDescription.text = it.description

                if (it.tags.isNullOrEmpty())
                    recipeTags.visibility = GONE
                else {
                    val tags = StringBuilder()

                    it.tags.forEach {
                        tags.append("#$it  ")
                    }
                    recipeTags.text = tags
                    recipeTags.visibility = VISIBLE
                }
            }
        }
    }

}