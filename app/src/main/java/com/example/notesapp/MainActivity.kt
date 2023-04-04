package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noresapp.Note

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var Mnotes = mutableListOf(

            Note("one"),
            Note("two"),
            Note("three"),
            Note("four"),
            Note("five"),
            Note("six"),
            Note("seven"),
            Note("eight"),
        )
        val rv = findViewById<RecyclerView>(R.id.RCView)
        val et = findViewById<EditText>(R.id.ET1)
        val bt = findViewById<Button>(R.id.saveButton)

        val adapter = NoteAdapter(Mnotes)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

        bt.setOnClickListener(View.OnClickListener {

            val texts = et.text

            if (texts.isBlank()){
                Toast.makeText(this, "Please Enter a valid note!", Toast.LENGTH_SHORT)
            } else{
                Mnotes.add(Note(texts.toString()))
                et.text.clear()
            }
            adapter.notifyItemInserted(Mnotes.size-1)
        })

    }
}