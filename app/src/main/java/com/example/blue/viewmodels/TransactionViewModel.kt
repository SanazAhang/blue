package com.example.blue.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.models.BalanceModel
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

    fun getBalance() {
        viewModelScope.launch {
            getBalanceUseCase.execute(Unit).collect { balance ->
                _balance.postValue(balance as BalanceModel)
            }
        }

    }
}