package com.artur.marleyspoon.di

import com.artur.marleyspoon.ui.detail.DetailViewModel
import com.artur.marleyspoon.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { DetailViewModel() }
}