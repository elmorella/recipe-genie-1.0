package com.example.project1.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.project1.model.Recipe

@Dao
interface RecipeDao {
    // Create
    @Insert
    fun insertRecipe(recipe: Recipe)
    // Read
    @Query("select * from recipes")
    fun selectRecipe(): LiveData<List<Recipe>>

    // Update
    @Update
    fun updateRecipe(recipe: Recipe)

    // Delete
    @Delete
    fun deleteRecipe(recipe: Recipe)

    @Query("delete from recipes")
    fun deleteAll()

    @Query("select * from recipes where recipeId like :search")
    fun findRecipeWithId(search: String): List<Recipe>

    @Query("select * from recipes where title like :search")
    fun findRecipeWithTitle(search: String): List<Recipe>
}