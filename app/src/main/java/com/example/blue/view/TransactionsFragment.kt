package com.example.blue.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.blue.databinding.FragmentTransactionsBinding
import com.example.blue.util.OnBottomSheetCallbacks
import com.example.blue.viewmodels.TransactionViewModel
import com.example.data.models.TransactionModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class TransactionsFragment : BottomSheetDialogFragment(), OnBottomSheetCallbacks {

    private val viewModel: TransactionViewModel by activityViewModels()

    lateinit var binding: FragmentTransactionsBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: TransactionAdapter
    private var firstTime = true

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
        binding.shimmerLayout.startShimmer()
        setUpRecyclerView()
        observeData()
        handle()
    }

    private fun setUpRecyclerView() {
        recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.isNestedScrollingEnabled = true
    }

    private fun observeData() {
        handleViewVisibility()
        viewModel.transactions.observe(viewLifecycleOwner, ::onGetTransaction)
    }

    private fun handleViewVisibility() {
        binding.shimmerLayout.animate()

        binding.shimmerLayout.animate()
            .translationY(binding.shimmerLayout.height.toFloat())
            .alpha(0.0f)
            .setDuration(300)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    binding.shimmerLayout.visibility = View.GONE
                    binding.recyclerview.visibility = View.VISIBLE
                }
            })
    }

    private fun onGetTransaction(transactions: ArrayList<TransactionModel>) {
        adapter = TransactionAdapter(transactions)
        recyclerView.adapter = adapter
    }

    fun handle() {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val firstVisiblePosition =
                    (recyclerView.layoutManager as LinearLayoutManager?)!!.findFirstCompletelyVisibleItemPosition()
                if (firstVisiblePosition == 0) {
                    if (!firstTime) {
                        (activity as MainActivity).closeBottomSheet()
                    } else firstTime = !firstTime
                }
            }
        })
    }

    override fun onStateChanged(bottomSheet: View, newState: Int) {}
}