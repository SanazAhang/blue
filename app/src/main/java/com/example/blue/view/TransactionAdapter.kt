package com.example.blue.view

import android.content.Context
import android.content.res.Resources
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.blue.R
import com.example.blue.databinding.TransactionItemBinding
import com.example.data.models.TransactionModel
import com.example.domain.models.AmountType


class TransactionAdapter(val transactions: List<TransactionModel>) :
    RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {

    lateinit var context: Context
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TransactionAdapter.ViewHolder {
        val binding =
            TransactionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        context = parent.context
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(transactions[position]) {
                binding.titleTextView.text = title
                binding.descriptionTextView.text = date
                binding.priceTextView.text = "$amount $currency"
                val icone = getDrawable(icon)
                binding.icon.setImageDrawable(icone)
                when (amountType) {
                    AmountType.Deposit -> {
                        binding.priceTextView.background =
                            context.resources.getDrawable(R.drawable.squar_shape)

                        binding.icon.setBackgroundColor(getColorId())
                    }

                    else -> {
                        binding.priceTextView.setBackgroundColor(Color.TRANSPARENT)
                        binding.icon.setBackgroundColor(Color.TRANSPARENT)
                    }
                }
            }
        }
    }

    fun getColorId(): Int {
        val typedValue = TypedValue()
        val a: TypedArray = context.obtainStyledAttributes(
            typedValue.data,
            intArrayOf(R.attr.descriptionItemHighlight)
        )
        return a.getColor(0, 0)
    }


    private fun getDrawable(name: String?): Drawable? {
        val resources: Resources = context.resources
        val resourceId = resources.getIdentifier(
            name, "drawable",
            context.packageName
        )
        return resources.getDrawable(resourceId)
    }

    override fun getItemCount(): Int = transactions.size


    inner class ViewHolder(val binding: TransactionItemBinding) :

        RecyclerView.ViewHolder(binding.root)
}