package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


val LOG_TAG = "file.log"

class MoovyBoyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moovy_boy)
        val tVBoy = findViewById(R.id.textViewBoy) as TextView
        Log.d(LOG_TAG,"MoovyBoyActivity.onCreate.styleArray=${getIntent().getBooleanArrayExtra(MainActivity.STYLES).joinToString(",")}")
        val mainAct=MainActivity()
            mainAct.setStyleFromExtra(tVBoy,getIntent())
    }

    fun openMainActivity(view: View) {
        val intent = Intent(
            this, MainActivity::class.java
        )
        MainActivity().transferExtra(getIntent(),intent)
        Log.d(LOG_TAG,"MoovyBoyActivity.openMainActivity.styleArray=${
            intent.getBooleanArrayExtra(MainActivity.STYLES).joinToString(",")}")
        startActivity(intent)



    }

    fun buttonInviteBoyBySmsOnClick(view: View) {
        val toSms = "smsto:+79110171100"
        val messageText = "Приглашение"
        val sms = Intent(Intent.ACTION_SENDTO, Uri.parse(toSms))

        sms.putExtra("sms_body", messageText)
        startActivity(sms)
    }

}
