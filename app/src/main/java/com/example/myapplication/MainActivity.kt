package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
//import android.R
import android.widget.TextView
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {

    val tVBoy: TextView=findViewById(R.id.textViewBoy);
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonGirlClick(view: View) {
        tVBoy.setTextColor(ContextCompat.getColor(tVBoy?.context,R.color.colorPress))
    }
}
