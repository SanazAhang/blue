package com.example.domain.repositories

import com.example.domain.models.Balance
import com.example.domain.models.Transaction
import kotlinx.coroutines.flow.Flow

interface TransactionRepository {

    suspend fun getTransaction(): Flow<ArrayList<Transaction>>

    suspend fun getBalance(): Flow<Balance>
}