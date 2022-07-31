package com.example.project1

import android.content.Context
import androidx.lifecycle.LiveData

class RecipeRepository (context: Context){
    var db:RecipeDao? = AppDatabase.getInstance(context)?.recipeDao()

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

    fun deleteAll(){
        db?.deleteAll()
    }

    fun findRecipeWithId(search: String): List<Recipe> {

        return db?.findRecipeWithId(search)!!
    }

    fun findRecipeWithTitle(search: String): List<Recipe> {

        return db?.findRecipeWithTitle(search)!!
    }

    // insert things in an Async way
}