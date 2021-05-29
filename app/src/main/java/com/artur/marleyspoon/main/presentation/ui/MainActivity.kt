package com.artur.marleyspoon.main.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.artur.marleyspoon.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getRecipes()

        viewModel.recipesLiveData.observe(this, {

        })
    }
}