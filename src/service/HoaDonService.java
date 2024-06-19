/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import model.HoaDon;
import model.HoaDonChiTiet;
import repository.DBConnection;

/**
 *
 * @author thaitv
 */
public class HoaDonService {

    private static Connection conn = DBConnection.getConnection();

    public ArrayList<HoaDon> loadDataHoaDon() {
        String sql = "SELECT Id, IdKhachHang, IdVoucher, IdNhanVien, SoLuong, TongTien,GiamGia, (TongTien - GiamGia) AS ThanhTien, NgayTao, NguoiTao, TrangThai FROM HoaDon Where TrangThai LIKE N'Đã thanh toán'";
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("Id");
                Integer idKhachHang = rs.getInt("IdKhachHang");
                Integer idVoucher = rs.getInt("IdVoucher");
                Integer idNhanVien = rs.getInt("IdNhanVien");
                Integer soLuong = rs.getInt("SoLuong");
                Double tongTien = rs.getDouble("TongTien");
                Double giamGia = rs.getDouble("GiamGia");
                Double thanhTien = rs.getDouble("ThanhTien");
                Date ngayTao = rs.getDate("NgayTao");
                String nguoiTao = rs.getString("NguoiTao");
                String trangThai = rs.getString("TrangThai");

                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(id);
                hoaDon.setIdKH(idKhachHang);
                hoaDon.setIdVoucher(idVoucher);
                hoaDon.setIdNV(idNhanVien);
                hoaDon.setSoLuong(soLuong);
                hoaDon.setTongTien(tongTien);
                hoaDon.setGiamGia(giamGia);
                hoaDon.setThanhTien(thanhTien);
                hoaDon.setNgayTao(ngayTao);
                hoaDon.setNguoiTao(nguoiTao);
                hoaDon.setTrangThai(trangThai);
                listHoaDon.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<HoaDon> daThanhToan() {
        String sql = "SELECT Id, IdKhachHang, IdVoucher, IdNhanVien, SoLuong, TongTien, "
                + "GiamGia, (TongTien - GiamGia) AS ThanhTien, NgayTao, NguoiTao, TrangThai FROM HoaDon WHERE TrangThai = N'Đã thanh toán'";
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("Id");
                Integer idKhachHang = rs.getInt("IdKhachHang");
                Integer idVoucher = rs.getInt("IdVoucher");
                Integer idNhanVien = rs.getInt("IdNhanVien");
                Integer soLuong = rs.getInt("SoLuong");
                Double tongTien = rs.getDouble("TongTien");
                Double giamGia = rs.getDouble("GiamGia");
                Double thanhTien = rs.getDouble("ThanhTien");
                Date ngayTao = rs.getDate("NgayTao");
                String nguoiTao = rs.getString("NguoiTao");
                String trangThai = rs.getString("TrangThai");

                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(id);
                hoaDon.setIdKH(idKhachHang);
                hoaDon.setIdVoucher(idVoucher);
                hoaDon.setIdNV(idNhanVien);
                hoaDon.setSoLuong(soLuong);
                hoaDon.setTongTien(tongTien);
                hoaDon.setGiamGia(giamGia);
                hoaDon.setThanhTien(thanhTien);
                hoaDon.setNgayTao(ngayTao);
                hoaDon.setNguoiTao(nguoiTao);
                hoaDon.setTrangThai(trangThai);
                listHoaDon.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<HoaDon> choThanhToan() {
        String sql = "SELECT Id, IdKhachHang, IdVoucher, IdNhanVien, SoLuong, TongTien, "
                + "GiamGia, (TongTien - GiamGia) AS ThanhTien, NgayTao, NguoiTao, TrangThai FROM HoaDon WHERE TrangThai = N'Chờ thanh toán'";
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("Id");
                Integer idKhachHang = rs.getInt("IdKhachHang");
                Integer idVoucher = rs.getInt("IdVoucher");
                Integer idNhanVien = rs.getInt("IdNhanVien");
                Integer soLuong = rs.getInt("SoLuong");
                Double tongTien = rs.getDouble("TongTien");
                Double giamGia = rs.getDouble("GiamGia");
                Double thanhTien = rs.getDouble("ThanhTien");
                Date ngayTao = rs.getDate("NgayTao");
                String nguoiTao = rs.getString("NguoiTao");
                String trangThai = rs.getString("TrangThai");

                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(id);
                hoaDon.setIdKH(idKhachHang);
                hoaDon.setIdVoucher(idVoucher);
                hoaDon.setIdNV(idNhanVien);
                hoaDon.setSoLuong(soLuong);
                hoaDon.setTongTien(tongTien);
                hoaDon.setGiamGia(giamGia);
                hoaDon.setThanhTien(thanhTien);
                hoaDon.setNgayTao(ngayTao);
                hoaDon.setNguoiTao(nguoiTao);
                hoaDon.setTrangThai(trangThai);
                listHoaDon.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<HoaDon> daHuy() {
        String sql = "SELECT Id, IdKhachHang, IdVoucher, IdNhanVien, SoLuong, TongTien, "
                + "GiamGia, (TongTien - GiamGia) AS ThanhTien, NgayTao, NguoiTao, TrangThai FROM HoaDon WHERE TrangThai = N'Đã hủy'";
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("Id");
                Integer idKhachHang = rs.getInt("IdKhachHang");
                Integer idVoucher = rs.getInt("IdVoucher");
                Integer idNhanVien = rs.getInt("IdNhanVien");
                Integer soLuong = rs.getInt("SoLuong");
                Double tongTien = rs.getDouble("TongTien");
                Double giamGia = rs.getDouble("GiamGia");
                Double thanhTien = rs.getDouble("ThanhTien");
                Date ngayTao = rs.getDate("NgayTao");
                String nguoiTao = rs.getString("NguoiTao");
                String trangThai = rs.getString("TrangThai");

                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(id);
                hoaDon.setIdKH(idKhachHang);
                hoaDon.setIdVoucher(idVoucher);
                hoaDon.setIdNV(idNhanVien);
                hoaDon.setSoLuong(soLuong);
                hoaDon.setTongTien(tongTien);
                hoaDon.setGiamGia(giamGia);
                hoaDon.setThanhTien(thanhTien);
                hoaDon.setNgayTao(ngayTao);
                hoaDon.setNguoiTao(nguoiTao);
                hoaDon.setTrangThai(trangThai);
                
                listHoaDon.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<HoaDon> searchById(int id) {
        String sql = "SELECT Id, IdKhachHang, IdVoucher, IdNhanVien, SoLuong, TongTien, "
                + "GiamGia, (TongTien - GiamGia) AS ThanhTien, NgayTao, NguoiTao, TrangThai FROM HoaDon WHERE Id = ?";
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer idHoaDon = rs.getInt("Id");
                Integer idKhachHang = rs.getInt("IdKhachHang");
                Integer idVoucher = rs.getInt("IdVoucher");
                Integer idNhanVien = rs.getInt("IdNhanVien");
                Integer soLuong = rs.getInt("SoLuong");
                Double tongTien = rs.getDouble("TongTien");
                Double giamGia = rs.getDouble("GiamGia");
                Double thanhTien = rs.getDouble("ThanhTien");
                Date ngayTao = rs.getDate("NgayTao");
                String nguoiTao = rs.getString("NguoiTao");
                String trangThai = rs.getString("TrangThai");

                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(idHoaDon);
                hoaDon.setIdKH(idKhachHang);
                hoaDon.setIdVoucher(idVoucher);
                hoaDon.setIdNV(idNhanVien);
                hoaDon.setSoLuong(soLuong);
                hoaDon.setTongTien(tongTien);
                hoaDon.setGiamGia(giamGia);
                hoaDon.setThanhTien(thanhTien);
                hoaDon.setNgayTao(ngayTao);
                hoaDon.setNguoiTao(nguoiTao);
                hoaDon.setTrangThai(trangThai);
                listHoaDon.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<HoaDonChiTiet> loadHoaDonandHDCT(int id) {
        String sql = "SELECT hdct.Id, spct.IdSanPham, hdct.Gia, hdct.SoLuong, (hdct.Gia * hdct.SoLuong) AS TongTien,"
                + "hd.GiamGia, ((hdct.Gia * hdct.SoLuong) - hd.GiamGia) AS ThanhTien FROM HDCT hdct JOIN SPCT spct ON hdct.IdSPCT = spct.Id JOIN HoaDon hd ON hdct.IdHoaDon = hd.Id AND hd.Id = " + "'" + id + "'";
        ArrayList<HoaDonChiTiet> listHDCT = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idHoaDon = rs.getInt("Id");
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

    public ArrayList<HoaDon> timKiemIDHD(int id) {
        String sql = "select * from HoaDon "
                + " WHERE Id LIKE  '%" + id + "%'";
        ArrayList<HoaDon> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement pst = conn.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Integer idHoaDon = rs.getInt("Id");
                Integer idKhachHang = rs.getInt("IdKhachHang");
                Integer idVoucher = rs.getInt("IdVoucher");
                Integer idNhanVien = rs.getInt("IdNhanVien");
                Integer soLuong = rs.getInt("SoLuong");
                Double tongTien = rs.getDouble("TongTien");
                Double giamGia = rs.getDouble("GiamGia");
                Double thanhTien = rs.getDouble("ThanhTien");
                Date ngayTao = rs.getDate("NgayTao");
                String nguoiTao = rs.getString("NguoiTao");
                String trangThai = rs.getString("TrangThai");

                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(idHoaDon);
                hoaDon.setIdKH(idKhachHang);
                hoaDon.setIdVoucher(idVoucher);
                hoaDon.setIdNV(idNhanVien);
                hoaDon.setSoLuong(soLuong);
                hoaDon.setTongTien(tongTien);
                hoaDon.setGiamGia(giamGia);
                hoaDon.setThanhTien(thanhTien);
                hoaDon.setNgayTao(ngayTao);
                hoaDon.setNguoiTao(nguoiTao);
                hoaDon.setTrangThai(trangThai);
                list.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<HoaDon> timKiemHoaDon(int idHoaDon) {
        String sql = "SELECT Id, IdKhachHang, IdVoucher, IdNhanVien, SoLuong, TongTien, "
                + "GiamGia, (TongTien - GiamGia) AS ThanhTien, NgayTao, NguoiTao, TrangThai FROM HoaDon WHERE Id = ?";
        ArrayList<HoaDon> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, idHoaDon);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("Id");
                Integer idKhachHang = rs.getInt("IdKhachHang");
                Integer idVoucher = rs.getInt("IdVoucher");
                Integer idNhanVien = rs.getInt("IdNhanVien");
                Integer soLuong = rs.getInt("SoLuong");
                Double tongTien = rs.getDouble("TongTien");
                Double giamGia = rs.getDouble("GiamGia");
                Double thanhTien = rs.getDouble("ThanhTien");
                Date ngayTao = rs.getDate("NgayTao");
                String nguoiTao = rs.getString("NguoiTao");
                String trangThai = rs.getString("TrangThai");

                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(id);
                hoaDon.setIdKH(idKhachHang);
                hoaDon.setIdVoucher(idVoucher);
                hoaDon.setIdNV(idNhanVien);
                hoaDon.setSoLuong(soLuong);
                hoaDon.setTongTien(tongTien);
                hoaDon.setGiamGia(giamGia);
                hoaDon.setThanhTien(thanhTien);
                hoaDon.setNgayTao(ngayTao);
                hoaDon.setNguoiTao(nguoiTao);
                hoaDon.setTrangThai(trangThai);
                list.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<HoaDon> loadNgayStart(String ngayTaooo) {
        String sql = "SELECT Id, IdKhachHang, IdVoucher, IdNhanVien, SoLuong, TongTien, "
                + "GiamGia, (TongTien - GiamGia) AS ThanhTien, NgayTao, NguoiTao, TrangThai FROM HoaDon WHERE NgayTao >= ?";
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ngayTaooo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer idHoaDon = rs.getInt("Id");
                Integer idKhachHang = rs.getInt("IdKhachHang");
                Integer idVoucher = rs.getInt("IdVoucher");
                Integer idNhanVien = rs.getInt("IdNhanVien");
                Integer soLuong = rs.getInt("SoLuong");
                Double tongTien = rs.getDouble("TongTien");
                Double giamGia = rs.getDouble("GiamGia");
                Double thanhTien = rs.getDouble("ThanhTien");
                Date ngayTao = rs.getDate("NgayTao");
                String nguoiTao = rs.getString("NguoiTao");
                String trangThai = rs.getString("TrangThai");

                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(idHoaDon);
                hoaDon.setIdKH(idKhachHang);
                hoaDon.setIdVoucher(idVoucher);
                hoaDon.setIdNV(idNhanVien);
                hoaDon.setSoLuong(soLuong);
                hoaDon.setTongTien(tongTien);
                hoaDon.setGiamGia(giamGia);
                hoaDon.setThanhTien(thanhTien);
                hoaDon.setNgayTao(ngayTao);
                hoaDon.setNguoiTao(nguoiTao);
                hoaDon.setTrangThai(trangThai);
                listHoaDon.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<HoaDon> loadNgayEnd(String ngayKetThucccc) {
        String sql = "SELECT Id, IdKhachHang, IdVoucher, IdNhanVien, SoLuong, TongTien, "
                + "GiamGia, (TongTien - GiamGia) AS ThanhTien, NgayTao, NguoiTao, TrangThai FROM HoaDon WHERE NgayTao >= ?";
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ngayKetThucccc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer idHoaDon = rs.getInt("Id");
                Integer idKhachHang = rs.getInt("IdKhachHang");
                Integer idVoucher = rs.getInt("IdVoucher");
                Integer idNhanVien = rs.getInt("IdNhanVien");
                Integer soLuong = rs.getInt("SoLuong");
                Double tongTien = rs.getDouble("TongTien");
                Double giamGia = rs.getDouble("GiamGia");
                Double thanhTien = rs.getDouble("ThanhTien");
                Date ngayTao = rs.getDate("NgayTao");
                String nguoiTao = rs.getString("NguoiTao");
                String trangThai = rs.getString("TrangThai");

                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(idHoaDon);
                hoaDon.setIdKH(idKhachHang);
                hoaDon.setIdVoucher(idVoucher);
                hoaDon.setIdNV(idNhanVien);
                hoaDon.setSoLuong(soLuong);
                hoaDon.setTongTien(tongTien);
                hoaDon.setGiamGia(giamGia);
                hoaDon.setThanhTien(thanhTien);
                hoaDon.setNgayTao(ngayTao);
                hoaDon.setNguoiTao(nguoiTao);
                hoaDon.setTrangThai(trangThai);
                listHoaDon.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public ArrayList<HoaDon> timKiemTheoNgayThang(String ngayBD, String ngayKT) {
        String sql = "SELECT Id, IdKhachHang, IdVoucher, IdNhanVien, SoLuong, TongTien, \n"
                + "       GiamGia, (TongTien - GiamGia) AS ThanhTien, NgayTao, NguoiTao, TrangThai \n"
                + "FROM HoaDon \n"
                + "WHERE (NgayTao IS NULL OR NgayTao >= ?) AND (NgayTao IS NULL OR NgayTao <= ?) AND TrangThai Like N'Đã thanh toán';";
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ngayBD);
            ps.setString(2, ngayKT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer idHoaDon = rs.getInt("Id");
                Integer idKhachHang = rs.getInt("IdKhachHang");
                Integer idVoucher = rs.getInt("IdVoucher");
                Integer idNhanVien = rs.getInt("IdNhanVien");
                Integer soLuong = rs.getInt("SoLuong");
                Double tongTien = rs.getDouble("TongTien");
                Double giamGia = rs.getDouble("GiamGia");
                Double thanhTien = rs.getDouble("ThanhTien");
                Date ngayTao = rs.getDate("NgayTao");
                String nguoiTao = rs.getString("NguoiTao");
                String trangThai = rs.getString("TrangThai");

                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(idHoaDon);
                hoaDon.setIdKH(idKhachHang);
                hoaDon.setIdVoucher(idVoucher);
                hoaDon.setIdNV(idNhanVien);
                hoaDon.setSoLuong(soLuong);
                hoaDon.setTongTien(tongTien);
                hoaDon.setGiamGia(giamGia);
                hoaDon.setThanhTien(thanhTien);
                hoaDon.setNgayTao(ngayTao);
                hoaDon.setNguoiTao(nguoiTao);
                hoaDon.setTrangThai(trangThai);
                listHoaDon.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }
}
