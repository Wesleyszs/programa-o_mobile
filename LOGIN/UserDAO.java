package com.example.loginapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDAO {

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public UserDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
    }

    // Método para adicionar um usuário
    public long addUser(String email, String password) {
        ContentValues values = new ContentValues();
        values.put("email", email);
        values.put("password", password);
        return database.insert("users", null, values);
    }

    // Método para verificar o login do usuário
    public boolean checkUser(String email, String password) {
        Cursor cursor = database.query("users",
                new String[]{"email"},
                "email=? AND password=?",
                new String[]{email, password},
                null, null, null);

        boolean exists = cursor.getCount() > 0;
        cursor.close();
        return exists;
    }
}
