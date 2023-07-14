package com.example.data.models

import com.example.domain.models.Balance

data class BalanceModel(
    override val amount: String?,
    override val currncy: String?
) : Balance