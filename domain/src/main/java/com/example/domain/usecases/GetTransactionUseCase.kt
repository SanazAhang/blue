package com.example.domain.usecases

import com.example.domain.models.Transaction
import com.example.domain.repositories.TransactionRepository
import kotlinx.coroutines.flow.Flow

class GetTransactionUseCase(private val transactionRepository: TransactionRepository) :
    BaseUseCase<Unit, Flow<ArrayList<Transaction>>> {
    override suspend fun execute(inpute: Unit): Flow<ArrayList<Transaction>> {
        return transactionRepository.getTransaction()
    }
}