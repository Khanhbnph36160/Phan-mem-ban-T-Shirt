/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HoaDon;
import model.HoaDonChiTiet;
import repository.DBConnection;

/**
 *
 * @author thaitv
 */
public class ThongKeService {

    private Connection conn = DBConnection.getConnection();
    private int i = 0;
    private float b = 0;

    public Integer thongKeHoaDonTheoNgay() {
        String sql = "SELECT COUNT(Id) AS SoHoaDon FROM HoaDon WHERE CONVERT(date, NgayTao) = CONVERT(date, "
                + "GETDATE()) AND TrangThai LIKE N'Đã thanh toán'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                i = Integer.valueOf(rs.getString("SoHoaDon")) == null ? 0 : Integer.valueOf(rs.getString("SoHoaDon"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public Float thongKeDoanhThuTheoNgay() {
        String sql = "SELECT sum(TongTien) AS TongTien FROM HoaDon WHERE CONVERT(date, NgayTao) = "
                + "CONVERT(date, GETDATE()) AND TrangThai LIKE N'Đã thanh toán'";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String a = rs.getString("TongTien");
                if (a == null || a.isEmpty()) {
                    b = 0;
                } else {
                    b = Float.valueOf(a);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }

    public ArrayList<HoaDon> loadDataHoaDon() {
        String sql = "SELECT Id, NgayTao, (TongTien - GiamGia) AS ThanhTien FROM HoaDon WHERE TrangThai = N'Đã thanh toán'";
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(rs.getInt("Id"));
                hoaDon.setNgayTao(rs.getDate("NgayTao"));
                hoaDon.setThanhTien(rs.getDouble("ThanhTien"));
                listHoaDon.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<HoaDonChiTiet> loadHoaDonandHDCT() {
        String sql = "SELECT hdct.Id, spct.IdSanPham, sp.TenSanPham, SUM(hdct.SoLuong) AS TongSoLuong, "
                + "SUM((hdct.Gia * hdct.SoLuong) - hd.GiamGia) AS ThanhTien FROM HDCT hdct JOIN SPCT spct ON "
                + "hdct.IdSPCT = spct.Id JOIN SanPham sp ON spct.IdSanPham = sp.Id JOIN HoaDon hd ON hdct.IdHoaDon = "
                + "hd.Id GROUP BY hdct.Id, spct.IdSanPham, sp.TenSanPham, hdct.Gia, hd.GiamGia;";
        ArrayList<HoaDonChiTiet> listHDCT = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setIdSanPham(rs.getInt("IdSanPham"));
                hdct.setTenSP(rs.getString("TenSanPham"));
                hdct.setSoLuong(rs.getInt("TongSoLuong"));
                hdct.setThanhTien(rs.getInt("ThanhTien"));
                listHDCT.add(hdct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }

    float T;

    public Float tongDoanhThu() {
        String sql = "SELECT SUM((TongTien - GiamGia)) AS ThanhTien FROM HoaDon";
        ArrayList<HoaDon> listTong = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String a = rs.getString("ThanhTien");
                if (a == null || a.isEmpty()) {
                    T = 0;
                } else {
                    T = Float.valueOf(a);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return T;
    }

    
     public ArrayList<HoaDonChiTiet> timKiem(String ngayBD, String ngayKT) {
        String sql = "SELECT hdct.Id, spct.IdSanPham, sp.TenSanPham, SUM(hdct.SoLuong) AS TongSoLuong, "
                + "SUM((hdct.Gia * hdct.SoLuong) - hd.GiamGia) AS ThanhTien FROM HDCT hdct JOIN SPCT spct ON "
                + "hdct.IdSPCT = spct.Id JOIN SanPham sp ON spct.IdSanPham = sp.Id JOIN HoaDon hd ON hdct.IdHoaDon = "
                + "hd.Id WHERE hdct.NgayTao >= '" + ngayBD + "' AND hdct.NgayTao <= '" + ngayKT + "' GROUP BY hdct.Id, spct.IdSanPham, sp.TenSanPham, hdct.Gia, hd.GiamGia";
        ArrayList<HoaDonChiTiet> listHDCT = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setIdSanPham(rs.getInt("IdSanPham"));
                hdct.setTenSP(rs.getString("TenSanPham"));
                hdct.setSoLuong(rs.getInt("TongSoLuong"));
                hdct.setThanhTien(rs.getInt("ThanhTien"));
                listHDCT.add(hdct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }
     
      public ArrayList<HoaDon> hoaDonSearch(String ngayBD, String ngayKT) {
        String sql = "SELECT Id, NgayTao, (TongTien - GiamGia) AS ThanhTien FROM HoaDon WHERE NgayTao >= ? and NgayTao <= ? and TrangThai = N'Đã thanh toán'";
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ngayBD);
            ps.setString(2, ngayKT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(rs.getInt("Id"));
                hoaDon.setNgayTao(rs.getDate("NgayTao"));
                hoaDon.setThanhTien(rs.getDouble("ThanhTien"));
                listHoaDon.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }
      
       float TK = 0;
    
    public Float TongDoanhThuTimKiem(String NgayBD, String NgayKT) {
        try {
            String sql = "SELECT SUM((TongTien - GiamGia)) AS ThanhTien FROM HoaDon WHERE NgayTao >= ? and NgayTao <= ? and   TrangThai LIKE N'Đã thanh toán'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, NgayBD);
            ps.setString(2, NgayKT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String a = rs.getString("ThanhTien");
                if (a == null || a.isEmpty()) {
                    TK = 0;
                } else {
                    TK = Float.valueOf(a);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return TK;
    }
}
