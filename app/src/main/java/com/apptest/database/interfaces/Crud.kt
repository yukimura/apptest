package com.apptest.database.interfaces

import com.j256.ormlite.dao.Dao
import com.j256.ormlite.stmt.UpdateBuilder
import java.util.*

/**
 * Created by davidpayel on 13/10/2016.
 */

interface Crud<T> {
    fun get(id: Int, connectorDao: Dao<T, Int>): T
    fun getList(column: String?, value: String?, connectorDao: Dao<T, Int>): List<T>
    fun get(column: String?, value: String?, connectorDao: Dao<T, Int>, type: Class<T>): T
    fun get(connectorDao: Dao<T, Int>): List<T>
    fun create(modal: T, connectorDao: Dao<T, Int>): Int
    fun update(modal: T, connectorDao: Dao<T, Int>): Int
    fun update(column: String?, value: String?, connectorDao: Dao<T, Int>, updateBuilder: UpdateBuilder<T, Int>): Int
    fun delete(modal: Collection<T>, connectorDao: Dao<T, Int>): Int
    fun delete(column: String?, value: String?, connectorDao: Dao<T, Int>): Int
}
