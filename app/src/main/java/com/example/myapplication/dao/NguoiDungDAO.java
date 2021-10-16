package com.example.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myapplication.Name.AppConstant;
import com.example.myapplication.database.DatabaseHelper;
import com.example.myapplication.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;


public class NguoiDungDAO implements INguoiDung{

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public NguoiDungDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //insert
    public int inserNguoiDung(NguoiDung nd) {
        ContentValues values = new ContentValues();
        values.put(AppConstant.USERNAME, nd.getUserName());
        values.put(AppConstant.PASS, nd.getPassword());
        values.put(AppConstant.PHONE, nd.getPhone());
        values.put(AppConstant.HO_TEN, nd.getHoTen());
        try {
            if (db.insert(AppConstant.TABLE_ND, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(AppConstant.TAG_ND, ex.toString());
        }
        return 1;
    }

    //getAll
    public List<NguoiDung> getAllNguoiDung() {
        List<NguoiDung> dsNguoiDung = new ArrayList<>();
        Cursor c = db.query(AppConstant.TABLE_ND, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            NguoiDung ee = new NguoiDung();
            ee.setUserName(c.getString(0));
            ee.setPassword(c.getString(1));
            ee.setPhone(c.getString(2));
            ee.setHoTen(c.getString(3));
            dsNguoiDung.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return dsNguoiDung;
    }

    //update
    public int updateNguoiDung(NguoiDung nd) {
        ContentValues values = new ContentValues();
        values.put(AppConstant.USERNAME, nd.getUserName());
        values.put(AppConstant.PASS, nd.getPassword());
        values.put(AppConstant.PHONE, nd.getPhone());
        values.put(AppConstant.HO_TEN, nd.getHoTen());
        int result = db.update(AppConstant.TABLE_ND, values, ""+AppConstant.USERNAME+" = ?", new
                String[]{nd.getUserName()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int changePasswordNguoiDung(NguoiDung nd) {
        ContentValues values = new ContentValues();
        values.put(AppConstant.USERNAME, nd.getUserName());
        values.put(AppConstant.PASS, nd.getPassword());
        int result = db.update(AppConstant.TABLE_ND, values, ""+AppConstant.USERNAME+" = ?", new String[]{nd.getUserName()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int changePassword(NguoiDung nd) {
        ContentValues values = new ContentValues();
        values.put(AppConstant.PASS, nd.getPassword());
        int result = db.update(AppConstant.TABLE_ND, values, ""+AppConstant.PASS+" = ?", new String[]{nd.getPassword()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int updateInfoNguoiDung(String username, String phone, String name) {
        ContentValues values = new ContentValues();
        values.put(AppConstant.PHONE, phone);
        values.put(AppConstant.HO_TEN, name);
        int result = db.update(AppConstant.TABLE_ND, values, ""+AppConstant.USERNAME+" = ?", new
                String[]{username});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    //delete
    public int deleteNguoiDungByID(String username) {
        int result = db.delete(AppConstant.TABLE_ND, ""+AppConstant.USERNAME+" = ?", new String[]{username});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    //check login
    public int checkLogin(String username, String password) {
        int result = db.delete(AppConstant.TABLE_ND, ""+AppConstant.USERNAME+" AND "+AppConstant.PASS+"", new
                String[]{username, password});
        if (result == 0)
            return -1;
        return 1;
    }

    public Boolean Luu(String user, String pass) {
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+AppConstant.TABLE_ND+" where "+AppConstant.USERNAME+" = ? AND "+AppConstant.PASS+"=?", new String[]{user, pass});
        return cursor.getCount() > 0;
    }
}

