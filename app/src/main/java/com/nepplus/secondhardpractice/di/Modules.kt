package com.nepplus.secondhardpractice.di

import com.google.gson.GsonBuilder
import com.nepplus.secondhardpractice.network.Client
import com.nepplus.secondhardpractice.remotedatasource.GithubRepository
import com.nepplus.secondhardpractice.remotedatasource.GithubRepositoryImpl
import com.nepplus.secondhardpractice.viewmodel.GithubViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val utilModule = module {
    single { GsonBuilder().setPrettyPrinting().create() }
}

val repositoryModule = module {
    single { Client(get()) }
    single <GithubRepository> { GithubRepositoryImpl(get())}
}

val viewModelModule = module {
    viewModel { GithubViewModel(get()) }
}

val applicationModule = listOf(
    utilModule, repositoryModule, viewModelModule
)