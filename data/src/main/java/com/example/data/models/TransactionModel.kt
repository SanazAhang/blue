package com.example.data.models

import com.example.domain.models.AmountType
import com.example.domain.models.Transaction

data class TransactionModel(
    override val date: String?,
    override val amount: String?,
    override val amountType: AmountType,
    override val title: String?,
    override val id: Int?,
    override val icon: String?,
    override val currency: String?
) : Transaction
