package com.example.myapplication.dao;

import com.example.myapplication.model.NguoiDung;

import java.util.List;

public interface INguoiDung {
    int inserNguoiDung(NguoiDung nd);
    List<NguoiDung> getAllNguoiDung();
    int updateNguoiDung(NguoiDung nd);
    int changePasswordNguoiDung(NguoiDung nd);
    int changePassword(NguoiDung nd);
    int updateInfoNguoiDung(String username, String phone, String name);
    int deleteNguoiDungByID(String username);
    int checkLogin(String username, String password);
    Boolean Luu(String user, String pass);
}
