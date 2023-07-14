package com.example.blue.di.modules

import com.example.domain.repositories.TransactionRepository
import com.example.domain.usecases.GetBalanceUseCase
import com.example.domain.usecases.GetTransactionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    @Singleton
    fun provideGetTransactionUseCase(transactionRepository: TransactionRepository): GetTransactionUseCase =
        GetTransactionUseCase(transactionRepository)

    @Provides
    @Singleton
    fun provideGetBalanceUseCase(transactionRepository: TransactionRepository): GetBalanceUseCase =
        GetBalanceUseCase(transactionRepository)
}