package com.artur.marleyspoon.main.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.artur.marleyspoon.databinding.RecipeItemBinding
import com.artur.marleyspoon.main.presentation.model.RecipeView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.google.android.material.chip.Chip


class RecipeAdapter(private val itemClickListener: OnItemClickListener) :
    ListAdapter<RecipeView, RecipeAdapter.RecipeHolder>(object :
        DiffUtil.ItemCallback<RecipeView>() {
        override fun areItemsTheSame(oldItem: RecipeView, newItem: RecipeView): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RecipeView, newItem: RecipeView): Boolean {
            return oldItem == newItem
        }
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeHolder {
        val itemBinding =
            RecipeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        val holder = RecipeHolder(itemBinding)

        holder.itemView.setOnClickListener { itemClickListener.onItemClicked(currentList[holder.adapterPosition]) }

        return holder
    }

    override fun onBindViewHolder(holder: RecipeHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class RecipeHolder(private val itemBinding: RecipeItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(recipe: RecipeView) {
            with(itemBinding) {
                recipeTitle.text = recipe.title

                if (recipe.tags.isNullOrEmpty())
                    recipeTags.visibility = GONE
                else {
                    val tags = StringBuilder()

                    recipe.tags.forEach {
                        tags.append("#$it  ")
                    }
                    recipeTags.text = tags
                    recipeTags.visibility = VISIBLE
                }

                Glide.with(recipeImageview)
                    .load(recipe.imageUrl)
                    .transform(CircleCrop())
                    .into(recipeImageview)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClicked(recipeItem: RecipeView)
    }

}