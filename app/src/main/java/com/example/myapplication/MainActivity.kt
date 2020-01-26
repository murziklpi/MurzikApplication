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
        Log.d(LOG_TAG,"onCreate color="+getIntent())
        val vColorArray=getIntent().getIntArrayExtra(COLORS)
        if (vColorArray!=null ) {
            vTextViewBoy.setTextColor(vColorArray[0])
            vTextViewGirl.setTextColor(vColorArray[1])
        }
    }

    fun openMoovyBoyActivity(view: View) {
        iColorBoy = R.color.colorPress.dec()
        vTextViewBoy.setTextColor(iColorBoy)
        val intent = Intent(
            this, MoovyBoyActivity::class.java
        )
        intent.putExtra(COLORS,intArrayOf(vTextViewBoy.currentTextColor,vTextViewGirl.currentTextColor))
        startActivity(intent)
    }

    fun openMoovyGirlActivity(view: View) {
        iColorGirl = R.color.colorPress.dec()
        vTextViewGirl.setTextColor(iColorGirl)
        val intent = Intent(
            this, MoovyGirlActivity::class.java
        )
        Log.d(LOG_TAG,
        "colorArray="+intArrayOf(vTextViewBoy.currentTextColor,vTextViewGirl.currentTextColor).last().toString())
        intent.putExtra(COLORS,intArrayOf(vTextViewBoy.currentTextColor,vTextViewGirl.currentTextColor))
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


    fun onClickButtonGirlColor(view: View) {
        setContentView(R.layout.activity_main)
        val tVGirl = findViewById(R.id.textViewGirl) as TextView
        tVGirl.setTextColor(R.color.colorPress.dec())
    }

    companion object {
        val TAG = MainActivity::class.java.simpleName
        const val COLORS="saved_colors"
        const val COLOR_BOY = "saved_color_boy"
        const val OUR_REQUEST_CODE = 42
        const val ANSWER_TO_THE_ULTIMATE_QUESTION = "answer"
    }
}

