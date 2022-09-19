package com.example.diary

import android.content.Context
import com.google.gson.Gson

class User {
    private var data:HashMap<String, String?>? = hashMapOf("name" to null, "notes" to null, "theme" to "light", "language" to "english")
    private var notes:Map<String, Map<String, String?>>? = hashMapOf()

    fun getData(name: String): String? {
        return this.data!![name]
    }

    fun setData(name:String, value:String?) {
        this.data!![name] = value
    }

    fun saveData(c: Context){
        val sp = c.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor = sp.edit()
        val gson = Gson()
        val json = gson.toJson(this)
        editor.putString("MyObject", json)
        editor.apply()
    }

}