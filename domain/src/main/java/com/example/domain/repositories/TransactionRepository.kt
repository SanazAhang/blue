package com.example.domain.repositories

import com.example.domain.models.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {

    suspend fun getTransaction(): Flow<Transaction>
}