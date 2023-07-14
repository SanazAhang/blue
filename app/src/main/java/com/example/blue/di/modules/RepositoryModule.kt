package com.example.blue.di.modules

import com.example.data.repositories.TransactionRepositoryImp
import com.example.domain.repositories.TransactionRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(): TransactionRepository {
        return TransactionRepositoryImp()
    }
}