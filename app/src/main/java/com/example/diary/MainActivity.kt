package com.example.diary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.delay
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        //try{
            val newPageButton : Button = findViewById(R.id.newPageButton)
            newPageButton.setOnClickListener {
                setContentView(R.layout.new_page)
            }
            val readDiaryButton : Button = findViewById(R.id.readDiaryButton)
            readDiaryButton.setOnClickListener {
                setContentView(R.layout.read_diary)
                //set the title of the diary page to the device's date
                val title : TextView = findViewById(R.id.editTextTitle)
                val c = Calendar.getInstance()
                val year = c.get(Calendar.YEAR)
                val month = c.get(Calendar.MONTH)
                val day = c.get(Calendar.DAY_OF_MONTH)
                title.text = "$year/$month/$day"
                //recreate the view so that changes take place
                recreate()
            }
//        }
//        catch(e: Error){
//            println(e)
//        }
    }
}