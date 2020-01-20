package ru.otus.demo.dialog

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.DialogInterface
import android.os.Bundle
import android.text.method.CharacterPickerDialog
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    fun showCharacterPickerDialog(view: View?) {
        val options = "0123456789"
        val dialog: CharacterPickerDialog = object : CharacterPickerDialog(
            this,
            View(this),
            null, options,
            false
        ) {
            override fun onClick(v: View) {
                Toast.makeText(
                    applicationContext,
                    "OnClick() " + (v as Button).text.toString(),
                    Toast.LENGTH_SHORT
                ).show()
                dismiss()
            }
        }
        dialog.show()
    }

    fun showAlertDialog(view: View?) {
        val bld: AlertDialog.Builder = AlertDialog.Builder(this)
        val lst =
            DialogInterface.OnClickListener { dialog, which -> dialog.dismiss() }
        bld.setMessage("Could you rate us?")
        bld.setTitle("Hi!")
        bld.setNegativeButton("No", lst)
        bld.setNeutralButton("Later", lst)
        bld.setPositiveButton("Agree :)", lst)
        val dialog: AlertDialog = bld.create()
        dialog.show()
    }


    fun showDatePickerDialog(view: View?) {
        val listener =
            OnDateSetListener { listeningView, year, monthOfYear, dayOfMonth ->
                //Do something
            }
        val newCalendar = Calendar.getInstance()
        val dialog = DatePickerDialog(
            this,
            listener,
            newCalendar[Calendar.YEAR],
            newCalendar[Calendar.MONTH],
            newCalendar[Calendar.DAY_OF_MONTH]
        )
        dialog.show()
    }


    fun showTimePickerDialog(view: View?) {
        val listener =
            OnTimeSetListener { listeningView, hourOfDay, minute ->
                //Do something
            }
        val newCalendar = Calendar.getInstance()
        val startTime = TimePickerDialog(
            this, listener,
            newCalendar[Calendar.HOUR_OF_DAY],
            newCalendar[Calendar.MINUTE],
            true
        )
        startTime.show()
    }

    fun showCustomDialog(view: View?) {
        val dialog: Dialog = CustomDialog(this)
        dialog.setOnShowListener {
            //DO something
            Log.d(MainActivity.TAG, "onShow")
        }
        dialog.setOnDismissListener {
            //DO something
            Log.d(MainActivity.TAG, "onDismiss")
        }
        dialog.setOnCancelListener {
            //DO something
            Log.d(MainActivity.TAG, "onCancel")
        }
        dialog.show()
    }


    companion object {
        const val TAG = "ExampleDialog"
    }
}
