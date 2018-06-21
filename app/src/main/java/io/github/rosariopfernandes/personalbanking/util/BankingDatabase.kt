package io.github.rosariopfernandes.personalbanking.util

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Transaction
import android.content.Context
import io.github.rosariopfernandes.personalbanking.dao.CategoryDao
import io.github.rosariopfernandes.personalbanking.dao.SourceDao
import io.github.rosariopfernandes.personalbanking.dao.TransactionDao
import io.github.rosariopfernandes.personalbanking.model.Category
import io.github.rosariopfernandes.personalbanking.model.Source

@Database(entities = arrayOf(Category::class, Source::class/*, Transaction::class*/), version = 1)
abstract class BankingDatabase : RoomDatabase() {

    abstract fun categoryDao():CategoryDao
    abstract fun sourceDao(): SourceDao
    //abstract fun transactionDao():TransactionDao

    companion object {
        private var INSTANCE: BankingDatabase? = null

        fun getInstance(context: Context): BankingDatabase? {
            if (INSTANCE == null) {
                synchronized(BankingDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            BankingDatabase::class.java, "personalBanking.db")
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}