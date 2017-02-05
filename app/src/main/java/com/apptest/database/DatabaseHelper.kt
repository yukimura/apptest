package com.apptest.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.apptest.modals.database.DBUser
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper
import com.j256.ormlite.dao.Dao
import com.j256.ormlite.support.ConnectionSource
import com.j256.ormlite.table.TableUtils
import java.sql.SQLException

class DatabaseHelper(context: Context): OrmLiteSqliteOpenHelper(context, DB_NAME, null, DB_VERSION) {

    override fun onCreate(sqLiteDatabase: SQLiteDatabase, connectionSource: ConnectionSource) {
        try {
            TableUtils.createTable(connectionSource, DBUser::class.java)
        } catch (e: java.sql.SQLException) {
            e.printStackTrace()
        }

    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, connectionSource: ConnectionSource, oldVersion: Int, newVersion: Int) {
        try {
            if(newVersion == 1){

            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }

    }

    /**
     * Getter/Setter
     */

    val userDao: Dao<DBUser, Int>
        get() {
            if (mUserDAO == null) {
                try {
                    mUserDAO = getDao(DBUser::class.java)
                } catch (e: java.sql.SQLException) {
                    e.printStackTrace()
                }

            }
            return mUserDAO!!
        }

    /** A/D

     */

    private var mUserDAO: Dao<DBUser, Int>? = null

    companion object {

        /**
         * CONSTANT
         */
        private val DB_NAME = "database_monsherif.sqlite"
        private val DB_VERSION = 4
    }
}
