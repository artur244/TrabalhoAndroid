package com.example.myapplication

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Livro::class], version = 1)
abstract class HelperDatabase: RoomDatabase() {
    abstract  fun livrodao(): LivroDAO

    companion object{
        private var INSTANCE: HelperDatabase? = null

        fun getDatabase(context: Context): HelperDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HelperDatabase::class.java,
                    "livro_db"
                )   .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}