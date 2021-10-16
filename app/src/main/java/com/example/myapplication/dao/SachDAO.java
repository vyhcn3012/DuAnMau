package com.example.myapplication.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myapplication.Name.AppConstant;
import com.example.myapplication.database.DatabaseHelper;
import com.example.myapplication.model.Sach;

import java.util.ArrayList;
import java.util.List;


public class SachDAO implements ISach{

    //SQLite database
    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public SachDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }
    //Firebase
//    private DatabaseReference mDatabase;
//
//    NonUI nonUI;
//    Context context;
//    String sachId;
//
//
//    public SachDAO(Context context) {
//
//        this.mDatabase = FirebaseDatabase.getInstance().getReference("Sach");
//        this.context = context;
//        this.nonUI = new NonUI(context);
//
//    }
    //insert
    public int inserSach(Sach s) {
        ContentValues values = new ContentValues();
        values.put(AppConstant.ID_SACH, s.getMaSach());
        values.put(AppConstant.ID_TL, s.getMaTheLoai());
        values.put(AppConstant.TEN_SACH, s.getTenSach());
        values.put(AppConstant.TAC_GIA, s.getTacGia());
        values.put(AppConstant.NXB, s.getNXB());
        values.put(AppConstant.GIA_SACH, s.getGiaBia());
        values.put(AppConstant.SO_LUONG_SACH, s.getSoLuong());
        if (checkPrimaryKey(s.getMaSach())) {
            int result = db.update(AppConstant.TABLE_SACH, values, ""+AppConstant.ID_SACH+"=?", new
                    String[]{s.getMaSach()});
            if (result == 0) {
                return -1;
            }
        } else {
            try {
                if (db.insert(AppConstant.TABLE_SACH, null, values) == -1) {
                    return -1;
                }
            } catch (Exception ex) {
                Log.e(AppConstant.TAG_SACH, ex.toString());
            }
        }
        return 1;
    }

    //getAll
    public List<Sach> getAllSach() {
        List<Sach> dsSach = new ArrayList<>();
        Cursor c = db.query(AppConstant.TABLE_SACH, null, null, null, null, null, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            Sach s = new Sach();
            s.setMaSach(c.getString(0));
            s.setMaTheLoai(c.getString(1));
            s.setTenSach(c.getString(2));
            s.setTacGia(c.getString(3));
            s.setNXB(c.getString(4));
            s.setGiaBia(c.getDouble(5));
            s.setSoLuong(c.getInt(6));
            dsSach.add(s);
            Log.d("//=====", s.toString());
            c.moveToNext();
        }
        c.close();
        return dsSach;
    }

    //update
    public int updateSach(String maSach, String a, String b, String c, String d, double e, int f) {
        ContentValues values = new ContentValues();
        values.put(AppConstant.ID_SACH, a);
        values.put(AppConstant.TEN_SACH, b);
        values.put(AppConstant.TAC_GIA, c);
        values.put(AppConstant.NXB, d);
        values.put(AppConstant.GIA_SACH, e);
        values.put(AppConstant.SO_LUONG_SACH, f);
        int result = db.update(AppConstant.TABLE_SACH, values, ""+AppConstant.ID_SACH+"=?", new
                String[]{maSach});
        if (result == 0) {
            return -1;
        }
        return 1;
    }

    //delete
    public int deleteSachByID(String maSach) {
        int result = db.delete(AppConstant.TABLE_SACH, ""+AppConstant.ID_SACH+"=?", new String[]{maSach});
        if (result == 0)
            return -1;
        return 1;
    }

    //check
    public boolean checkPrimaryKey(String strPrimaryKey) {
        //SELECT
        String[] columns = {AppConstant.ID_SACH};
        //WHERE clause
        String selection = ""+AppConstant.ID_SACH+"=?";
        //WHERE clause arguments
        String[] selectionArgs = {strPrimaryKey};
        Cursor c = null;
        try {
            c = db.query(AppConstant.TABLE_SACH, columns, selection, selectionArgs, null, null,
                    null);
            c.moveToFirst();
            int i = c.getCount();
            c.close();
            return i > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //check
    public Sach checkBook(String strPrimaryKey) {
        Sach s = new Sach();
        //SELECT
        String[] columns = {AppConstant.ID_SACH};
        //WHERE clause
        String selection = ""+AppConstant.ID_SACH+"=?";
        //WHERE clause arguments
        String[] selectionArgs = {strPrimaryKey};
        Cursor c = null;
        try {
            c = db.query(AppConstant.TABLE_SACH, columns, selection, selectionArgs, null, null,
                    null);
            c.moveToFirst();
            while (c.isAfterLast() == false) {
                s.setMaSach(c.getString(0));
                s.setMaTheLoai(c.getString(1));
                s.setTenSach(c.getString(2));
                s.setTacGia(c.getString(3));
                s.setNXB(c.getString(4));
                s.setGiaBia(c.getDouble(5));
                s.setSoLuong(c.getInt(6));
                Log.d("//=====", s.toString());
                break;
            }
            c.close();
            return s;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //getAll
    public Sach getSachByID(String maSach) {
        Sach s = null;
        //WHERE clause
        String selection = ""+AppConstant.ID_SACH+"=?";
        //WHERE clause arguments
        String[] selectionArgs = {maSach};
        Cursor c = db.query(AppConstant.TABLE_SACH, null, selection, selectionArgs, null, null, null);
        Log.d("getSachByID", "===>" + c.getCount());
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            s = new Sach();
            s.setMaSach(c.getString(0));
            s.setMaTheLoai(c.getString(1));
            s.setTenSach(c.getString(2));
            s.setTacGia(c.getString(3));
            s.setNXB(c.getString(4));
            s.setGiaBia(c.getDouble(5));
            s.setSoLuong(c.getInt(6));
            break;
        }
        c.close();
        return s;
    }

    //getAll
    public List<Sach> getSachTop10(String month) {
        List<Sach> dsSach = new ArrayList<>();
        if (Integer.parseInt(month) < 10) {
            month = "0" + month;
        }
        String sSQL = "SELECT maSach, SUM(soLuong) as soluong FROM HoaDonChiTiet INNER JOIN HoaDon " + "ON HoaDon.maHoaDon = HoaDonChiTiet.maHoaDon WHERE strftime('%m',HoaDon.ngayMua) = '" + month + "' " +
                "GROUP BY maSach ORDER BY soluong DESC LIMIT 10";
        Cursor c = db.rawQuery(sSQL, null);
        c.moveToFirst();
        while (c.isAfterLast() == false) {
            Log.d("//=====", c.getString(0));
            Sach s = new Sach();
            s.setMaSach(c.getString(0));
            s.setSoLuong(c.getInt(1));
            s.setGiaBia(0);
            s.setMaTheLoai("");
            s.setTenSach("");
            s.setTacGia("");
            s.setNXB("");
            dsSach.add(s);
            c.moveToNext();
        }
        c.close();
        return dsSach;
    }
}


