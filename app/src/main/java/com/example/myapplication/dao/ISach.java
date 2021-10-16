package com.example.myapplication.dao;

import com.example.myapplication.model.Sach;

import java.util.List;

public interface ISach {
    int inserSach(Sach s);
    List<Sach> getAllSach();
    int updateSach(String maSach, String a, String b, String c, String d, double e, int f);
    int deleteSachByID(String maSach);
    boolean checkPrimaryKey(String strPrimaryKey);
    Sach checkBook(String strPrimaryKey);
    Sach getSachByID(String maSach);
    List<Sach> getSachTop10(String month);
}
