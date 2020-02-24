package com.example.myapplication

import android.content.Intent
import android.net.Uri
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
        Log.d(LOG_TAG,"MoovyGirlActivity.onCreate Array=${getIntent().getBooleanArrayExtra(MainActivity.STYLES).joinToString(",")}")
        MainActivity().setStyleFromExtra(textViewGirl,getIntent())
    }

    fun openMainActivity(view: View) {
        val intent = Intent(
            this, MainActivity::class.java
        )
        MainActivity().transferExtra(getIntent(),intent)
        startActivity(intent)
    }


    fun buttonInviteGirlBySmsOnClick(view: View) {
        val toSms = "smsto:+79110171100"
        val messageText = "Приглашение"
        val sms = Intent(Intent.ACTION_SENDTO, Uri.parse(toSms))

        sms.putExtra("sms_body", messageText)
        startActivity(sms)
    }
}
