package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MoovyGirlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moovy_girl)
    }
    fun openMainActivity(view: View) {
        val intent = Intent(
            this, MainActivity::class.java
        )
        startActivity(intent)
    }
}
