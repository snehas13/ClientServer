package com.learn.clientserver.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "EmpDetails")
class EmpEntity (
    @PrimaryKey val id : Int,
    val name : String,
    val category : String,
    val categoryid : Int,
    val address : String,
    val description: String,
    val contact : String,
    val empcode : String,
    val image : String
)