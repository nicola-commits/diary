package com.example.diary

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ReadPage: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.read_note)

        val ie = intent.extras

        if(ie != null){
            val pageTitle = ie.getString("title").toString()
            val pageBody = ie.getString("content").toString()

            findViewById<TextView>(R.id.noteTitle).text = pageTitle
            findViewById<TextView>(R.id.noteBody).text = pageBody

            //TODO improve

        } else {
            Toast.makeText(this, "Not implemented yet!", Toast.LENGTH_LONG).show()

            //finish()
        }
    }
}