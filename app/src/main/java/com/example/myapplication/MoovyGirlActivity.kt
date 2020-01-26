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
        val tVGirl = findViewById(R.id.textViewGirl) as TextView
        tVGirl.setTextColor(getIntent().getIntArrayExtra(MainActivity.COLORS)[1])
    }

    fun openMainActivity(view: View) {
        val intent = Intent(
            this, MainActivity::class.java
        )
        intent.putExtra(MainActivity.COLORS,getIntent().getIntArrayExtra(MainActivity.COLORS))
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
