package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnBoy = findViewById<Button>(R.id.buttonBoy)
        btnBoy.setOnClickListener(clickListenerBoy)
        val btnGirl = findViewById<Button>(R.id.buttonGirl)
        btnGirl.setOnClickListener(clickListenerGirl)
    }

    private val clickListenerBoy: View.OnClickListener = View.OnClickListener { _ ->
        setContentView(R.layout.activity_main)
        val tVBoy = findViewById(R.id.textViewBoy) as TextView
        tVBoy.setTextColor(R.color.colorPress.dec())
    }

    private val clickListenerGirl: View.OnClickListener = View.OnClickListener { _ ->
        setContentView(R.layout.activity_main)
        val tVGirl = findViewById(R.id.textViewGirl) as TextView
        tVGirl.setTextColor(R.color.colorPress.dec())
    }

}
