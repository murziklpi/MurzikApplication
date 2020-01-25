package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun openMoovyBoyActivity(view: View) {
        setContentView(R.layout.activity_main)
        val tVBoy = findViewById(R.id.textViewBoy) as TextView
        tVBoy.setTextColor(R.color.colorPress.dec())
        val intent = Intent(
            this, MoovyBoyActivity::class.java
        )
        startActivity(intent)
    }

    fun openMoovyGirlActivity(view: View) {
        setContentView(R.layout.activity_main)
        val tVGirl = findViewById(R.id.textViewGirl) as TextView
        tVGirl.setTextColor(R.color.colorPress.dec())
        val intent = Intent(
            this, MoovyGirlActivity::class.java
        )
        startActivity(intent)
    }
}
