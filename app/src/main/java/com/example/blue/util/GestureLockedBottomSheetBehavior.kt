package com.example.blue.util

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior

class GestureLockedBottomSheetBehavior<v : View>(context: Context, attributeSet: AttributeSet?) :
    BottomSheetBehavior<v>(context, attributeSet) {
    constructor(context: Context) : this(context, null)

    override fun onInterceptTouchEvent(
        parent: CoordinatorLayout,
        child: v,
        event: MotionEvent
    ): Boolean = false

    override fun onTouchEvent(parent: CoordinatorLayout, child: v, event: MotionEvent): Boolean =
        true

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: v,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean = false

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout,
        child: v,
        target: View,
        dx: Int,
        dy: Int,
        consumed: IntArray,
        type: Int
    ) {
    }

    override fun onStopNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: v,
        target: View,
        type: Int
    ) {
    }

    override fun onNestedFling(
        coordinatorLayout: CoordinatorLayout,
        child: v,
        target: View,
        velocityX: Float,
        velocityY: Float,
        consumed: Boolean
    ): Boolean = false
}