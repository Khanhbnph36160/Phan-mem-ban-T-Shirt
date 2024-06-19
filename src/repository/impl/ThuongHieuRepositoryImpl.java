/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import Model.Size;
import Model.ThuongHieu;
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
public class ThuongHieuRepositoryImpl implements BaseRepository<ThuongHieu>{
    
    private Connection conn;
    private String sql;

    public ThuongHieuRepositoryImpl() {

        try {
            conn = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ThuongHieu add(ThuongHieu object) {
        sql = "INSERT INTO ThuongHieu(TenThuongHieu, NguoiTao, NgayTao, NguoiSua, NgaySua) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getTenThuongHieu());
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
    public ThuongHieu update(ThuongHieu object, Integer id) {
        sql = "UPDATE ThuongHieu SET TenThuongHieu =?, NguoiTao =?, NgayTao =?, NguoiSua =?, NgaySua =? WHERE id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getTenThuongHieu());
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
    public ThuongHieu getOne(Integer id) {
        sql = "SELECT * FROM ThuongHieu WHERE id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ThuongHieu th = null;
            while (rs.next()) {                
                th = new ThuongHieu();
                th.setId(rs.getInt(1));
                th.setTenThuongHieu(rs.getString(2));
                th.setNgayTao(rs.getDate(3));
                th.setNguoiTao(rs.getString(4));
                th.setNgaySua(rs.getDate(5));
                th.setNguoiSua(rs.getString(6));
            }
            return th;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ThuongHieu> findAll(String tenThuongHieu) {
        sql = "SELECT * FROM ThuongHieu WHERE (? is null or TenThuongHieu like ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if (tenThuongHieu == null) {
                ps.setString(1, null);
                ps.setString(2, null);
            } else {
                ps.setString(1, tenThuongHieu);
                ps.setString(2, "%" + tenThuongHieu + "%");
            }
            ResultSet rs = ps.executeQuery();
            List<ThuongHieu> thuongHieuList = new ArrayList<>();
            while (rs.next()) {                
                ThuongHieu th = new ThuongHieu();
                th.setId(rs.getInt(1));
                th.setTenThuongHieu(rs.getString(2));
                th.setNgayTao(rs.getDate(3));
                th.setNguoiTao(rs.getString(4));
                th.setNgaySua(rs.getDate(5));
                th.setNguoiSua(rs.getString(6));
                
                thuongHieuList.add(th);
            }
            return thuongHieuList;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ThuongHieu findEntityByName(String name) {
        sql = "SELECT * FROM ThuongHieu WHERE TenThuongHieu =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            ThuongHieu th = null;
            while (rs.next()) {                
                th = new ThuongHieu();
                th.setId(rs.getInt(1));
                th.setTenThuongHieu(rs.getString(2));
                th.setNgayTao(rs.getDate(3));
                th.setNguoiTao(rs.getString(4));
                th.setNgaySua(rs.getDate(5));
                th.setNguoiSua(rs.getString(6));
            }
            return th;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
}
