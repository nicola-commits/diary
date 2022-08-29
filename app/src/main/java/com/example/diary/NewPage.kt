package com.example.diary

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

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
            val delimiter = getString(R.string.list_delimiter)

            if(noteTitle == null || noteTitle == "" || noteTitle.contains(delimiter)) {

                Toast.makeText(this, "Invalid title! Title can't be empty or contain $delimiter!", Toast.LENGTH_LONG).show()

            } else{

                val sp = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
                val editor = sp.edit()
                //get current notes, then add to them if the current one isn't there
                var notes = sp.getString("allNotes", null)
                editor.remove("allNotes") //so that it can be overwritten

                if(notes == null){
                    //in this case the note we want to save is the first note of the user, so we can just do it "manually"
                    editor.apply{
                        putString("allNotes", noteTitle.toString())
                        putString(noteTitle.toString(), noteBody.toString())
                    }.apply()

                } else{
                    //the user has already written at least another note
                    //add the delimiter and the name of the note at the end
                    notes = notes + delimiter + noteTitle

                    editor.apply{
                        putString("allNotes", notes)
                        putString(noteTitle.toString(), noteBody.toString())
                    }.apply()
                }

                Toast.makeText(this, "Data saved!", Toast.LENGTH_LONG).show()

                val i = Intent(this@NewPage, MainActivity::class.java)
                startActivity(i)

            }
        }
    }
}