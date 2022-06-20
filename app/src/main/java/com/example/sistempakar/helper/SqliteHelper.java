package com.example.sistempakar.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sistempakar.models.User;

public class SqliteHelper extends SQLiteOpenHelper {

    //DATABASE NAME
    public static final String DATABASE_NAME = "loopwiki.com";

    //DATABASE VERSION
    public static final int DATABASE_VERSION = 1;

    //TABLE NAME
    public static final String TABLE_NAME = "users";

    //TABLE USERS COLUMNS
    //ID COLUMN @PrimaryKey
    public static final String KEY_ID = "id";

    //USERNAME COLUMN
    public static final String KEY_USERNAME = "username";

    //EMAIL COLUMN
    public static final String KEY_EMAIL = "email";

    //PASSWORD COLUMN
    public static final String KEY_PASSWORD = "password";

    //SQL COMMAND TO CREATE A TABLE
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + KEY_ID + " INTEGER PRIMARY KEY,"
                    + KEY_USERNAME + " TEXT,"
                    + KEY_EMAIL + " TEXT,"
                    + KEY_PASSWORD + " TEXT"
                    + ")";

    public SqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //drop table to create new one if database version is updated
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    //using this method we can add new user to the database
    public void addUser(User user) {
        //get reference of the writable database
        SQLiteDatabase db = this.getWritableDatabase();
        //create ContentValues to add key "column"/value pairs
        ContentValues values = new ContentValues();
        //then add the values for each column
        values.put(KEY_USERNAME, user.getUsername());
        values.put(KEY_EMAIL, user.getEmail());
        values.put(KEY_PASSWORD, user.getPassword());

        //insert row
        db.insert(TABLE_NAME, null, values);

//        db.execSQL("INSERT INTO " + TABLE_NAME +
//                " (username, email, password) " +
//                "VALUES ('" + user.getUsername() + "', '" +
//                user.getEmail() + "', '" +
//                user.getPassword() +
//                "')");
    }

    //using this method we can check if a user exists in the database
    public User Authenticate(User user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,// Selecting Table
                new String[]{KEY_ID, KEY_USERNAME, KEY_EMAIL, KEY_PASSWORD},// Selecting columns want to query
                KEY_EMAIL + "=?",
                new String[]{user.getEmail()},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            //translate to indonesian
            // english = if cursor has value then in user database there is user associated with this given email
            // indonesian = jika kursor memiliki nilai maka ada user yang terkait dengan email yang diberikan
            User userLogin = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            //translate to indonesian
            // english = Match both passwords check they are same or not
            // indonesian = Cocokkan kedua password
            if (user.getPassword().equalsIgnoreCase(userLogin.getPassword())) {
                return userLogin;
            }

        }

        //translate to indonesian
        // english = if user password does not matches or there is no record with that email then return @false
        // indonesian = jika password user tidak cocok atau tidak ada record dengan email tersebut maka kembalikan @false
        return null;
    }

    //using this method we can check if a email user exists in the database
    public boolean isEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,// Selecting Table
                new String[]{KEY_ID, KEY_USERNAME, KEY_EMAIL, KEY_PASSWORD},// Selecting columns want to query
                KEY_EMAIL + "=?",
                new String[]{email},//Where clause
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {
            //translate to indonesian
            // english = if cursor has value then in user database there is user associated with this given email so return @true
            // indonesian = jika kursor memiliki nilai maka ada user yang terkait dengan email yang diberikan maka kembalikan @true
            return true;
        }

        //translate to indonesian
        // english = if user password does not matches or there is no record with that email then return @false
        // indonesian = jika password user tidak cocok atau tidak ada record dengan email tersebut maka kembalikan @false
        return false;
    }
}
