package com.example.data.models

import com.example.domain.models.Transaction

data class TransactionModel(
    override val date: String?,
    override val amount: String?,
    override val amountType: String?,
    override val title: String?,
    override val id: Int?
) : Transaction
