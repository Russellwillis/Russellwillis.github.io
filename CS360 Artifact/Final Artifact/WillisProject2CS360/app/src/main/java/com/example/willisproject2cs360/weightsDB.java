package com.example.willisproject2cs360;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

import java.util.Objects;

public class weightsDB extends SQLiteOpenHelper
{
    private static Context context;
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "WeightData.DB";
    private static final String TABLE_NAME = "Weights_Table";

    private static final String COLUMN_0_ID = "id";
    private static final String COLUMN_1_WEIGHT = "Weight";
    private static final String COLUMN_2_USERNAME = "userName";
    private static final String CREATE_WEIGHTS_TABLE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" +
            COLUMN_0_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            COLUMN_1_WEIGHT + " VARCHAR, " +
            COLUMN_2_USERNAME + "VARCHAR"+ ");";

    public weightsDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
        db.execSQL(CREATE_WEIGHTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /*Crud*/
    // Add
    public void addWeight(String weight, String userName) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_1_WEIGHT, weight);
        values.put(COLUMN_2_USERNAME, userName);

        db.insert(TABLE_NAME, null, values);
    }

    // Read
    public Weight readWeight(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,
                new String[] { COLUMN_0_ID, COLUMN_1_WEIGHT}, COLUMN_0_ID + " = ?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        Weight weight = new Weight(Integer.parseInt(Objects.requireNonNull(cursor).getString(0)),
                cursor.getString(1));

        cursor.close();

        return weight;
    }

    // Update
    public int updateItem(Weight weight) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_1_WEIGHT, weight.getWeight());

        return db.update(TABLE_NAME, values, COLUMN_0_ID + " = ?", new String[] { String.valueOf(weight.getId()) });
    }

    // Delete
    public void deleteItem(String weightID, String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_0_ID + " = ? AND " + COLUMN_2_USERNAME + " = ?",
                new String[] { String.valueOf(weightID), username });
        db.close();
    }


    // Getting
    Cursor readWeightsByUser(String userName) {
        // Select All Query
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_2_USERNAME + " = ?";

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(selectQuery, new String[]{userName});
        }


        return cursor;
    }

    // Deleting
    public void deleteAllItems() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,null,null);
        db.close();
    }


    public int getweightsCount() {
        String countQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int wTotal = cursor.getCount();
        cursor.close();

        return wTotal;
    }
}
