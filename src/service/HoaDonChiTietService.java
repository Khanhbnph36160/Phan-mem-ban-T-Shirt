/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import model.HoaDonChiTiet;
import repository.DBConnection;

/**
 *
 * @author thaitv
 */
public class HoaDonChiTietService {

    private static Connection conn = DBConnection.getConnection();

    public ArrayList<HoaDonChiTiet> loadHDCT() {
        String sql = "SELECT hdct.Id, spct.IdSanPham, sp.TenSanPham, hdct.Gia, hdct.SoLuong, "
                + "(hdct.Gia * hdct.SoLuong) AS TongTien, hd.GiamGia, ((hdct.Gia * hdct.SoLuong) - hd.GiamGia) AS ThanhTien, hdct.TrangThai "
                + "FROM HDCT hdct JOIN SPCT spct ON hdct.IdSPCT = spct.Id JOIN SanPham sp ON spct.IdSanPham = sp.Id JOIN HoaDon hd ON "
                + "hdct.IdHoaDon = hd.Id WHERE hdct.TrangThai = N'Đã thanh toán'";
        ArrayList<HoaDonChiTiet> listHDCT = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                int idSP = rs.getInt("IdSanPham");
                String tenSP = rs.getString("TenSanPham");
                int gia = rs.getInt("Gia");
                int soLuong = rs.getInt("SoLuong");
                int tongTien = rs.getInt("TongTien");
                int giamGia = rs.getInt("GiamGia");
                int thanhTien = rs.getInt("ThanhTien");

                HoaDonChiTiet hdct = new HoaDonChiTiet(idSP, idSP, gia, soLuong, tongTien, giamGia, thanhTien, tenSP);
                listHDCT.add(hdct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }

    public ArrayList<HoaDonChiTiet> mouseClicked(int idHoaDon) {
        String sql = "SELECT hdct.Id, spct.IdSanPham, sp.TenSanPham, hdct.Gia, hdct.SoLuong, "
                + "(hdct.Gia * hdct.SoLuong) AS TongTien, hd.GiamGia, ((hdct.Gia * hdct.SoLuong) - hd.GiamGia) AS ThanhTien, hd.TrangThai "
                + "FROM HDCT hdct JOIN SPCT spct ON hdct.IdSPCT = spct.Id JOIN SanPham sp ON spct.IdSanPham = sp.Id JOIN HoaDon hd ON "
                + "hdct.IdHoaDon = hd.Id WHERE hd.TrangThai = N'Đã thanh toán' AND hd.ID = " + "'" + idHoaDon + "'";
        ArrayList<HoaDonChiTiet> listHDCT = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                int idSP = rs.getInt("IdSanPham");
                String tenSP = rs.getString("TenSanPham");
                int gia = rs.getInt("Gia");
                int soLuong = rs.getInt("SoLuong");
                int tongTien = rs.getInt("TongTien");
                int giamGia = rs.getInt("GiamGia");
                int thanhTien = rs.getInt("ThanhTien");

                HoaDonChiTiet hdct = new HoaDonChiTiet(idSP, idSP, gia, soLuong, tongTien, giamGia, thanhTien, tenSP);
                listHDCT.add(hdct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }

    public ArrayList<HoaDonChiTiet> loadHDAndHDCT(int idHoaDon) {
        String sql = "SELECT hdct.Id, spct.IdSanPham, sp.TenSanPham, hdct.Gia, hdct.SoLuong, "
                + "(hdct.Gia * hdct.SoLuong) AS TongTien, hd.GiamGia, ((hdct.Gia * hdct.SoLuong) - hd.GiamGia) AS ThanhTien, hd.TrangThai "
                + "FROM HDCT hdct JOIN SPCT spct ON hdct.IdSPCT = spct.Id JOIN SanPham sp ON spct.IdSanPham = sp.Id JOIN HoaDon hd ON "
                + "hdct.IdHoaDon = hd.Id WHERE hd.TrangThai = N'Đã thanh toán' AND hd.ID = " + "'" + idHoaDon + "'";
        ArrayList<HoaDonChiTiet> listHDCT = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                int idSP = rs.getInt("IdSanPham");
                String tenSP = rs.getString("TenSanPham");
                int gia = rs.getInt("Gia");
                int soLuong = rs.getInt("SoLuong");
                int tongTien = rs.getInt("TongTien");
                int giamGia = rs.getInt("GiamGia");
                int thanhTien = rs.getInt("ThanhTien");

                HoaDonChiTiet hdct = new HoaDonChiTiet(id, idSP, gia, soLuong, tongTien, giamGia, thanhTien, tenSP);
                listHDCT.add(hdct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }

    public ArrayList<HoaDonChiTiet> searchHoaDonChiTiet(Integer idSP) {
        String sql = "SELECT hdct.Id, spct.IdSanPham, sp.TenSanPham, hdct.Gia, hdct.SoLuong, "
                + "(hdct.Gia * hdct.SoLuong) AS TongTien, hd.GiamGia, ((hdct.Gia * hdct.SoLuong) - hd.GiamGia) AS ThanhTien, hd.TrangThai "
                + "FROM HDCT hdct JOIN SPCT spct ON hdct.IdSPCT = spct.Id JOIN SanPham sp ON spct.IdSanPham = sp.Id JOIN HoaDon hd ON "
                + "hdct.IdHoaDon = hd.Id WHERE spct.IdSanPham = ?";
        ArrayList<HoaDonChiTiet> listHDCT = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                int idSanPham = rs.getInt("IdSanPham");
                String tenSP = rs.getString("TenSanPham");
                int gia = rs.getInt("Gia");
                int soLuong = rs.getInt("SoLuong");
                int tongTien = rs.getInt("TongTien");
                int giamGia = rs.getInt("GiamGia");
                int thanhTien = rs.getInt("ThanhTien");

                HoaDonChiTiet hdct = new HoaDonChiTiet(id, idSanPham, gia, soLuong, tongTien, giamGia, thanhTien, tenSP);
                listHDCT.add(hdct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHDCT;
    }

    public ArrayList<HoaDonChiTiet> findSPCTAndHDCT(Integer idSP) {
        String sql = "SELECT hdct.Id, spct.IdSanPham, sp.TenSanPham, hdct.Gia, hdct.SoLuong, "
                + "(hdct.Gia * hdct.SoLuong) AS TongTien, hd.GiamGia, ((hdct.Gia * hdct.SoLuong) - hd.GiamGia) AS ThanhTien, hd.TrangThai "
                + "FROM HDCT hdct JOIN SPCT spct ON hdct.IdSPCT = spct.Id JOIN SanPham sp ON spct.IdSanPham = sp.Id JOIN HoaDon hd ON "
                + "hdct.IdHoaDon = hd.Id WHERE spct.IdSanPham = '" + idSP + "'";
        ArrayList<HoaDonChiTiet> listHDCT = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idSP);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("Id");
                int idSanPham = rs.getInt("IdSanPham");
                String tenSP = rs.getString("TenSanPham");
                int gia = rs.getInt("Gia");
                int soLuong = rs.getInt("SoLuong");
                int tongTien = rs.getInt("TongTien");
                int giamGia = rs.getInt("GiamGia");
                int thanhTien = rs.getInt("ThanhTien");

                HoaDonChiTiet hdct = new HoaDonChiTiet(id, idSanPham, gia, soLuong, tongTien, giamGia, thanhTien, tenSP);
                listHDCT.add(hdct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHDCT;
    }

    public Integer findIdHDCTByIdSanPhamChiTietAndIdHoaDon(Integer idHoaDon, Integer idSPCT) {
        String sql = "SELECT id FROM HDCT WHERE idHoaDon = ? AND idSPCT = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, idHoaDon);
            ps.setObject(2, idSPCT);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
