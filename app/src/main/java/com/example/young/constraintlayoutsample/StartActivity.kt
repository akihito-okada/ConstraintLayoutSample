package com.example.young.constraintlayoutsample

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.content_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        first.setOnClickListener {
            startActivity(FirstActivity.getIntent(this))
        }
        second.setOnClickListener {
            startActivity(SecondActivity.getIntent(this))
        }
    }
}
