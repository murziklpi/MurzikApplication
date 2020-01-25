package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.R.id.message
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.net.Uri


class MoovyBoyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moovy_boy)
    }

    fun openMainActivity(view: View) {
        val intent = Intent(
            this, MainActivity::class.java
        )
        startActivity(intent)
    }

    fun buttonInviteBySmsOnClick(view: View) {
        val toSms = "smsto:+79110171100"
        val messageText = "Приглашение"
        val sms = Intent(Intent.ACTION_SENDTO, Uri.parse(toSms))

        sms.putExtra("sms_body", messageText)
        startActivity(sms)
    }
}