package com.learn.clientserver.data

import android.content.Context
import com.learn.clientserver.domain.Success

class EmpDataSourceImpl(context: Context) : EmpDataSource {

    private val empDao = EmpDatabase.getDatabase(context)!!.empDao()

    override suspend fun add(empData : Success) {
        return empDao.insert(EmpEntity(empData.id,empData.name,empData.category,empData.categoryid,empData.address,empData.description,empData.contact,empData.empcode,empData.image))
    }


    override suspend fun readAll(): List<Success> {
        return empDao.getAllEmp().map { Success(it.id,it.name,it.category,it.categoryid,it.address,it.description,it.contact,it.empcode,it.image) }
    }

    override suspend fun edit(empData: Success) {
        return empDao.update(EmpEntity(empData.id,empData.name,empData.category,empData.categoryid,empData.address,empData.description,empData.contact,empData.empcode,empData.image))
    }
}