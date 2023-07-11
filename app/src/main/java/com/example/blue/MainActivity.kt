package com.example.blue

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.blue.util.OnBottomSheetCallbacks
import com.example.blue.viewmodels.TransactionViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val viewModel: TransactionViewModel by viewModels()

    private var listener: OnBottomSheetCallbacks? = null

    override fun onCreate(savedInstanceState: Bundle?) {
//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
//        )
        super.onCreate(savedInstanceState)
        //removing the shadow from the action bar
        supportActionBar?.elevation = 0f

        setContentView(R.layout.activity_main)
        viewModel.getBalance()
        viewModel.balance.observe(this) { balance ->
            Toast.makeText(this, "*****$balance.amount", Toast.LENGTH_LONG).show()

        }
        configureBackdrop()
    }


    fun setOnBottomSheetCallbacks(onBottomSheetCallbacks: OnBottomSheetCallbacks) {
        this.listener = onBottomSheetCallbacks
    }

    fun closeBottomSheet() {
        mBottomSheetBehavior?.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    fun openBottomSheet() {
        mBottomSheetBehavior?.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private var mBottomSheetBehavior: BottomSheetBehavior<View?>? = null

    private fun configureBackdrop() {
        val fragment = supportFragmentManager.findFragmentById(R.id.transaction_fragment)

        fragment?.view?.let {
            BottomSheetBehavior.from(it).let { bottomSheet ->
                bottomSheet.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                    override fun onSlide(bottomSheet: View, slideOffset: Float) {}

                    override fun onStateChanged(bottomSheet: View, newState: Int) {
                        listener?.onStateChanged(bottomSheet, newState)
                    }
                })

                bottomSheet.state = BottomSheetBehavior.STATE_COLLAPSED
                mBottomSheetBehavior = bottomSheet
            }
        }
    }
}