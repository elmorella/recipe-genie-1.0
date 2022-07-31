package com.example.project1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.project1.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linkFavList: View = findViewById(R.id.fav_view)
        linkFavList.setOnClickListener{
            val intent = Intent(this, FavoritesList::class.java)
            startActivity(intent)
        }
    }
}