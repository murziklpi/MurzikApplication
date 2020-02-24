package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.LocaleList
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T




class MainActivity : AppCompatActivity() {

    val LOG_TAG = "file.log"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      //  Locale.setDefault(Locale.forLanguageTag("ru-RU"))
       // recreate()
        val localeRu = Locale("ru-RU")
        val conOur =Configuration()
        conOur.setLocale(localeRu)
//conOur.locales.
        // Set the locale of the new configuration
        Log.d("MainActivity.onCreate locale=",LocaleList.getDefault().toLanguageTags())
        var vStyleArray = getIntent().getBooleanArrayExtra(STYLES)
        if (vStyleArray == null) {
            vStyleArray = booleanArrayOf(false, false)
            getIntent().putExtra(STYLES, vStyleArray)
            Log.d("MainActivity.onCreate.styleArray first=", getIntent().getBooleanArrayExtra(STYLES).joinToString(","))
        } else {
            val vTxtView: TextView? = null
            setStyleFromExtra(vTxtView,getIntent())
            Log.d("MainActivity.onCreate.styleArray second=", intent.getBooleanArrayExtra(STYLES).joinToString(","))
        }
        savedInstanceState?.run {
        }
    }

    fun openMoovyBoyActivity(view: View) {
        val intent = Intent(
            this, MoovyBoyActivity::class.java
        )
        setExtra("Boy", intent)
        Log.d("openMoovyBoyActivity.styleArray=", intent.getBooleanArrayExtra(MainActivity.STYLES).joinToString(","))
        startActivity(intent)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "onRestoreInstanceState")
    }

    fun openMoovyGirlActivity(view: View) {
        setContentView(R.layout.activity_main)
        val tVGirl = findViewById(R.id.textViewGirl) as TextView
        //val appearance = theme.obtainStyledAttributes(tVGirl.resources, R.styleable.TextAppearance);

        val intent = Intent(
            this, MoovyGirlActivity::class.java
        )
        setExtra("Girl", intent)
        Log.d("openMoovyGirlActivity.styleArray",intent.getBooleanArrayExtra(STYLES).joinToString(","))
        startActivity(intent)
    }


    fun setStyleFromExtra(txtView: TextView?, pIntent: Intent) {
        val arExtra = pIntent.getBooleanArrayExtra(MainActivity.STYLES)
        Log.d("setStyleFromExtra.styleArray=", arExtra.joinToString(","))
        if (txtView != null) {
            val sNameWidget: String = txtView.getResources().getResourceEntryName(txtView.getId())

            if ((sNameWidget.contains("boy".toRegex(RegexOption.IGNORE_CASE)) && (arExtra[1]))
                || (sNameWidget.contains("girl".toRegex(RegexOption.IGNORE_CASE)) && (arExtra[0]))
            )
                txtView.setTextAppearance(R.style.caption_film_viewed)
        } else {
            if (arExtra[0])
                textViewGirl.setTextAppearance(R.style.caption_film_viewed)
            if (arExtra[1])
                textViewBoy.setTextAppearance(R.style.caption_film_viewed)
        }
    }

    fun setExtra(pFilm: String, pIntent: Intent) {
        var blWork = false

        val vStyleArray = getIntent().getBooleanArrayExtra(STYLES)

        if (pFilm.contains("boy".toRegex(RegexOption.IGNORE_CASE)) && (!vStyleArray[1])) {
            vStyleArray[1] = true
        }
        if (pFilm.contains("girl".toRegex(RegexOption.IGNORE_CASE)) && (!vStyleArray[0])) {
            vStyleArray[0] = true
        }
        getIntent().putExtra(STYLES, vStyleArray)
        Log.d("setExtra.(${pFilm}).styleArray=", getIntent().getBooleanArrayExtra(STYLES).joinToString(","))
        transferExtra(getIntent(),pIntent)

    }

    fun transferExtra(pIntentFrom: Intent, pIntentTo: Intent) {
        val vStyleArray = pIntentFrom.getBooleanArrayExtra(STYLES)
        pIntentTo.putExtra(STYLES, vStyleArray)
        Log.d("transferExtra.styleArray=", pIntentTo.getBooleanArrayExtra(STYLES).joinToString(","))
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume color")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "Pause color")
    }


    companion object {
        val TAG = MainActivity::class.java.simpleName
        const val STYLES = "saved_styles"
        const val OUR_REQUEST_CODE = 42
        const val ANSWER_TO_THE_ULTIMATE_QUESTION = "answer"
    }
}

