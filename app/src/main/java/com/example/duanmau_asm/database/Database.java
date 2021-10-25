package com.example.lamthuasm_duanmau.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context) {
        super(context, "ThuVienDB", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {


        String sql="CREATE TABLE  ThuThu(maTT TEXT PRIMARY KEY, hoTen TEXT NOT NULL,matKhau TEXT NOT NULL)";
        db.execSQL(sql);
        sql="CREATE TABLE  ThanhVien(maTV TEXT PRIMARY KEY, hoTen TEXT NOT NULL,namSinh TEXT NOT NULL,matKhau TEXT)";
        db.execSQL(sql);
        sql="CREATE TABLE  LoaiSach(maLoai TEXT PRIMARY KEY, TenLoai TEXT NOT NULL)";
        db.execSQL(sql);
        sql="CREATE TABLE  Sach(maSach TEXT PRIMARY KEY, tenSach TEXT NOT NULL,giaThue TEXT NOT NULL,maLoai TEXT REFERENCES LoaiSach(maLoai),soLuong INTEGER)";
        db.execSQL(sql);
        sql="CREATE TABLE  PhieuMuon(maPM TEXT PRIMARY KEY, " +
                "maTT TEXT REFERENCES ThuThu(maTT)," +
                "maTV TEXT REFERENCES ThanhVien(maTV)," +
                "maSach TEXT REFERENCES Sach(maSach)," +
                "tienThue INTEGER NOT NULL," +
                "ngay DATE NOT NULL," +
                "traSach INTEGER NOT NULL)";
        db.execSQL(sql);



        String sqlInsert="INSERT INTO ThuThu VALUES('PS16752','admin','123')";
        db.execSQL(sqlInsert);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS ThuThu");
        db.execSQL("DROP TABLE IF EXISTS ThanhVien");
        db.execSQL("DROP TABLE IF EXISTS LoaiSach");
        db.execSQL("DROP TABLE IF EXISTS Sach");
        db.execSQL("DROP TABLE IF EXISTS PhieuMuon");



        onCreate(db);
    }
}
