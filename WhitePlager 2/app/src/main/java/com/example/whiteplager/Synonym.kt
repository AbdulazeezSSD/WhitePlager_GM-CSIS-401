package com.example.whiteplager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.mashape.unirest.http.Unirest
import kotlinx.android.synthetic.main.activity_keywords.*
import kotlinx.android.synthetic.main.activity_options.*
import kotlinx.android.synthetic.main.activity_options.b1
import kotlinx.android.synthetic.main.activity_synonym.*
import org.jetbrains.anko.doAsync
import org.json.JSONObject

class Synonym : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_synonym)
        val actionBar = supportActionBar
        actionBar!!.title = "Synonym"
        val Syn1 = findViewById<EditText>(R.id.Syn1)
        val syn_B2 = findViewById<Button>(R.id.syn_B2)
        syn_B2.setOnClickListener {
            Syn1.getText().clear()
        }
        syn_B1.setOnClickListener{
                var input = Syn1.text.toString()
//google api to sort the words
                //array list to put each word in , pointer
                //send each word to the RapdiAPI
                doAsync {
                    var response =
                            Unirest.get("https://twinword-word-associations-v1.p.rapidapi.com/associations/?entry="+input)
                                    .header("x-rapidapi-key", "75fb271d36msh275c3a0e2bde88ep12ad5ejsn88e6f8c3fcf8")
                                    .header("x-rapidapi-host", "twinword-word-associations-v1.p.rapidapi.com")
                                    .asString();

                    var output = response.body

                    var result = JSONObject(output).getString("associations_array")

                    tv2.text = result.toString()
                }
            }



    }
}