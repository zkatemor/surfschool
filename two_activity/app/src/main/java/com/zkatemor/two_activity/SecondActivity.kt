package com.zkatemor.two_activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val message = intent.getStringExtra("message")

        val infoTextView = findViewById<TextView>(R.id.textView)
        infoTextView.text = message
    }
}