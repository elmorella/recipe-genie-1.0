package com.example.project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.project1.model.Recipe
import com.example.project1.view.FavoritesList
import com.example.project1.viewmodel.MainViewModel
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class UpdateRecipe : AppCompatActivity() {
    lateinit var vm: MainViewModel

    private lateinit var id: TextView
    private lateinit var title: TextInputEditText
    private lateinit var rYield: TextInputEditText
    private lateinit var prepTime: TextInputEditText
    private lateinit var totalTime: TextInputEditText
    private lateinit var ingredients: TextInputEditText
    private lateinit var directions: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_recipe)

        vm = MainViewModel(application)
        val recipe = intent.getParcelableExtra<Recipe>("recipe")!!

        // unwrap Intent
        getData(recipe)

        val btnUpdate: ExtendedFloatingActionButton = findViewById(R.id.btn_update)
        val btnCancel: ExtendedFloatingActionButton = findViewById(R.id.btn_cancel)

        btnCancel.setOnClickListener {
            val message = "cancelled"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(applicationContext, message, duration)
            toast.show()

            val intent = Intent(this, FavoritesList::class.java)
            startActivity(intent)
        }


        btnUpdate.setOnClickListener {
            val newRecipe = Recipe(
                id.text.toString().toInt(), title.text.toString(),
                rYield.text.toString(), prepTime.text.toString(), totalTime.text.toString(),
                ingredients.text.toString(), directions.text.toString()
            )
            vm.updateRecipe(newRecipe)

            val message = "recipe updated"
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(applicationContext, message, duration)
            toast.show()

            val intent = Intent(this, FavoritesList::class.java)
            startActivity(intent)
        }
    }

    private fun getData(recipe: Recipe) {
        // Map TextViews in recipe page
        id = findViewById(R.id.text_view_id)
        title = findViewById(R.id.edit_text_title)
        rYield = findViewById(R.id.edit_text_yield)
        prepTime = findViewById(R.id.edit_text_prep_time)
        totalTime = findViewById(R.id.edit_text_total_time)
        ingredients = findViewById(R.id.edit_text_ingredients)
        directions = findViewById(R.id.edit_text_directions)

        // Populate Text Views with recipe fields
        id.text = recipe.recipeId.toString()
        title.setText(recipe.title)
        rYield.setText(recipe.rYield)
        prepTime.setText(recipe.prepTime)
        totalTime.setText(recipe.totalTime)
        ingredients.setText(recipe.ingredients)
        directions.setText(recipe.directions)
    }
}