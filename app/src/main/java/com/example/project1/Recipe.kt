package com.example.project1

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true) var recipeId: Int?,
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "rYield") var rYield: String?,
    @ColumnInfo(name = "prepTime") var prepTime: String?,
    @ColumnInfo(name = "totalTime") var totalTime: String?,
    @ColumnInfo(name = "ingredients") var ingredients: String?,
    @ColumnInfo(name = "directions") var directions: String?
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(recipeId)
        parcel.writeString(title)
        parcel.writeString(rYield)
        parcel.writeString(prepTime)
        parcel.writeString(totalTime)
        parcel.writeString(ingredients)
        parcel.writeString(directions)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Recipe> {
        override fun createFromParcel(parcel: Parcel): Recipe {
            return Recipe(parcel)
        }

        override fun newArray(size: Int): Array<Recipe?> {
            return arrayOfNulls(size)
        }
    }
}