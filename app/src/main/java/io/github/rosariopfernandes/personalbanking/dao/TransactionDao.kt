package io.github.rosariopfernandes.personalbanking.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createTransaction(transaction: Transaction)

    @Query("SELECT * FROM `Transaction`")
    fun selectAll():LiveData<List<Transaction>>

    @Query("SELECT * FROM `Transaction` WHERE id = :id")
    fun getTransaction(id:Int)

    @Update
    fun updateTransaction(transaction: Transaction)

    @Delete
    fun deleteTransaction(transaction: Transaction)
}