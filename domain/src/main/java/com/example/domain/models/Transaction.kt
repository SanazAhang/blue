package com.example.domain.models

interface Transaction {
    val id:Int?
    val date: String?
    val amount: String?
    val amountType: String?
    val title: String?
}