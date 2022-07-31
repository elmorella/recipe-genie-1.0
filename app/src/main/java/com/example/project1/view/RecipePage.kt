package com.example.project1.view

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project1.R
import com.example.project1.UpdateRecipe
import com.example.project1.model.Recipe
import com.example.project1.viewmodel.MainViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class RecipePage : AppCompatActivity() {
    lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_page)

        vm = MainViewModel(application)

        //populate TextFields with recipe data from repo and get recipeID as a String
        val recipe: Recipe = intent.getParcelableExtra<Recipe>("recipe")!!
        setData(recipe)

        val btnHome: ExtendedFloatingActionButton = findViewById(R.id.btn_home)
        btnHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val btnEdit: ExtendedFloatingActionButton = findViewById(R.id.btn_edit)
        btnEdit.setOnClickListener {
            val intent = Intent(this, UpdateRecipe::class.java)
            intent.putExtra("recipe", recipe)
            startActivity(intent)
        }


        val btnDelete: ExtendedFloatingActionButton = findViewById(R.id.btn_delete)
        btnDelete.setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setTitle("Alert")
                .setMessage("This will permanently delete ${recipe.title}. Do you want to continue?")
                .setPositiveButton("Cancel") { _, _ ->
                    val message = "cancelled"
                    val duration = Toast.LENGTH_LONG
                    Toast.makeText(applicationContext, message, duration).show()
                }
                .setNegativeButton("Delete") { _, _ ->
                    vm.deleteRecipe(recipe)
                    val intent = Intent(this, FavoritesList::class.java)
                    startActivity(intent)
                    val message = "recipe deleted"
                    val duration = Toast.LENGTH_LONG
                    Toast.makeText(applicationContext, message, duration).show()
                }
                .show()
        }
    }

    private fun setData(recipe: Recipe) {
        // Map TextViews in recipe page
        val id: TextView = findViewById(R.id.id)
        val title: TextView = findViewById(R.id.title)
        val rYield: TextView = findViewById(R.id.r_yield)
        val prepTime: TextView = findViewById(R.id.prep_time)
        val totalTime: TextView = findViewById(R.id.total_time)
        val ingredients: TextView = findViewById(R.id.ingredients)
        val directions: TextView = findViewById(R.id.directions)

        // Populate Text Views with recipe fields
        id.text = recipe.recipeId.toString()
        title.text = recipe.title
        rYield.text = recipe.rYield
        prepTime.text = recipe.prepTime
        totalTime.text = recipe.totalTime
        ingredients.text = recipe.ingredients
        directions.text = recipe.directions
    }
}