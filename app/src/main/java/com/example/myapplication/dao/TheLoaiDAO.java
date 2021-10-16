package com.example.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myapplication.Name.AppConstant;
import com.example.myapplication.database.DatabaseHelper;
import com.example.myapplication.model.TheLoai;

import java.util.ArrayList;
import java.util.List;


public class TheLoaiDAO implements ITheLoai{

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public TheLoaiDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //insert
    public int inserTheLoai(TheLoai theLoai) {
        ContentValues values = new ContentValues();
        values.put(AppConstant.ID_TL, theLoai.getMaTheloai());
        values.put(AppConstant.TEN_TL, theLoai.getTenTheloai());
        values.put(AppConstant.MO_TA, theLoai.getMoTa());
        values.put(AppConstant.VI_TRI, theLoai.getViTri());
        try {
            if (db.insert(AppConstant.TABLE_TL, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(AppConstant.TAG, ex.toString());
        }
        return 1;
    }

    //getAllTheLoai
    public List<TheLoai> getAllTheLoai() {
        List<TheLoai> dsTheLoai = new ArrayList<>();
        Cursor c = db.query(AppConstant.TABLE_TL, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            TheLoai ee = new TheLoai();
            ee.setMaTheloai(c.getString(0));
            ee.setTenTheloai(c.getString(1));
            ee.setMoTa(c.getString(2));
            ee.setViTri(c.getString(3));
            dsTheLoai.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return dsTheLoai;
    }

    //update
    public int updateTheLoai(TheLoai theLoai) {
        ContentValues values = new ContentValues();
        values.put(AppConstant.ID_TL, theLoai.getMaTheloai());
        values.put(AppConstant.TEN_TL, theLoai.getTenTheloai());
        values.put(AppConstant.MO_TA, theLoai.getMoTa());
        values.put(AppConstant.VI_TRI, theLoai.getViTri());
        int result = db.update(AppConstant.TABLE_TL, values, ""+AppConstant.ID_TL+" = ?", new
                String[]{theLoai.getMaTheloai()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    public int updateInfoTheLoai(String matheloai, String s, String s1, String s2, String s3) {
        ContentValues values = new ContentValues();
        values.put(AppConstant.ID_TL, s);
        values.put(AppConstant.TEN_TL, s1);
        values.put(AppConstant.MO_TA, s2);
        values.put(AppConstant.VI_TRI, s3);
        int result = db.update(AppConstant.TABLE_TL, values, ""+AppConstant.ID_TL+" = ?", new
                String[]{matheloai});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    //delete
    public int deleteTheLoaiByID(String matheloai) {
        int result = db.delete(AppConstant.TABLE_TL, ""+AppConstant.ID_TL+" = ?", new String[]{matheloai});
        if (result == 0)
            return -1;
        return 1;
    }
}