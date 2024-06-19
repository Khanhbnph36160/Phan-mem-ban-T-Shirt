/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import Model.ChatLieu;
import Model.MauSac;
import repository.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import repository.BaseRepository;

/**
 *
 * @author QHC
 */
public class MauSacRepositoryImpl implements BaseRepository<MauSac> {

    private Connection conn;
    private String sql;

    public MauSacRepositoryImpl() {

        try {
            conn = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public MauSac add(MauSac object) {
        sql = "INSERT INTO MauSac(TenMau, NguoiTao, NgayTao, NguoiSua, NgaySua) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getTenMau());
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
    public MauSac update(MauSac object, Integer id) {
        sql = "UPDATE MauSac SET TenMau =?, NguoiTao =?, NgayTao =?, NguoiSua =?, NgaySua =? WHERE id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getTenMau());
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
    public MauSac getOne(Integer id) {
        sql = "SELECT * FROM MauSac WHERE id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            MauSac ms = null;
            while (rs.next()) {
                ms = new MauSac();
                ms.setId(rs.getInt(1));
                ms.setTenMau(rs.getString(2));
                ms.setNgayTao(rs.getDate(3));
                ms.setNguoiTao(rs.getString(4));
                ms.setNgaySua(rs.getDate(5));
                ms.setNguoiSua(rs.getString(6));
            }
            return ms;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<MauSac> findAll(String tenMauSac) {
        sql = "SELECT * FROM MauSac WHERE (? is null or TenMau like ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if (tenMauSac == null) {
                ps.setString(1, null);
                ps.setString(2, null);
            } else {
                ps.setString(1, tenMauSac);
                ps.setString(2, "%" + tenMauSac + "%");
            }
            ResultSet rs = ps.executeQuery();
            List<MauSac> mauSacList = new ArrayList<>();
            while (rs.next()) {
                MauSac ms = new MauSac();
                ms.setId(rs.getInt(1));
                ms.setTenMau(rs.getString(2));
                ms.setNgayTao(rs.getDate(3));
                ms.setNguoiTao(rs.getString(4));
                ms.setNgaySua(rs.getDate(5));
                ms.setNguoiSua(rs.getString(6));

                mauSacList.add(ms);

            }

            return mauSacList;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public MauSac findEntityByName(String name) {
        sql = "SELECT * FROM MauSac WHERE TenMau =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            MauSac ms = null;
            while (rs.next()) {
                ms = new MauSac();
                ms.setId(rs.getInt(1));
                ms.setTenMau(rs.getString(2));
                ms.setNgayTao(rs.getDate(3));
                ms.setNguoiTao(rs.getString(4));
                ms.setNgaySua(rs.getDate(5));
                ms.setNguoiSua(rs.getString(6));
            }
            return ms;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
