package com.example.diary

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Base64
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.io.*
import java.security.InvalidParameterException

class NewPage: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_page)

        //onClick of the back to home button
        val backHomeButton : Button = findViewById(R.id.backHomeButton)
        backHomeButton.setOnClickListener {

            //save all the work
            val noteTitle = findViewById<TextView>(R.id.editTextTitle).text
            val noteBody = findViewById<TextView>(R.id.editTextTextMultiLine).text

            if(noteTitle != null && noteTitle != "") {

                val sp = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
                sp.edit().apply{
                    putString(noteTitle.toString(), noteBody.toString())
                }.apply()

                Toast.makeText(this, "Data saved!", Toast.LENGTH_LONG).show()

                val i: Intent = Intent(this@NewPage, MainActivity::class.java)
                startActivity(i)
            }

            else{
                Toast.makeText(this, "Invalid title", Toast.LENGTH_LONG).show()
            }
        }
    }
}