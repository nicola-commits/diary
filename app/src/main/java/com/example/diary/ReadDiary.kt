package com.example.diary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ReadDiary: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.read_diary)

        val txt : TextView = findViewById(R.id.AllNotesTextView)
        //set backHome button
        val bhb : Button = findViewById(R.id.backHomeButtonRead)
        bhb.setOnClickListener {
            val i = Intent(this@ReadDiary, MainActivity::class.java)
            startActivity(i)
        }

        //read saved files
        val sp = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
        val notes = sp.getString("allNotes", null)

        txt.text = notes.toString()


        Toast.makeText(this, notes, Toast.LENGTH_LONG).show()


    }
}