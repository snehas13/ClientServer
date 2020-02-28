package com.learn.clientserver.data

import androidx.room.*

@Dao
interface EmpDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(emp : EmpEntity)

    @Update
    fun update(empData: EmpEntity)

    @Query("select * from EmpDetails ORDER BY id ASC")
    fun getAllEmp() : List<EmpEntity>

}