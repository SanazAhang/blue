package com.example.blue

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.blue.databinding.FragmentTransactionsBinding
import com.example.blue.util.OnBottomSheetCallbacks
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class TransactionsFragment : BottomSheetDialogFragment(), OnBottomSheetCallbacks {


    private var currentState: Int = BottomSheetBehavior.STATE_COLLAPSED

    lateinit var binding: FragmentTransactionsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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
        binding.textResult.setOnClickListener {
            (activity as MainActivity).closeBottomSheet()
        }

        binding.filterImage.setOnClickListener {
            if (currentState ==BottomSheetBehavior.STATE_EXPANDED)
                (activity as MainActivity).closeBottomSheet()
            else
                (activity as MainActivity).openBottomSheet()
        }
    }

    override fun onStateChanged(bottomSheet: View, newState: Int) {
        currentState = newState
        when(newState){
            BottomSheetBehavior.STATE_EXPANDED ->{
                binding.textResult.text = "0 results"
                binding.filterImage.setImageResource(R.drawable.add)
            }
            BottomSheetBehavior.STATE_COLLAPSED ->{
                binding.textResult.text = "see the resualt"
                binding.filterImage.setImageResource(R.drawable.deposit_gift)
            }
        }
    }

}