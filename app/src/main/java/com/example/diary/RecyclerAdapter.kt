package com.example.diary

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val c : Context, private val notesList: List<String>, private val notesContent: List<String>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val noteTitle : TextView
        val noteBody : TextView
        val deleteButton : Button

        init {
            noteTitle = itemView.findViewById(R.id.NoteTitle)
            noteBody = itemView.findViewById(R.id.NoteBody)
            deleteButton = itemView.findViewById(R.id.deleteNoteButton)
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.setOnClickListener {

            //TODO setOnClickListener for element in RecyclerView
            if(it.id != R.id.deleteNoteButton) {

                Toast.makeText(holder.itemView.context, "TODO!", Toast.LENGTH_LONG).show()

                val intent = Intent(holder.itemView.context, ReadPage::class.java)
                intent.putExtra("title", notesList[position])
                intent.putExtra("content", notesContent[position])
                holder.itemView.context.startActivity(intent)

            }

        }

        holder.noteTitle.text = notesList[position]

        holder.noteBody.text = notesContent[position]

        holder.deleteButton.setOnClickListener {

            //TODO delete note

        }

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