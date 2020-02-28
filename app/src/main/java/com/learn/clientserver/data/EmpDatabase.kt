package com.learn.clientserver.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities=[EmpEntity::class] , version=1 , exportSchema = false)
abstract class EmpDatabase : RoomDatabase() {

    companion object {

        private const val DATABASE_NAME = "emp.db"

        private var instance : EmpDatabase? =null

        fun getDatabase(context : Context) : EmpDatabase? {
            if(instance == null) {
                instance = Room.databaseBuilder(context, EmpDatabase::class.java, DATABASE_NAME).build()
            }
            return instance
        }

    }

    abstract fun empDao() : EmpDao
}