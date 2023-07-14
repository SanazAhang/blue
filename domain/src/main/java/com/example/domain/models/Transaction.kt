package com.example.domain.models

interface Transaction {
    val id:Int?
    val date: String?
    val amount: String?
    val amountType: AmountType
    val title: String?
    val icon:String?
    val currency:String?
}