package com.example.diary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val c : Context, private val notesList: List<String>, private val notesContent: List<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val noteTitle : TextView
        val noteBody : TextView

        init {
            noteTitle = itemView.findViewById(R.id.NoteTitle)
            noteBody = itemView.findViewById(R.id.NoteBody)
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.noteTitle.text = notesList[position]

        holder.noteBody.text = notesContent[position]

    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.note_preview, parent, false)
        return ViewHolder(view)
    }

}