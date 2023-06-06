package com.example.rehabcom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper{
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase SQLiteDatabase) {
        String qry1 = "create table users(usernaeme text, email text, paassword text)";
        SQLiteDatabase.execSQL(qry1);

        String qry2 = "create table cart(usernaeme text, product text, price float, otype text)";
        SQLiteDatabase.execSQL(qry2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int ii) {
    }
    public void register(String username, String email, String password){
        ContentValues cv = new ContentValues();
        cv.put ("username",username);
        cv.put ("email",email);
        cv.put ("password",password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users", null,cv);
        db.close();
    }

    public int login(String username, String password) {
        int result = 0;
        String str[]=new String[2];
        str[0] = username;
        str[1] = password;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from users where username=? and password=?",str);
        if(c.moveToFirst()){
            result=1;
        }
        return result;
    }
    public void addCart(String username, String product,float price, String otype) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("product", product);
        cv.put("price", price);
        cv.put("otype", otype);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users", null, cv);
        db.close();
    }
    public int checkCart(String username, String product) {
        int result = 0;
        String str[] = new String[2];
        str[0] = username;
        str[1] = product;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from cart where username=? and product=?", str);
        if (c.moveToFirst()) {
            result = 1;
        }
        db.close();
        return result;
    }
    public void removecart(String username, String otype) {
        String str[] = new String[2];
        str[0] = username;
        str[1] = otype;
        SQLiteDatabase db = getWritableDatabase();
        db.delete("cart", "username=? and otype=?", str);
        db.close();
    }
}
