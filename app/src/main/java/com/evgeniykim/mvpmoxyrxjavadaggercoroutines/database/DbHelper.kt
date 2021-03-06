package com.evgeniykim.mvpmoxyrxjavadaggercoroutines.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

object DbConstants {
    const val NAME = "mvp"
    const val VERSION = 1
}

object UserTable {
    const val TABLE = "users"

    object Column {
        const val ID = "_id"
        const val NAME = "name"
        const val EMAIL = "email"
    }

    fun createScript() = String.format("create table $TABLE ("
    + "${Column.ID} integer primary key autoincrement,"
    + "${Column.NAME} text,"
    + "${Column.EMAIL} text" + ");")
}
class DbHelper(context: Context) : SQLiteOpenHelper(context, DbConstants.NAME, null, DbConstants.VERSION){
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(UserTable.createScript())
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}