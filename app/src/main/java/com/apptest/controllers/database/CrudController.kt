package com.apptest.controllers.database

import android.content.Context
import com.apptest.adapter.BaseHelperController
import com.apptest.interfaces.Crud
import com.j256.ormlite.dao.Dao
import com.j256.ormlite.stmt.*
import com.j256.ormlite.stmt.query.In
import java.sql.SQLException
import java.util.*

/**
 * Created by davidpayel on 06/10/2016.
 */
class CrudController<T: Any>(context: Context) : BaseHelperController(context), Crud<T> {
    /**
     * Methods [T]
     * @return
     */

    override fun get(id: Int, connectorDao: Dao<T, Int>): T {
        var t: T? = null
        try {
            return connectorDao.queryForId(id)
        } catch (e: SQLException) {
            e.printStackTrace()
            return t!!
        }
    }

    override fun getList(column: String?, value: String?, connectorDao: Dao<T, Int>): List<T> {
        try {
            return connectorDao.queryForEq(column, value)
        } catch (e: SQLException) {
            e.printStackTrace()
            return ArrayList()
        }
    }

    override fun get(connectorDao: Dao<T, Int>): List<T> {
        try {
            return connectorDao.queryForAll()
        } catch (e: SQLException) {
            e.printStackTrace()
            return ArrayList()
        }
    }

    override fun create(modal: T, connectorDao: Dao<T, Int>): Int {
        try {
            return connectorDao.create(modal)
        } catch (e: SQLException) {
            e.printStackTrace()
            return -1
        }
    }

    override fun update(modal: T, connectorDao: Dao<T, Int>): Int {
        try {
            return connectorDao.update(modal)
        } catch (e: SQLException) {
            e.printStackTrace()
            return -1
        }
    }

    override fun delete(modal: Collection<T>, connectorDao: Dao<T, Int>): Int {
        try {
            return connectorDao.delete(modal)
        } catch (e: SQLException) {
            e.printStackTrace()
            return -1
        }
    }

    override fun get(column: String?, value: String?, connectorDao: Dao<T, Int>, type: Class<T>): T {
        try {
            var queryBuilder: QueryBuilder<T, Int>  = connectorDao.queryBuilder()
            var where: Where<T, Int> = queryBuilder.where()

            where.eq(column, value);
            var preparedQuery: PreparedQuery<T> = queryBuilder.prepare();

            var t: List<T> = connectorDao.query(preparedQuery);

            if(t.size != 0){
                return t.get(0)
            }else{
                return type.newInstance()
            }
        } catch (e: SQLException) {
            e.printStackTrace()
            return type.newInstance()
        }
    }

    override fun update(column: String?, value: String?, connectorDao: Dao<T, Int>, updateBuilder: UpdateBuilder<T, Int>): Int{
        try {
            var where: Where<T, Int> = updateBuilder.where()
            where.eq(column, value)
            var preparedQuery = updateBuilder.prepare()
            return connectorDao.update(preparedQuery)
        } catch (e: SQLException) {
            e.printStackTrace()
            return -1
        }
    }

    override fun delete(column: String?, value: String?, connectorDao: Dao<T, Int>): Int{
        try {
            val deleteBuilder = connectorDao.deleteBuilder()
            deleteBuilder.where().eq(column, value)
            return deleteBuilder.delete()
        } catch (e: SQLException) {
            e.printStackTrace()
            return -1
        }
    }
}