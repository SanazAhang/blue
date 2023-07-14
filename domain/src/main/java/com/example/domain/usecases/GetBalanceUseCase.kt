package com.example.domain.usecases

import com.example.domain.models.Balance
import com.example.domain.repositories.TransactionRepository
import kotlinx.coroutines.flow.Flow

class GetBalanceUseCase(private val transactionRepository: TransactionRepository) :
    BaseUseCase<Unit, Flow<Balance>> {
    override suspend fun execute(inpute: Unit): Flow<Balance> = transactionRepository.getBalance()
}