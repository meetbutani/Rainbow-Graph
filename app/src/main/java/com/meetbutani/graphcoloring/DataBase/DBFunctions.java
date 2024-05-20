package com.meetbutani.graphcoloring.DataBase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.meetbutani.graphcoloring.Model.ModelLevelDetails;

import java.util.ArrayList;

public class DBFunctions {

    DBStructure dbStructure;
    SQLiteDatabase sqLiteDatabase;
    Context context;
    ModelLevelDetails modelLevelDetails;

    public DBFunctions(Context context) {
        this.context = context;
        dbStructure = new DBStructure(context);
        sqLiteDatabase = dbStructure.getWritableDatabase();
    }

    public boolean insertData(ModelLevelDetails modelLevelDetails) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(DBStructure.TBL_COL_NAME, modelLevelDetails.Level_Name);
        contentValues.put(DBStructure.TBL_COL_STATUS, modelLevelDetails.Level_Status);

        return sqLiteDatabase.insert(DBStructure.TBL_NAME, null, contentValues) > 0;
    }

    public boolean updateData(ModelLevelDetails modelLevelDetails) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(DBStructure.TBL_COL_ID, modelLevelDetails.Level_Id);
        contentValues.put(DBStructure.TBL_COL_NAME, modelLevelDetails.Level_Name);
        contentValues.put(DBStructure.TBL_COL_STATUS, modelLevelDetails.Level_Status);

        return sqLiteDatabase.update(DBStructure.TBL_NAME, contentValues, DBStructure.TBL_COL_ID + "=?", new String[]{String.valueOf(modelLevelDetails.Level_Id)}) > 0;
    }

    public ArrayList<ModelLevelDetails> selectData() {

        ArrayList<ModelLevelDetails> dataListLevelDetails = new ArrayList<>();
        String[] columns = {DBStructure.TBL_COL_ID, DBStructure.TBL_COL_NAME, DBStructure.TBL_COL_STATUS};
        @SuppressLint("Recycle") Cursor cursor = sqLiteDatabase.query(DBStructure.TBL_NAME, columns, null, null, null, null, null);
        while (cursor.moveToNext()) {
            modelLevelDetails = new ModelLevelDetails(cursor.getInt(0), cursor.getString(1), cursor.getString(2));
            dataListLevelDetails.add(modelLevelDetails);
        }

        return dataListLevelDetails;
    }

    public void deleteData(ModelLevelDetails modelLevelDetails) {
        sqLiteDatabase.delete(DBStructure.TBL_NAME, DBStructure.TBL_COL_ID + "=?", new String[]{String.valueOf(modelLevelDetails.Level_Id)});
    }
}
