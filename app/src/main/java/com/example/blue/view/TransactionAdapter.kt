package com.example.blue.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.blue.databinding.TransactionItemBinding
import com.example.data.models.TransactionModel

class TransactionAdapter(val transactions: List<TransactionModel>) :
    RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TransactionAdapter.ViewHolder {
        val binding =
            TransactionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionAdapter.ViewHolder, position: Int) {
    }

    override fun getItemCount(): Int {
       return transactions.size
    }

    inner class ViewHolder(binding: TransactionItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}