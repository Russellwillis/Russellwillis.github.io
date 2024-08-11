package com.example.willisproject2cs360;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;



public class UserDB extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "UsersData.DB";
    public static final String TABLE_NAME = "Users";
    public static final String COLUMN_0_ID = "id";
    public static final String COLUMN_1_USERNAME = "name";
    public static final String COLUMN_2_PASSWORD = "password";
    private static final String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" +
            COLUMN_0_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            COLUMN_1_USERNAME + " VARCHAR, " +
            COLUMN_2_PASSWORD + " VARCHAR" + ");";
    public UserDB(MainActivity mainActivity) {
        super(mainActivity, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_USERS_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    /*Database CRUD*/
    // Ad
    public void createUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_1_USERNAME, user.getUserName());
        values.put(COLUMN_2_PASSWORD, user.getUserPass());

        db.insert(TABLE_NAME, null, values);
    }

    // Read
    public User readUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME,
                new String[] { COLUMN_0_ID, COLUMN_1_USERNAME, COLUMN_2_PASSWORD }, COLUMN_0_ID + " = ?",
                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        User user = new User(Integer.parseInt(Objects.requireNonNull(cursor).getString(0)),
                cursor.getString(1), cursor.getString(2));

        cursor.close();

        return user;
    }

    // Update
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_2_PASSWORD, user.getUserPass());
        db.update(TABLE_NAME, values, COLUMN_1_USERNAME + " = ?", new String[] { user.getUserName() });
    }

    // Delete
    public void deleteItem(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, COLUMN_0_ID + " = ?", new String[] { String.valueOf(user.getId()) });
        db.close();
    }

    // Getting All Users
    public List<User> ReadAllData() {
        List<User> userList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(0)));
                user.setUserName(cursor.getString(1));
                user.setUserPass(cursor.getString(2));

                userList.add(user);
            } while (cursor.moveToNext());
        }

        cursor.close();

        return userList;
    }

    // Deleting
    public void deleteAllUsers() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,null,null);
        db.close();
    }
    // Getting Users Count
    public int getUsersCount() {
        String countQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int usersTotal = cursor.getCount();
        cursor.close();

        return usersTotal;
    }


}
