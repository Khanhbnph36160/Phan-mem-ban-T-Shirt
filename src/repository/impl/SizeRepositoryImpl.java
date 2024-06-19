/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import Model.MauSac;
import Model.Size;
import repository.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import repository.BaseRepository;

/**
 *
 * @author QHC
 */
public class SizeRepositoryImpl implements BaseRepository<Size>{
    
    private Connection conn;
    private String sql;

    public SizeRepositoryImpl() {

        try {
            conn = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Size add(Size object) {
        sql = "INSERT INTO Size(TenSize, NguoiTao, NgayTao, NguoiSua, NgaySua) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getTenSize());
            ps.setString(2, object.getNguoiTao());
            ps.setDate(3, object.getNgayTao());
            ps.setString(4, object.getNguoiSua());
            ps.setDate(5, object.getNgaySua());
            
            ps.execute();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Size update(Size object, Integer id) {
        sql = "UPDATE Size SET TenSize =?, NguoiTao =?, NgayTao =?, NguoiSua =?, NgaySua =? WHERE id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getTenSize());
            ps.setString(2, object.getNguoiTao());
            ps.setDate(3, object.getNgayTao());
            ps.setString(4, object.getNguoiSua());
            ps.setDate(5, object.getNgaySua());
            ps.setInt(6, id);

            ps.execute();
            return object;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Size getOne(Integer id) {
        sql = "SELECT * FROM Size WHERE id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Size sz = null;
            while (rs.next()) {                
                sz = new Size();
                sz.setId(rs.getInt(1));
                sz.setTenSize(rs.getString(2));
                sz.setNgayTao(rs.getDate(3));
                sz.setNguoiTao(rs.getString(4));
                sz.setNgaySua(rs.getDate(5));
                sz.setNguoiSua(rs.getString(6));
            }
            return sz;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Size> findAll(String sizeName) {
        sql = "SELECT * FROM Size WHERE (? is null or TenSize like ? )";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if (sizeName == null) {
                ps.setString(1, null);
                ps.setString(2, null);
            } else {
                ps.setString(1, sizeName);
                ps.setString(2, "%" + sizeName + "%");
            }
            ResultSet rs = ps.executeQuery();
            List<Size> sizeList = new ArrayList<>();
            while (rs.next()) {                
                Size sz = new Size();
                sz.setId(rs.getInt(1));
                sz.setTenSize(rs.getString(2));
                sz.setNgayTao(rs.getDate(3));
                sz.setNguoiTao(rs.getString(4));
                sz.setNgaySua(rs.getDate(5));
                sz.setNguoiSua(rs.getString(6));
                
                sizeList.add(sz);
            }
            return sizeList;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Size findEntityByName(String name) {
        sql = "SELECT * FROM Size WHERE TenSize =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            Size sz = null;
            while (rs.next()) {                
                sz = new Size();
                sz.setId(rs.getInt(1));
                sz.setTenSize(rs.getString(2));
                sz.setNgayTao(rs.getDate(3));
                sz.setNguoiTao(rs.getString(4));
                sz.setNgaySua(rs.getDate(5));
                sz.setNguoiSua(rs.getString(6));
            }
            return sz;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
}
