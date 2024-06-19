/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Model.SanPhamChiTiet;
import java.util.ArrayList;
import model.Vouchermode;
import java.sql.*;
import java.util.Objects;
import model.HDCT;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.HoaDonChiTietViewModel;
import model.SanPhamChiTietViewBanHang;
import repository.DBConnection;

/**
 *
 * @author thaitv
 */
public class BanHangService {

    private static Connection conn = DBConnection.getConnection();

    public ArrayList<HoaDon> listHoaDon() {
        String sql = "SELECT * FROM HoaDon";
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(rs.getInt("Id"));
                hoaDon.setNgayTao(rs.getDate("NgayTao"));
                hoaDon.setIdNV(rs.getInt("IdNhanVien"));
                hoaDon.setTrangThai(rs.getString("TrangThai"));

                listHoaDon.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public void createHoaDon(HoaDon hd) {
        String sql = "INSERT INTO HoaDon (NgayTao, TrangThai) VALUES ( ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, hd.getNgayTao());
            ps.setObject(2, hd.getTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public ArrayList<SanPhamChiTietViewBanHang> getListProduct(String tenSanPham) {
        String sql = "SELECT SPCT.Id, SPCT.IdSanPham, SP.TenSanPham, MauSac.TenMau, Size.TenSize, "
                + "ChatLieu.TenChatLieu, ThuongHieu.TenThuongHieu, SP.SoLuong, SPCT.Gia FROM SPCT JOIN "
                + "SanPham SP ON SPCT.IdSanPham = SP.Id JOIN MauSac ON SPCT.IdMauSac = MauSac.Id JOIN Size ON "
                + "SPCT.IdSize = Size.Id JOIN ChatLieu ON SPCT.IdChatLieu = ChatLieu.Id JOIN ThuongHieu "
                + "ON SPCT.IdThuongHieu = ThuongHieu.Id WHERE (? is null or sp.tenSanPham like ?) AND SPCT.trangThai = 'Còn hàng' "
                + "and sp.soluong > 0";
        ArrayList<SanPhamChiTietViewBanHang> listProduct = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, tenSanPham);
                ps.setString(2, "%" + tenSanPham + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamChiTietViewBanHang sanPham = new SanPhamChiTietViewBanHang();
                sanPham.setIdSanPham(rs.getInt("IdSanPham"));
                sanPham.setTenSanPham(rs.getString("TenSanPham"));
                sanPham.setMau(rs.getString("TenMau"));
                sanPham.setSize(rs.getString("TenSize"));
                sanPham.setChatLieu(rs.getString("TenChatLieu"));
                sanPham.setThuongHieu(rs.getString("TenThuongHieu"));
                sanPham.setSoLuong(rs.getInt("SoLuong"));
                sanPham.setGia(rs.getInt("Gia"));
                sanPham.setIdSPCT(rs.getInt(1));

                listProduct.add(sanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listProduct;
    }

    public ArrayList<HoaDonChiTiet> getListShoppingCart(Integer idHoaDon) {
        String sql = "SELECT HDCT.Id, HDCT.IdSPCT, SPCT.IdSanPham, SP.TenSanPham, HDCT.Gia, HDCT.SoLuong, "
                + "(HDCT.Gia * HDCT.SoLuong) AS ThanhTien, HoaDon.Id FROM HDCT JOIN SPCT ON HDCT.IdSPCT = SPCT.Id JOIN "
                + "SanPham SP ON SPCT.IdSanPham = SP.Id JOIN HoaDon ON HDCT.IdHoaDon = HoaDon.Id WHERE HoaDon.Id = '" + idHoaDon + "' GROUP BY HDCT.Id, HDCT.IdSPCT, "
                + "SPCT.IdSanPham, SP.TenSanPham, HDCT.Gia, HDCT.SoLuong, HoaDon.Id";
        ArrayList<HoaDonChiTiet> listShoppingCart = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setIdSanPham(rs.getInt("IdSanPham"));
                hdct.setTenSP(rs.getString("TenSanPham"));
                hdct.setGia(rs.getInt("Gia"));
                hdct.setSoLuong(rs.getInt("SoLuong"));
                hdct.setThanhTien(rs.getInt("ThanhTien"));
                hdct.setIdSPCT(rs.getInt(2));

                listShoppingCart.add(hdct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listShoppingCart;
    }

    public void addHoaDon(HoaDon hd) {
        String sql = "INSERT INTO HoaDon (idNhanVien, NgayTao, TrangThai) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, hd.getId());
            ps.setObject(2, hd.getIdNV());
            ps.setObject(3, hd.getNgayTao());
            ps.setObject(4, hd.getTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Boolean huyHoaDon(Integer idHoaDon) {
        String sql = "UPDATE HoaDon SET TrangThai = N'Đã hủy' WHERE Id = '" + idHoaDon + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<Vouchermode> listVoucherClient(Integer idNhanVien) {
        String sql = "SELECT HoaDon.Id AS IdHoaDon, Voucher.IdNhanVien,Voucher.TenVoucher, "
                + "Voucher.GiaTri ,  Voucher.GiaTriToiThieu, Voucher.GiaTriToiDa, Voucher.TrangThai FROM Voucher JOIN HoaDon ON Voucher.Id = HoaDon.Id "
                + "WHERE Voucher.TrangThai = N'Hoạt động' AND Voucher.IdNhanVien = '" + idNhanVien + "'";
        ArrayList<Vouchermode> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vouchermode vouchermode = new Vouchermode();
                vouchermode.setIdHoaDon(rs.getInt("IdHoaDon"));
                vouchermode.setIdNhanVien(rs.getInt("IdNhanVien"));
                vouchermode.setTenVoucher(rs.getString("TenVoucher"));
                vouchermode.setGiatri(rs.getBigDecimal("GiaTri"));
                vouchermode.setGiaTriToiThieu(rs.getBigDecimal("GiaTriToiThieu"));
                vouchermode.setGiaTriToiDa(rs.getBigDecimal("GiaTriToiDa"));

                list.add(vouchermode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Boolean ThanhToan(HoaDon hd) {
        try {
            String sql = "UPDATE HoaDon SET TrangThai = N'Đã thanh toán', IdNhanVien = ?, IdKhachHang = ?, IdVoucher = ?, TongTien =?, GiamGia= ?, "
                    + "ThanhTien =?, TienKhachDua= ?, TienTRaLai =?, NgayTao =? WHERE Id = ?";
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, hd.getIdNV());
            ps.setInt(2, hd.getIdKH());
            ps.setObject(3, Objects.isNull(hd.getIdVoucher()) ? null : hd.getIdVoucher());
            ps.setDouble(4, hd.getTongTien());
            ps.setDouble(5, hd.getGiamGia());
            ps.setDouble(6, hd.getThanhTien());
            ps.setDouble(7, hd.getTienKhachDua());
            ps.setDouble(8, hd.getTienThua());
            ps.setDate(9, hd.getNgayTao());
            ps.setInt(10, hd.getId());

            int record = ps.executeUpdate();
            System.out.println(record);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<Vouchermode> listVoucher() {
        String sql = "SELECT HoaDon.Id AS IdHoaDon, Voucher.IdNhanVien,Voucher.TenVoucher, "
                + "Voucher.GiaTri ,  Voucher.GiaTriToiThieu, Voucher.GiaTriToiDa, Voucher.TrangThai FROM Voucher JOIN HoaDon ON Voucher.Id = HoaDon.Id "
                + "WHERE Voucher.TrangThai = N'Hoạt động' AND Voucher.IdNhanVien IS NULL";
        ArrayList<Vouchermode> list = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vouchermode vouchermode = new Vouchermode();
                vouchermode.setIdHoaDon(rs.getInt("IdHoaDon"));
                vouchermode.setIdNhanVien(rs.getInt("IdNhanVien"));
                vouchermode.setTenVoucher(rs.getString("TenVoucher"));
                vouchermode.setGiatri(rs.getBigDecimal("GiaTri"));
                vouchermode.setGiaTriToiThieu(rs.getBigDecimal("GiaTriToiThieu"));
                vouchermode.setGiaTriToiDa(rs.getBigDecimal("GiaTriToiDa"));

                list.add(vouchermode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateGioHang(Integer soLuong, Integer idHDCT) {
        String sql = "UPDATE HDCT SET SoLuong = ? WHERE Id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, soLuong);
            ps.setInt(2, idHDCT);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void themGioHang(HDCT hdct) {
        String sql = "INSERT INTO HDCT VALUES (?, ?, ?, ?, ?. ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, hdct.getId());
            ps.setObject(2, hdct.getIdSPCT());
            ps.setObject(3, hdct.getIdHoaDon());
            ps.setObject(4, hdct.getGia());
            ps.setObject(5, hdct.getSoLuong());
            ps.setObject(6, hdct.getTrangThai());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void xoaGioHang(String idSPCT, int idHoaDon) {
        String sql = "DELETE HDCT WHERE IdSPCT = ? AND IdHoaDon = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idSPCT);
            ps.setInt(2, idHoaDon);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addGioHang(HoaDonChiTietViewModel hdct) {
        String sql = "INSERT INTO HDCT(IdSPCT, IdHoaDon, Gia, TrangThai, SoLuong, "
                + "NgayTao, NguoiTao, NgaySua, NguoiSua) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, hdct.getIdSPCT());
            ps.setObject(2, hdct.getIdHoaDon());
            ps.setObject(3, hdct.getGia());
            ps.setObject(4, hdct.getTrangThai());
            ps.setObject(5, hdct.getSoLuong());
            ps.setObject(6, hdct.getNgayTao());
            ps.setObject(7, hdct.getNguoiTao());
            ps.setObject(8, hdct.getNgaySua());
            ps.setObject(9, hdct.getNguoiSua());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void suaSanPham(String sl, Integer idSanPham, Integer idSPCT) {
        String sql = "UPDATE sp "
                + " SET SoLuong = ? FROM SanPham sp JOIN SPCT spct on sp.id = spct.idSanPham "
                + " WHERE sp.id = ? and spct.id =? ";
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, sl);
            ps.setInt(2, idSanPham);
            ps.setInt(3, idSPCT);
            ps.executeUpdate();
            System.out.println("update sp done");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteSanPhamInCart(boolean isDeletedAll, Integer idHD, Integer idSPCT) {
        String sql = "DELETE FROM HDCT WHERE IdHoaDon = ? ";

        if (!isDeletedAll) {
            sql += " AND IdCTSP = " + idSPCT;
        }
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idHD);
            ps.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
