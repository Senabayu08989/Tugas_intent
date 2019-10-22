package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class layout_tampilan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_tampilan)
    var intent = intent
        val title = intent.getStringExtra("title")
        val direct = intent.getStringExtra("Direct")
        val prodct = intent.getStringExtra("title")
        val genre = intent.getStringExtra("Genre")
        val umur = intent.getStringExtra("umur")
        val date = intent.getStringExtra("date")
        val negara = intent.getStringExtra("negara")
        val tampil = findViewById<TextView>(R.id.result_text)

        tampil.text="Title : "+title+"\nDireksi :"+direct+"\nprodct : "+prodct+"\ngenre : "+genre+"\nUmur :"+umur+"\ntanggal :"+date+"\nNegara :"+negara


    }
}
