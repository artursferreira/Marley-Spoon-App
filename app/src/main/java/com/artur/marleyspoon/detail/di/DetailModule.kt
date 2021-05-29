package com.artur.marleyspoon.detail.di

import com.artur.marleyspoon.detail.DetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailModule = module {
    viewModel { DetailViewModel() }
}