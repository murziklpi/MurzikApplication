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
import androidx.constraintlayout.widget.ConstraintLayout


class MainActivity : AppCompatActivity() {

    val LOG_TAG = "file.log"
    var iColorBoy = 0
    var iColorGirl = 0
    private lateinit var vTextViewBoy: TextView
    private lateinit var vTextViewGirl: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vTextViewBoy = findViewById(R.id.textViewBoy) as TextView
        vTextViewGirl = findViewById(R.id.textViewGirl) as TextView
//        Log.d(LOG_TAG,"onCreate color="+Storage.searchedTextViews.size)
        var vStyleArray = getIntent().getBooleanArrayExtra(STYLES)
        if (vStyleArray == null) {
            vStyleArray = booleanArrayOf(false, false)
            val intent = Intent(
                this, MoovyBoyActivity::class.java
            )
            intent.putExtra(STYLES, vStyleArray)
        } else {

        }
        val vColorArray = getIntent().getIntArrayExtra(COLORS)
        if (vColorArray != null) {
            vTextViewBoy.setTextColor(vColorArray[0])
            vTextViewGirl.setTextColor(vColorArray[1])
        }
        var key1Value = 0
        var key2Value = 0
        savedInstanceState?.run {
            key1Value = this.getInt("key1")
            key2Value = this.getInt("key2")
        }
        Log.d(LOG_TAG, "ColoronCreate key1:[$key1Value] key2:[$key2Value]")
    }

    fun openMoovyBoyActivity(view: View) {
        iColorBoy = R.color.colorPress.dec()
        vTextViewBoy.setTextColor(iColorBoy)
        val intent = Intent(
            this, MoovyBoyActivity::class.java
        )
        //       Storage.searchedTextViews.add(vTextViewBoy)
        setExtra("Girl", intent)
        startActivity(intent)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState color25")
        outState.putInt("key1", 2)
        outState.putInt("key2", 5)
        //Добавил 04-02-2020
        intent.putExtra(
            COLORS,
            intArrayOf(vTextViewBoy.currentTextColor, vTextViewGirl.currentTextColor)
        )
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState color25")

    }

    fun openMoovyGirlActivity(view: View) {
        setContentView(R.layout.activity_main)
        val tVGirl = findViewById(R.id.textViewGirl) as TextView
        //val appearance = theme.obtainStyledAttributes(tVGirl.resources, R.styleable.TextAppearance);

        val intent = Intent(
            this, MoovyGirlActivity::class.java
        )
        Log.d(TAG,"Style name=${tVGirl.getResources().getResourceEntryName(tVGirl.getId())}")
        setExtra("Girl", intent)
        startActivity(intent)
    }

    fun transferExtra(pIntentTo: Intent) {
        val vStyleArray = getIntent().getBooleanArrayExtra(STYLES)
        pIntentTo.putExtra(STYLES, vStyleArray)
    }

    fun setStyleFromExtra(txtView: TextView) {
        if (txtView != null) {
            val sNameWidget: String = txtView.getResources().getResourceEntryName(txtView.getId())

        }
        else {

        }
    }

    fun setExtra(pFilm: String, pIntent: Intent) {
        var blWork = false

        val vStyleArray = getIntent().getBooleanArrayExtra(STYLES)

        if (pFilm == "Boy" && (!vStyleArray[1])) {
            vStyleArray[1] = true
        }
        if (pFilm == "Girl" && (!vStyleArray[0])) {
            vStyleArray[0] = true
        }
        transferExtra(pIntent)

/*

*/

    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume color")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "Pause color")
    }


    fun onClickButtonGirlColor(view: View) {
        setContentView(R.layout.activity_main)
        val tVGirl = findViewById(R.id.textViewGirl) as TextView
        tVGirl.setTextAppearance(R.style.caption_film_viewed)
    }

    companion object {
        val TAG = MainActivity::class.java.simpleName
        const val STYLES = "saved_styles"
        const val COLORS = "saved_colors"
        const val COLOR_BOY = "saved_color_boy"
        const val OUR_REQUEST_CODE = 42
        const val ANSWER_TO_THE_ULTIMATE_QUESTION = "answer"
    }
}

