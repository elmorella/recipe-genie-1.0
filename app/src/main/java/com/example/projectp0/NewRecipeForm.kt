package com.example.projectp0

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class NewRecipeForm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_recipe_form)

        val btnSubmit: ExtendedFloatingActionButton = findViewById(R.id.btn_submit)
        btnSubmit.setOnClickListener{
            val intent = Intent(this,RecipePage::class.java)
            startActivity(intent)
        }
    }
}