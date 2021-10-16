package com.example.myapplication.dao;

import com.example.myapplication.model.HoaDon;

import java.text.ParseException;
import java.util.List;

public interface IHoaDon {
    int inserHoaDon(HoaDon hd);
    List<HoaDon> getAllHoaDon() throws ParseException;
    int updateHoaDon(HoaDon hd);
    int deleteHoaDonByID(String mahoadon);
}
