package com.example.blue.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.blue.R
import com.example.blue.databinding.FragmentTransactionsBinding
import com.example.blue.util.OnBottomSheetCallbacks
import com.example.blue.viewmodels.TransactionViewModel
import com.example.data.models.TransactionModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class TransactionsFragment : BottomSheetDialogFragment(), OnBottomSheetCallbacks {

    private val viewModel: TransactionViewModel by activityViewModels()
    private var currentState: Int = BottomSheetBehavior.STATE_COLLAPSED

    lateinit var binding: FragmentTransactionsBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: TransactionAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getTransaction()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentTransactionsBinding.inflate(
            LayoutInflater.from(requireContext()),
            container,
            false
        )


        (activity as MainActivity).setOnBottomSheetCallbacks(this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        observeData()
    }

    private fun setUpRecyclerView() {
        recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.isNestedScrollingEnabled = true
    }

    private fun observeData() {
        viewModel.transactions.observe(viewLifecycleOwner, ::onGetTransaction)
    }

    private fun onGetTransaction(transactions: ArrayList<TransactionModel>) {
        adapter = TransactionAdapter(transactions)
        recyclerView.adapter = adapter
    }

    override fun onStateChanged(bottomSheet: View, newState: Int) {

    }

}