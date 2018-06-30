package com.example.young.constraintlayoutsample

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_d_placeholder.*

class FirstActivity : AppCompatActivity() {

    companion object {
        fun getIntent(context: Context): Intent {
            return Intent(context, FirstActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_d_placeholder)

        val onClickListener: View.OnClickListener = View.OnClickListener { view ->
            if (SDK_INT >= Build.VERSION_CODES.KITKAT) {
                // 入れ替わりのアニメーション
                TransitionManager.beginDelayedTransition(root as ViewGroup)
            }
            // Viewを入れ替える
            placeholder.setContentId(view.id)
        }

        // click eventを追加
        left.setOnClickListener(onClickListener)
        center.setOnClickListener(onClickListener)
        right.setOnClickListener(onClickListener)
    }
}
