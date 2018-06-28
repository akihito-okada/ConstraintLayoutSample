package com.example.young.constraintlayoutsample

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addAnimationOperations()
    }

    private fun addAnimationOperations() {
        var toggleState = false
        // はじめのViewの初期化
        val constraintFirst = ConstraintSet()
        constraintFirst.clone(root_view)

        // ふたつめのViewの初期化
        val constraintSecond = ConstraintSet()
        constraintSecond.clone(this, R.layout.activity_main_alt)

        // リスナの追加
        image_view.setOnClickListener{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                TransitionManager.beginDelayedTransition(root_view)
                val constraint = if (toggleState) constraintFirst else constraintSecond
                constraint.applyTo(root_view)
                toggleState = !toggleState
            }
        }
    }
}
