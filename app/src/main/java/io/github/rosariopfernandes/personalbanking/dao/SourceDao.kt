package io.github.rosariopfernandes.personalbanking.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import io.github.rosariopfernandes.personalbanking.model.Source

@Dao
interface SourceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createSource(source: Source)

    @Query("SELECT * FROM Source")
    fun selectAll():LiveData<List<Source>>

    @Query("SELECT * FROM Source WHERE id = :id")
    fun getSource(id:Int):LiveData<Source>

    @Update
    fun updateSource(source:Source)

    @Delete
    fun deleteSource(source:Source)
}