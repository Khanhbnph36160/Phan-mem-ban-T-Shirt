/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import Model.SanPham;
import java.sql.*;
import repository.DBConnection;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import repository.BaseRepository;
import repository.SanPhamRepository;
import view.SanPhamView;

/**
 *
 * @author QHC
 */
public class SanPhamRepositoryImpl implements BaseRepository<SanPham>, SanPhamRepository {

    private Connection conn;
    private String sql;

    public SanPhamRepositoryImpl() {

        try {
            conn = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public SanPham add(SanPham object) {
        sql = "INSERT INTO SanPham(TenSanPham, SoLuong, TrangThai, NguoiTao, NgayTao, NguoiSua, NgaySua) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getTenSanPham());
            ps.setInt(2, object.getSoLuong());
            ps.setInt(3, object.getTrangThai());
            ps.setString(4, object.getNguoiTao());
            ps.setDate(5, object.getNgayTao());
            ps.setString(6, object.getNguoiSua());
            ps.setDate(7, object.getNgaySua());

            ps.execute();
            System.out.println("Done");
            return object;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SanPham update(SanPham object, Integer id) {
        sql = "UPDATE SanPham SET TenSanPham =?, SoLuong =?, TrangThai =?, NguoiTao =?, NgayTao =?, NguoiSua =?, NgaySua =? WHERE id =?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getTenSanPham());
            ps.setInt(2, object.getSoLuong());
            ps.setInt(3, object.getTrangThai());
            ps.setString(4, object.getNguoiTao());
            ps.setDate(5, object.getNgayTao());
            ps.setString(6, object.getNguoiSua());
            ps.setDate(7, object.getNgaySua());
            ps.setInt(8, id);

            ps.execute();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        sql = "DELETE FROM SanPham WHERE id =?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public SanPham getOne(Integer id) {
        sql = "SELECT * FROM SanPham WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            SanPham sp = null;
            while (rs.next()) {
                sp = new SanPham();
                sp.setId(rs.getInt(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setSoLuong(rs.getInt(3));
                sp.setTrangThai(rs.getInt(4));
                sp.setNgayTao(rs.getDate(5));
                sp.setNguoiTao(rs.getString(6));
                sp.setNgaySua(rs.getDate(7));
                sp.setNguoiSua(rs.getString(8));
            }
            return sp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SanPhamView> findAllCustom(String tenSanPham) {
        sql = "SELECT id, TenSanPham, SoLuong, TrangThai FROM SanPham WHERE (? is null or TenSanPham like ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenSanPham == null ? null : tenSanPham);
            ps.setString(2, "%" + tenSanPham + "%");
            ResultSet rs = ps.executeQuery();
            List<SanPhamView> sanPhamList = new ArrayList<>();
            while (rs.next()) {
                SanPhamView sp = new SanPhamView();
                sp.setId(rs.getInt(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setSoLuongTong(rs.getInt(3));
                sp.setTrangThai(rs.getInt(4));
                sanPhamList.add(sp);
            }
            return sanPhamList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SanPham> findAll(String ten) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SanPham findEntityByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
