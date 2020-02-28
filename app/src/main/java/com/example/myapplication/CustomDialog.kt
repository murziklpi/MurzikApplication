package com.example.myapplication

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import java.lang.System.exit

class CustomDialog(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.custom_dialog)
        val buttonCancel = findViewById<Button>(R.id.dialog_button_cancel)
        buttonCancel.setOnClickListener {
            dismiss()
        }

        val buttonOk = findViewById<Button>(R.id.dialog_button_ok)
        buttonOk.setOnClickListener {
            System.exit(0)
        }

    }

}