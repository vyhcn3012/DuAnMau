package com.example.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.dao.HoaDonChiTietDAO;

import static com.example.myapplication.Name.AppConstant.GIA_SACH;
import static com.example.myapplication.Name.AppConstant.HO_TEN;
import static com.example.myapplication.Name.AppConstant.ID_HD;
import static com.example.myapplication.Name.AppConstant.ID_SACH;
import static com.example.myapplication.Name.AppConstant.ID_TL;
import static com.example.myapplication.Name.AppConstant.MO_TA;
import static com.example.myapplication.Name.AppConstant.NGAY_MUA;
import static com.example.myapplication.Name.AppConstant.NXB;
import static com.example.myapplication.Name.AppConstant.PASS;
import static com.example.myapplication.Name.AppConstant.PHONE;
import static com.example.myapplication.Name.AppConstant.SO_LUONG_SACH;
import static com.example.myapplication.Name.AppConstant.TABLE_HD;
import static com.example.myapplication.Name.AppConstant.TABLE_ND;
import static com.example.myapplication.Name.AppConstant.TABLE_SACH;
import static com.example.myapplication.Name.AppConstant.TABLE_TL;
import static com.example.myapplication.Name.AppConstant.TAC_GIA;
import static com.example.myapplication.Name.AppConstant.TEN_SACH;
import static com.example.myapplication.Name.AppConstant.TEN_TL;
import static com.example.myapplication.Name.AppConstant.USERNAME;
import static com.example.myapplication.Name.AppConstant.VI_TRI;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "PNBOOK";
    public static final int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table "+TABLE_TL+"("+ID_TL+" text primary key not null, "+TEN_TL+" text, "+MO_TA+" text, "+VI_TRI+" text)";
        db.execSQL(sql);

        sql = "create table "+TABLE_HD+"("+ID_HD+" text primary key not null, "+NGAY_MUA+" date)";
        db.execSQL(sql);

        sql = "create table " +TABLE_ND+"("+USERNAME+" text primary key, "+PASS+" text, "+PHONE+" text, "+HO_TEN+" text)";
        db.execSQL(sql);

        sql = "create table " +TABLE_SACH+"("+ID_SACH+" text primary key, "+ID_TL+" text, "+TEN_SACH+" text, "+TAC_GIA+" text, "+TAC_GIA+" text," +
                " "+NXB+" text, "+GIA_SACH+" double, "+ SO_LUONG_SACH+" number)";
        db.execSQL(sql);

        db.execSQL(HoaDonChiTietDAO.SQL_HOA_DON_CHI_TIET);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists " +TABLE_ND+"");
        db.execSQL("Drop table if exists " +TABLE_TL+"");
        db.execSQL("Drop table if exists " +TABLE_SACH+"");
        db.execSQL("Drop table if exists " +TABLE_HD+"");
        db.execSQL("Drop table if exists " + HoaDonChiTietDAO.TABLE_NAME);
        onCreate(db);
    }
}