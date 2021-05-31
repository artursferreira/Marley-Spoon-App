package com.artur.marleyspoon.detail.di

import com.artur.marleyspoon.detail.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailModule = module {
    viewModel { DetailViewModel() }
}