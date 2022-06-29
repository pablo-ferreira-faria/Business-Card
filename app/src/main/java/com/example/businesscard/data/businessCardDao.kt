package com.example.businesscard.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface businessCardDao  {
    @Query("SELECT * FROM businessCard")
    fun getAll(): LiveData<List<businessCard>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(businessCard: businessCard)

}