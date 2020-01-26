package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_moovy_girl.*

class MoovyGirlActivity : AppCompatActivity() {

    val LOG_TAG = "file.log"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moovy_girl)
        val iColor=getIntent().getSerializableExtra("colorGirl")
        Log.d(LOG_TAG, "onCreateGirl, colorFromINtent=" + iColor)
        val tVGirl = findViewById(R.id.textViewGirl) as TextView
        tVGirl.setTextColor(iColor.toString().toInt())
    }

    fun openMainActivity(view: View) {
        val intent = Intent(
            this, MainActivity::class.java
        )
        setContentView(R.layout.activity_moovy_girl)
      //  val tVGirl = findViewById(R.id.textViewGirl) as TextView
        intent.putExtra("colorGirl",getIntent().getSerializableExtra("colorGirl"))
        Log.d(LOG_TAG, "openMainActivityFromGirl, colorGirl=" + getIntent().getSerializableExtra("colorGirl"))
        startActivity(intent)
    }
}
