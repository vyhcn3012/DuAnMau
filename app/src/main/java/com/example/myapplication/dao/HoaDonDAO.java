package com.example.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myapplication.Name.AppConstant;
import com.example.myapplication.database.DatabaseHelper;
import com.example.myapplication.model.HoaDon;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class HoaDonDAO implements IHoaDon{
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public HoaDonDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    //insert
    public int inserHoaDon(HoaDon hd) {

        ContentValues values = new ContentValues();
        values.put(AppConstant.ID_HD, hd.getMaHoaDon());
        values.put(AppConstant.NGAY_MUA, sdf.format(hd.getNgayMua()));
        try {
            if (db.insert(AppConstant.TABLE_HD, null, values) == -1) {
                return -1;
            }
        } catch (Exception ex) {
            Log.e(AppConstant.TAG_HD, ex.toString());
        }
        return 1;
    }

    //getAll
    public List<HoaDon> getAllHoaDon() throws ParseException {
        List<HoaDon> dsHoaDon = new ArrayList<>();
        Cursor c = db.query(AppConstant.TABLE_HD, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            HoaDon ee = new HoaDon();
            ee.setMaHoaDon(c.getString(0));
            ee.setNgayMua(sdf.parse(c.getString(1)));
            dsHoaDon.add(ee);
            Log.d("//=====", ee.toString());
            c.moveToNext();
        }
        c.close();
        return dsHoaDon;
    }

    //update
    public int updateHoaDon(HoaDon hd) {
        ContentValues values = new ContentValues();
        values.put(AppConstant.ID_HD, hd.getMaHoaDon());
        values.put(AppConstant.NGAY_MUA, hd.getNgayMua().toString());
        int result = db.update(AppConstant.TABLE_HD, values, ""+AppConstant.ID_HD+" = ?", new
                String[]{hd.getMaHoaDon()});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    //delete
    public int deleteHoaDonByID(String mahoadon) {
        int result = db.delete(AppConstant.TABLE_HD, ""+AppConstant.ID_TL+" = ?", new String[]{mahoadon});
        if (result == 0)
            return -1;
        return 1;
    }
}


