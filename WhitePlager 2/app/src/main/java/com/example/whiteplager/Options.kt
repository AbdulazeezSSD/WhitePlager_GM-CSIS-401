package com.example.whiteplager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_options.*

class Options : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)
        b1.setOnClickListener{
            val intent= Intent(this,Keywords::class.java)
            startActivity(intent)
        }
        b3.setOnClickListener{
            val intent= Intent(this,Translate::class.java)
            startActivity(intent)
        }
        b2.setOnClickListener{
            val intent= Intent(this,Synonym::class.java)
            startActivity(intent)
        }
    }
}

















/*
val nameEt = findViewById<EditText>(R.id.editTextTextMultiLine)

val actionBar = supportActionBar

actionBar!!.title = "First Activity!"



val button = findViewById<Button>(R.id.b1)
button.setOnClickListener{
    val name = nameEt.text.toString()

    val intent = Intent(this, Plage::class.java)
    intent.putExtra("Name", name)
    startActivity(intent)
}
*/