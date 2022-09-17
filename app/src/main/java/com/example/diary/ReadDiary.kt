package com.example.diary

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ReadDiary: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.read_diary)

        val delimiter = getString(R.string.list_delimiter)
        //set backHome button
        val bhb : Button = findViewById(R.id.backHomeButtonRead)
        bhb.setOnClickListener {
            val i = Intent(this@ReadDiary, MainActivity::class.java)
            startActivity(i)
        }

        //read saved files
        val sp = getSharedPreferences("sharedPrefs", MODE_PRIVATE)
        val notes = sp.getString("allNotes", null)

        if(notes == null){
            //no notes found
            Toast.makeText(this, "No notes found!", Toast.LENGTH_LONG).show()
            val i = Intent(this@ReadDiary, MainActivity::class.java)
            startActivity(i)
        } else{

            val notesList : List<String> = notes.split(delimiter)

            val notesContent : MutableList<String> = mutableListOf()

            notesList.forEach{
                val add = sp.getString(it, "Error")
                notesContent.add(add!!)
            }

            println(notesList)

            println("asdasd")

            println(notesContent)

            println(delimiter)

            val adapter = RecyclerAdapter(this, notesList, notesContent.toList())

            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)

        }



    }

}