package com.example.diary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        val newPageButton : Button = findViewById(R.id.newPageButton)
        newPageButton.setOnClickListener {
            val intent = Intent(this@MainActivity, NewPage::class.java)
            startActivity(intent)
        }

        val readDiaryButton : Button = findViewById(R.id.readDiaryButton)
        readDiaryButton.setOnClickListener {
            val intent = Intent(this@MainActivity, ReadDiary::class.java)
            startActivity(intent)
        }
    }
}