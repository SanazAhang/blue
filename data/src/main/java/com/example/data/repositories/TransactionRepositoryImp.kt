package com.example.data.repositories

import com.example.data.models.BalanceModel
import com.example.data.models.TransactionModel
import com.example.domain.models.AmountType
import com.example.domain.models.Balance
import com.example.domain.models.Transaction
import com.example.domain.repositories.TransactionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TransactionRepositoryImp() : TransactionRepository {

    private fun createMockTransactionData(): Flow<ArrayList<TransactionModel>> {

        val transactionModel1 = TransactionModel(
            id = 1,
            title = "افزایش موجودی",
            date = "دوشنبه ۲ تیر ۱۶:۳۰ ۹۹",
            amount = "۱۲,۳۴۴۵",
            amountType = AmountType.Deposit,
            icon = "",
            currency = "ریال"
        )
        val transactionModel2 = TransactionModel(
            id = 2,
            title = "شارژ",
            date = "دوشنبه ۲ تیر ۱۶:۳۰ ۹۹",
            amount = "۵,۳۴۴۵",
            amountType = AmountType.Withdraw,
            icon = "atm",
            currency = "ریال"
        )
        val transactionModel3 = TransactionModel(
            id = 3,
            title = "خرید از فروشگاه",
            date = "دوشنبه ۲ تیر ۱۶:۳۰ ۹۹",
            amount = "۲۰,۳۴۴۵",
            amountType = AmountType.Withdraw,
            icon = "atm",
            currency = "ریال"
        )
        val transactionModel4 = TransactionModel(
            id = 4,
            title = "اینترنت",
            date = "دوشنبه ۲ تیر ۱۶:۳۰ ۹۹",
            amount = "۲۰,۳۴۴۵",
            amountType = AmountType.Withdraw,
            icon = "atm",
            currency = "ریال"
        )
        val transactionModel5 = TransactionModel(
            id = 5,
            title = "دریافت از حساب",
            date = "دوشنبه ۲ تیر ۱۶:۳۰ ۹۹",
            amount = "۱۳,۳۴۰",
            amountType = AmountType.Withdraw,
            icon = "atm",
            currency = "ریال"
        )
        val transactionModel6 = TransactionModel(
            id = 6,
            title = "انتقال به سپرده",
            date = "دوشنبه ۲ تیر ۱۶:۳۰ ۹۹",
            amount = "۱۳,۳۴۰",
            amountType = AmountType.Withdraw,
            icon = "remittance_transfer",
            currency = "ریال"
        )
        val transactionModel7 = TransactionModel(
            id = 7,
            date = "دوشنبه ۲ تیر ۱۶:۳۰ ۹۹",
            amount = "۸۰,۳۴۴",
            amountType = AmountType.Withdraw,
            title = "خری از فروشگاه",
            icon = "atm",
            currency = "ریال"
        )
        val transactionModel8 = TransactionModel(
            id = 8,
            date = "دوشنبه ۲ تیر ۱۶:۳۰ ۹۹",
            amount = "۹۲,۷۸۰",
            amountType = AmountType.Deposit,
            title = "افزایش موجودی",
            icon = "remittance_transfer",
            currency = "ریال"
        )
        val transactionModel9 = TransactionModel(
            id = 9,
            title = "خرید اینترنتی",
            date = "دوشنبه ۲ تیر ۱۶:۳۰ ۹۹",
            amount = "۱۳,۳۴۰",
            amountType = AmountType.Deposit,
            icon = "atm",
            currency = "ریال"
        )
        val transactionModel10 = TransactionModel(
            id = 10,
            title = "انتقال به باکس",
            date = "دوشنبه ۲ تیر ۱۶:۳۰ ۹۹",
            amount = "۲۰,۷۸۰",
            amountType = AmountType.Withdraw,
            icon = "remittance_transfer",
            currency = "ریال"
        )
        val transactionModel11 = TransactionModel(
            id = 11,
            title = "خرید اینترنتی",
            date = "دوشنبه ۲ تیر ۱۶:۳۰ ۹۹",
            amount = "۸,۳۴۴",
            amountType = AmountType.Withdraw,
            icon = "atm",
            currency = "ریال"
        )
        val transactionModel12 = TransactionModel(
            id = 12,
            title = "برگشت پول",
            date = "دوشنبه ۲ تیر ۱۶:۳۰ ۹۹",
            amount = "۴۴,۷۴۴",
            amountType = AmountType.Deposit,
            icon = "remittance_transfer",
            currency = "ریال"
        )

        val transactions = ArrayList<TransactionModel>()
        transactions.add(transactionModel1)
        transactions.add(transactionModel2)
        transactions.add(transactionModel3)
        transactions.add(transactionModel4)
        transactions.add(transactionModel5)
        transactions.add(transactionModel6)
        transactions.add(transactionModel7)
        transactions.add(transactionModel8)
        transactions.add(transactionModel9)
        transactions.add(transactionModel10)
        transactions.add(transactionModel11)
        transactions.add(transactionModel12)
        return flowOf(transactions)
    }

    private fun createBalanceModel(): Flow<BalanceModel> {
        val balance = BalanceModel(amount = "۹۲۰,۷۸۰,۳۴۴۵", currncy = "ریال")
        return flowOf(balance)
    }

    override suspend fun getTransaction(): Flow<ArrayList<Transaction>> {
        return createMockTransactionData() as Flow<ArrayList<Transaction>>
    }

    override suspend fun getBalance(): Flow<Balance> {
        return createBalanceModel()
    }
}