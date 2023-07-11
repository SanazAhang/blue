package com.example.domain.usecases

import com.example.domain.models.Transaction
import com.example.domain.repositories.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTransactionUseCase @Inject constructor(private val transactionRepository: TransactionRepository) :
    BaseUseCase<Unit, Flow<Transaction>> {
    override suspend fun execute(inpute: Unit): Flow<Transaction> {
        return transactionRepository.getTransaction()
    }
}