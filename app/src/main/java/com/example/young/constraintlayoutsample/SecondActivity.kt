package com.example.young.constraintlayoutsample

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import android.view.View
import android.support.constraint.ConstraintSet

import kotlinx.android.synthetic.main.layout_d_animation_first.*

class SecondActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, SecondActivity::class.java)
        }
    }

    var constraintSetFirst = ConstraintSet()
    var constraintSetSecond = ConstraintSet()
    var state = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_d_animation_first)

        // Viewの状態(ConstraintSet)を保持
        constraintSetFirst.clone(root)
        constraintSetSecond.clone(this, R.layout.layout_d_animation_second)

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            // KitKat以下は非対応 (T_T)
            return
        }

        // eventをセット
        val onClickListener = View.OnClickListener {
            transition()
        }
        left.setOnClickListener(onClickListener)
        right.setOnClickListener(onClickListener)
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private fun transition() {
        // Animationをセット
        TransitionManager.beginDelayedTransition(root)

        if (state) {
            // mainのLayoutを使う
            constraintSetFirst.applyTo(root)
        } else {
            // Second Layoutを使う
            constraintSetSecond.applyTo(root)
        }

        // stateを更新
        state = !state
    }
}
