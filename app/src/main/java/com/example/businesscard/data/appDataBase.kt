package com.example.businesscard.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [businessCard::class], version = 1)
abstract class appDataBase : RoomDatabase() {

    abstract fun busnessDao(): businessCardDao

    companion object{
        @Volatile
        private var INSTANCE: appDataBase? = null

        fun getDatabase(context: Context): appDataBase{


            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    appDataBase::class.java,
                    "businesscard_db"
                ).build()
                  INSTANCE = instance
                instance
            }

        }

    }


}