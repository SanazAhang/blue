package com.example.blue.view

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.blue.R
import com.example.blue.databinding.ActivityMainBinding
import com.example.blue.util.OnBottomSheetCallbacks
import com.example.blue.viewmodels.TransactionViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_COLLAPSED
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val viewModel: TransactionViewModel by viewModels()

    private var listener: OnBottomSheetCallbacks? = null
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        super.onCreate(savedInstanceState)
        //removing the shadow from the action bar
        supportActionBar?.elevation = 0f
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getBalance()
        observeData()
        configureBackdrop()
    }


    fun setOnBottomSheetCallbacks(onBottomSheetCallbacks: OnBottomSheetCallbacks) {
        this.listener = onBottomSheetCallbacks
    }

    fun closeBottomSheet() {
        mBottomSheetBehavior?.state = STATE_COLLAPSED

    }

    private var mBottomSheetBehavior: BottomSheetBehavior<View?>? = null

    private fun configureBackdrop() {
        val fragment = supportFragmentManager.findFragmentById(R.id.transaction_fragment)

        fragment?.view?.let {
            BottomSheetBehavior.from(it).let { bottomSheet ->
                bottomSheet.addBottomSheetCallback(object :
                    BottomSheetBehavior.BottomSheetCallback() {
                    override fun onSlide(bottomSheet: View, slideOffset: Float) {}

                    override fun onStateChanged(bottomSheet: View, newState: Int) {
                        if (newState == STATE_COLLAPSED) {
                            val heightOfFragment = fragment.view?.measuredHeight
                            val heightOfHeaderSection = binding.relativeLayout.measuredHeight
                            val heightOfToolbar = binding.toolBar.root.measuredHeight
                            if (heightOfFragment != null) {
                                mBottomSheetBehavior?.peekHeight =
                                    (heightOfFragment - heightOfHeaderSection + heightOfToolbar + 10)
                            }
                        }

                        listener?.onStateChanged(bottomSheet, newState)

                    }
                })

                bottomSheet.state = STATE_COLLAPSED
                mBottomSheetBehavior = bottomSheet
            }
        }
    }

    private fun observeData() {
        viewModel.balance.observe(this) { balance ->
            binding.balanceTextView.text = " ${balance.amount} ${balance.currncy}"
        }
    }

}