package com.example.sph.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sph.utility.Constants

@Database(entities = [Record::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase(){

    abstract fun recordDao(): RecordDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java, Constants.DATABASE_NAME
                        )
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }

   fun  getContext(): Context{
        return getContext().applicationContext
    }
}