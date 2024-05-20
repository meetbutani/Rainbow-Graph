package com.meetbutani.graphcoloring.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBStructure extends SQLiteOpenHelper {

    public static String FILE_NAME = "SQLite_DB.db";
    public static String TBL_NAME = "Level_info";
    public static String TBL_COL_ID = "Level_Id";
    public static String TBL_COL_NAME = "Level_Name";
    public static String TBL_COL_STATUS = "Level_Status";

    public static int VERSION = 1;

    public DBStructure(@Nullable Context context) {
        super(context, FILE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String QUERY = "CREATE TABLE '" +
                TBL_NAME + "' ('" +
                TBL_COL_ID + "' INTEGER primary key autoincrement, '" +
                TBL_COL_NAME + "' TEXT, '" +
                TBL_COL_STATUS + "' TEXT);";

        sqLiteDatabase.execSQL(QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
