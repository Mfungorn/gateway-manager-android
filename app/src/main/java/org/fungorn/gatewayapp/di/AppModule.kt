package org.fungorn.gatewayapp.di

import org.fungorn.gatewayapp.data.dispatchers.MainDispatcher
import org.fungorn.gatewayapp.data.repositories.MainRepository
import org.fungorn.gatewayapp.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val appViewModelsModule = module {
    viewModel { MainViewModel(get()) }
}

private val appDataModule = module {
    single { MainDispatcher(get()) }

    single { MainRepository(get()) }
}

val appModule = listOf(appViewModelsModule, appDataModule)