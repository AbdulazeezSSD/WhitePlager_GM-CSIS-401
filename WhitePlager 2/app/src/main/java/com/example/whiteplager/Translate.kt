package com.example.whiteplager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.mashape.unirest.http.Unirest
import kotlinx.android.synthetic.main.activity_keywords.*
import kotlinx.android.synthetic.main.activity_options.*
import kotlinx.android.synthetic.main.activity_synonym.*
import kotlinx.android.synthetic.main.activity_translate.*
import org.jetbrains.anko.doAsync
import org.json.JSONObject

class Translate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translate)
        val actionBar = supportActionBar
        actionBar!!.title = "Translate"
        val Syn1 = findViewById<EditText>(R.id.Syn1)
        val resetbtn2 = findViewById<Button>(R.id.tran_B2)
        resetbtn2.setOnClickListener {
            Syn1.getText().clear()
        }
        tran_B2.setOnClickListener {
                var input = Syn1.text.toString()
                doAsync {
                    var response =
                            Unirest.get("https://twinword-word-graph-dictionary.p.rapidapi.com/definition/?entry=" + input)
                                    .header("x-rapidapi-key", "75fb271d36msh275c3a0e2bde88ep12ad5ejsn88e6f8c3fcf8")
                                    .header("x-rapidapi-host", "twinword-word-graph-dictionary.p.rapidapi.com")
                                    .asString();

                    var output = response.body
                    var filter = JSONObject(output).getString("noun")
                    tv1.text = filter.toString()
                }

            }
        }
    }
