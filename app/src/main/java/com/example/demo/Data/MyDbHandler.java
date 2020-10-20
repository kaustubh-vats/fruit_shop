package com.example.demo.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.demo.Fruit;
import com.example.demo.LoginModel;
import com.example.demo.Params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {
    public MyDbHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create1 = "CREATE TABLE USERS ( username TEXT, password TEXT);";
        String create = "CREATE TABLE "+Params.TABLE_NAME+" ("+Params.KEY_ID+" INTEGER PRIMARY KEY, "+Params.KEY_NAME+" TEXT, "+Params.KEY_COUNT+" INTEGER);";
        db.execSQL(create);
        db.execSQL(create1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addItem(Fruit fruit){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME, fruit.getName());
        values.put(Params.KEY_COUNT, fruit.getCount());
        db.insert(Params.TABLE_NAME,null,values);
        db.close();
    }
    public List<Fruit> getAllFruit() {
        List<Fruit> fruits = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM "+Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select, null);
        if(cursor.moveToFirst()){
            do{
                Fruit fruit = new Fruit();
                fruit.setId(Integer.parseInt(cursor.getString(0)));
                fruit.setName(cursor.getString(1));
                fruit.setCount(Integer.parseInt(cursor.getString(2)));
                fruits.add(fruit);
            }while(cursor.moveToNext());
        }
        db.close();
        return fruits;
    }
    public int updateFruits(Fruit fruit){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME, fruit.getName());
        values.put(Params.KEY_COUNT, fruit.getCount());
        return db.update(Params.TABLE_NAME, values, Params.KEY_ID+" =? ", new String[]{String.valueOf(fruit.getId())});
    }
    public void addUser(LoginModel loginModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", loginModel.getUsername());
        values.put("password", loginModel.getPassword());
        db.insert("USERS",null,values);
        db.close();
    }
    public List<LoginModel> getAllUsers() {
        List<LoginModel> users = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM USERS";
        Cursor cursor = db.rawQuery(select, null);
        if(cursor.moveToFirst()){
            do{
                LoginModel user = new LoginModel();
                user.setUsername(cursor.getString(0));
                user.setPassword(cursor.getString(1));
                users.add(user);
            }while(cursor.moveToNext());
        }
        db.close();
        return users;
    }
}