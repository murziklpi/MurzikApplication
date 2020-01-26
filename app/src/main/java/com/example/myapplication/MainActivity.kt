package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    val LOG_TAG = "file.log"
    var iColorBoy = 0
    var iColorGirl = 0
    private lateinit var vTextViewBoy: TextView
    private lateinit var vTextViewGirl: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vTextViewBoy=findViewById(R.id.textViewBoy) as TextView
        vTextViewGirl=findViewById(R.id.textViewGirl) as TextView
        savedInstanceState?.apply {
            iColorBoy=this.getInt(COLOR_BOY,-13)
            if (iColorBoy != 0) {
                vTextViewBoy.setTextColor(iColorBoy.toString().toInt())
            }
            Log.d(
                LOG_TAG,
                "onCreate, colorBoy=" + iColorBoy
            )
        }
        Log.d(LOG_TAG,"onCreate color="+savedInstanceState)
    }

    fun openMoovyBoyActivity(view: View) {
        iColorBoy = R.color.colorPress.dec()
        vTextViewBoy.setTextColor(iColorBoy)
        val intent = Intent(
            this, MoovyBoyActivity::class.java
        )
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG,"onResume color")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG,"Pause color")
    }

    fun openMoovyGirlActivity(view: View) {
        setContentView(R.layout.activity_main)
        val tVGirl = findViewById(R.id.textViewGirl) as TextView
        tVGirl.setTextColor(R.color.colorPress.dec())

        val intent = Intent(
            this, MoovyGirlActivity::class.java
        )
        intent.putExtra("colorGirl", tVGirl.currentTextColor)
        startActivity(intent)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        Log.d(
            LOG_TAG,
            "onRestoreInstanceStateW, colorGirl="
        )

    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Restore state members from saved instance
        savedInstanceState?.run {
            Log.d(
                LOG_TAG,
                "onRestoreInstanceState, colorGirl=" + savedInstanceState.getInt("colorGirl")
            )
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        setContentView(R.layout.activity_main)
        outState.putInt(COLOR_BOY, iColorBoy)
        Log.d(
            LOG_TAG,
            "onSaveInstanceState, colorBoy=" + iColorBoy
        )
    }

    fun onClickButtonGirlColor(view: View) {
        setContentView(R.layout.activity_main)
        val tVGirl = findViewById(R.id.textViewGirl) as TextView
        tVGirl.setTextColor(R.color.colorPress.dec())

    }

    companion object {
        val TAG = MainActivity::class.java.simpleName
        const val COLOR_BOY = "saved_color_boy"
        const val OUR_REQUEST_CODE = 42
        const val ANSWER_TO_THE_ULTIMATE_QUESTION = "answer"
    }
}

