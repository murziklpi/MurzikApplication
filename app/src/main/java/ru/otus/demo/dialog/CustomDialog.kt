package ru.otus.demo.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button


class CustomDialog(context: Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog)
        val button = findViewById<Button>(R.id.dialog_button)
        button.setOnClickListener {
            //Do something
            dismiss()
        }
    }

}