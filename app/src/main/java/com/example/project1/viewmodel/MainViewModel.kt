package com.example.project1.viewmodel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.project1.model.Recipe
import com.example.project1.repository.RecipeRepository
import kotlinx.coroutines.launch

class MainViewModel(app: Application): AndroidViewModel(app) {
    private val repo: RecipeRepository
    val allRecipes : LiveData<List<Recipe>>?

    init {
        repo = RecipeRepository(app)
        allRecipes = repo.getAllRecipes()
    }

    fun getAllRecipes() = viewModelScope.launch {
        repo.getAllRecipes()
    }

    fun insertRecipes(recipe: Recipe) = viewModelScope.launch {
        repo.insertRecipe(recipe)
    }

    fun updateRecipe(recipe: Recipe) = viewModelScope.launch {
        repo.updateRecipe(recipe)
    }

    fun deleteRecipe(recipe: Recipe) = viewModelScope.launch {
        repo.deleteRecipe(recipe)
    }
}