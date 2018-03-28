package io.github.rosariopfernandes.personalbanking.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import io.github.rosariopfernandes.personalbanking.model.Category

@Dao
interface CategoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createCategory(category:Category)

    @Query("SELECT * FROM Category")
    fun selectAll():LiveData<List<Category>>

    @Query("SELECT * FROM Category WHERE id = :id")
    fun getCategory(id:Int)

    @Update
    fun updateCategory(category: Category)

    @Delete
    fun deleteCategory(category: Category)
}