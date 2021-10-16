package com.example.myapplication.dao;

import com.example.myapplication.model.HoaDonChiTiet;

import java.util.List;

public interface IHoaDonChiTiet {
    int inserHoaDonChiTiet(HoaDonChiTiet hd);
    List<HoaDonChiTiet> getAllHoaDonChiTiet();
    List<HoaDonChiTiet> getAllHoaDonChiTietByID(String maHoaDon);
    int updateHoaDonChiTiet(HoaDonChiTiet hd);
    int deleteHoaDonChiTietByID(String maHDCT);
    boolean checkHoaDon(String maHoaDon);
    double getDoanhThuTheoNgay();
    double getDoanhThuTheoThang();
    double getDoanhThuTheoNam();
}
