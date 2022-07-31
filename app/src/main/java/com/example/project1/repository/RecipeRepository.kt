package com.example.project1.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.project1.database.AppDatabase
import com.example.project1.database.RecipeDao
import com.example.project1.model.Recipe

class RecipeRepository (context: Context){
    var db: RecipeDao? = AppDatabase.getInstance(context)?.recipeDao()

    fun getAllRecipes(): LiveData<List<Recipe>>? {
        return db?.selectRecipe()
    }

    fun insertRecipe(recipe: Recipe) {
        db?.insertRecipe(recipe)
    }

    fun updateRecipe(recipe: Recipe) {
        db?.updateRecipe(recipe)
    }

    fun deleteRecipe(recipe: Recipe) {
        db?.deleteRecipe(recipe)
    }
}