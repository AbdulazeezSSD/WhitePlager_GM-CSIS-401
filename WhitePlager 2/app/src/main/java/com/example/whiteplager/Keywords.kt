package com.example.whiteplager

import android.os.Build.VERSION_CODES.O
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.mashape.unirest.http.Unirest
import com.mashape.unirest.http.Unirest.post
import kotlinx.android.synthetic.main.activity_keywords.*
import kotlinx.android.synthetic.main.activity_synonym.*
import org.jetbrains.anko.activityUiThread
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.json.JSONObject


class Keywords : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keywords)
        val actionBar = supportActionBar
        actionBar!!.title = "Keywords"
        val Key1 = findViewById<EditText>(R.id.Key1)
        val key_B2 = findViewById<Button>(R.id.key_B2)
        key_B2.setOnClickListener {
            Key1.getText().clear()
        }
        key_B1.setOnClickListener{
    var input = Key1.text.toString()
//google api to sort the words
    //array list to put each word in , pointer
    //send each word to the RapdiAPI
    doAsync {
        var response =
                //change Unirest.get to --->> Unirest.post
                post("https://twinword-topic-tagging.p.rapidapi.com/generate/")
                        .header("content-type", "application/x-www-form-urlencoded")
                        .header("x-rapidapi-key", "75fb271d36msh275c3a0e2bde88ep12ad5ejsn88e6f8c3fcf8")
                        .header("x-rapidapi-host", "twinword-topic-tagging.p.rapidapi.com")
                        .body("text="+input)
                        .asString()

        var output = response.body

        var result = JSONObject(output).getString("keyword")
        // array list 2 to put the word and syn in , pointer
        // print arraylist2
        tv3.text = result.toString()
    }
}
    }
}