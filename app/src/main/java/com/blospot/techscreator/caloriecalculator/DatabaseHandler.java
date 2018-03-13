package com.blospot.techscreator.caloriecalculator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Database";

    // Contacts table name
    private static final String TABLE_CONTACTS = "user";

    // Contacts Table Columns names
    private static final String KEY_ID= "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_AGE = "age";
    private static final String KEY_GENDER = "gender";
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_HOURS = "hours";
    private static final String KEY_Cal = "cal";
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("+ KEY_ID+ " INTEGER PRIMARY KEY,"
                + KEY_NAME+ " TEXT," +KEY_AGE + " TEXT,"+ KEY_GENDER + " TEXT,"
                + KEY_WEIGHT + " TEXT," +KEY_Cal+" REAL,"+ KEY_HOURS + " TEXT "+ ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }
    public void add(User u) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID,u.getId());
        values.put(KEY_NAME,u.getName()); // Contact Name
        values.put(KEY_GENDER, u.getAge());
        values.put(KEY_GENDER,u.getGender());
        values.put(KEY_HOURS,u.getHours());
        values.put(KEY_WEIGHT,u.getWeight());// Contact Phone Number
        values.put(KEY_Cal,u.getCal());

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }
    public List<User> getAll() {
        List<User> contactList = new ArrayList<User>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User u = new User();
                u.setName(cursor.getString(0));
                u.setAge(cursor.getString(1));
                u.setGender(cursor.getString(2));
                u.setWeight(cursor.getString(3));
                u.setHours(cursor.getString(4));
                // Adding  to list
                contactList.add(u);
            } while (cursor.moveToNext());
        }

        // return  list
        return contactList;
    }
    public User getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                        KEY_NAME, KEY_AGE,KEY_GENDER,KEY_WEIGHT,KEY_Cal,KEY_HOURS }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        // return user
        return new User(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(6),cursor.getDouble(5));
    }
}