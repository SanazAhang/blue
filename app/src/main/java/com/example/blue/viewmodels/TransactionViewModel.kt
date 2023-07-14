package com.example.blue.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.models.BalanceModel
import com.example.data.models.TransactionModel
import com.example.domain.models.Balance
import com.example.domain.usecases.GetBalanceUseCase
import com.example.domain.usecases.GetTransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val getTransactionUseCase: GetTransactionUseCase,
    private val getBalanceUseCase: GetBalanceUseCase
) : ViewModel() {

    private val _balance: MutableLiveData<BalanceModel> = MutableLiveData()
    val balance: LiveData<BalanceModel> = _balance

    private val _transactions:MutableLiveData<ArrayList<TransactionModel>> = MutableLiveData()
    val transactions: LiveData<ArrayList<TransactionModel>> = _transactions

    fun getBalance() {
        viewModelScope.launch {
            getBalanceUseCase.execute(Unit).collect { balance ->
                _balance.postValue(balance as BalanceModel)
            }
        }

    }

    fun getTransaction() {
        viewModelScope.launch {
            getTransactionUseCase.execute(Unit).collect { transactions ->
                _transactions.postValue(transactions as ArrayList<TransactionModel> )
            }
        }

    }
}