package com.example.data.repositories

import com.example.data.models.TransactionModel
import com.example.domain.models.Transaction
import com.example.domain.repositories.TransactionRepository
import kotlinx.coroutines.flow.Flow

class TransactionRepositoryImp():TransactionRepository {


    fun createMockTransactionData(){
        val transactionModel = TransactionModel()
    }

    override suspend fun getTransaction(): Flow<Transaction> {
        TODO("Not yet implemented")
    }
}