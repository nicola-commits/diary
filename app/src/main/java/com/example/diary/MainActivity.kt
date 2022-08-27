package com.example.diary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        try{
            val newPageButton : Button = findViewById(R.id.newPageButton)
            newPageButton.setOnClickListener {
                setContentView(R.layout.new_page)
            }
            val readDiaryButton : Button = findViewById(R.id.readDiaryButton)
            readDiaryButton.setOnClickListener {
                setContentView(R.layout.read_diary)
            }
        }
        catch(e: Error){
            println(e)
        }
    }
}