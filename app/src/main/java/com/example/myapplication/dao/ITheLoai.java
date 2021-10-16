package com.example.myapplication.dao;

import com.example.myapplication.model.TheLoai;

import java.util.List;

public interface ITheLoai {
    int inserTheLoai(TheLoai theLoai);
    List<TheLoai> getAllTheLoai();
    int updateTheLoai(TheLoai theLoai);
    int updateInfoTheLoai(String matheloai, String s, String s1, String s2, String s3);
    int deleteTheLoaiByID(String matheloai);
}
