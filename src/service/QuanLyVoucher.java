package service;

import repository.DBConnection;
import static repository.DBConnection.getConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Vouchermode;

public class QuanLyVoucher {

    private Connection cn;

    public QuanLyVoucher() {
        try {
            cn = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void themVoucher(Vouchermode voucher) {
        try {
            String sql = "INSERT INTO Voucher (TenVoucher, IdNhanVien, SoLuong, GiaTriToiThieu, GiaTriToiDa, NgayBatDau, NgayKetThuc, TrangThai, NgayTao, NguoiTao, NgaySua, NguoiSua, GiaTri) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, voucher.getTenVoucher());
            ps.setInt(2, voucher.getIdNhanVien());
            ps.setInt(3, voucher.getSoLuong());
            ps.setBigDecimal(4, voucher.getGiaTriToiThieu());
            ps.setBigDecimal(5, voucher.getGiaTriToiDa());
            ps.setTimestamp(6, voucher.getNgayBatDau());
            ps.setTimestamp(7, voucher.getNgayKetThuc());
            ps.setString(8, voucher.getTrangThai());
            ps.setDate(9, voucher.getNgayTao());
            ps.setString(10, voucher.getNguoiTao());
            ps.setDate(11, voucher.getNgaySua());
            ps.setString(12, voucher.getNguoiSua());
            ps.setBigDecimal(13, voucher.getGiatri());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Vouchermode> getAllVouchers() {
        List<Vouchermode> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Voucher WHERE TrangThai = ? AND SoLuong >= ? AND NgayBatDau <= ? AND NgayKetThuc >= ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "Hoạt động");
            ps.setInt(2, 1);
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.setDate(4, Date.valueOf(LocalDate.now()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vouchermode voucher = new Vouchermode();
                voucher.setId(rs.getInt("Id"));
                voucher.setTenVoucher(rs.getString("TenVoucher"));
                voucher.setIdNhanVien(rs.getInt("IdNhanVien"));
                voucher.setSoLuong(rs.getInt("SoLuong"));
                voucher.setGiaTriToiThieu(rs.getBigDecimal("GiaTriToiThieu"));
                voucher.setGiaTriToiDa(rs.getBigDecimal("GiaTriToiDa"));
                voucher.setNgayBatDau(rs.getTimestamp("NgayBatDau"));
                voucher.setNgayKetThuc(rs.getTimestamp("NgayKetThuc"));
                voucher.setTrangThai(rs.getString("TrangThai"));
                voucher.setNgayTao(rs.getDate("NgayTao"));
                voucher.setNguoiTao(rs.getString("NguoiTao"));
                voucher.setNgaySua(rs.getDate("NgaySua"));
                voucher.setNguoiSua(rs.getString("NguoiSua"));
                voucher.setGiatri(rs.getBigDecimal("GiaTri"));
                list.add(voucher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Vouchermode getVoucherById(int id, double totalMoney) {
        Vouchermode voucher = null;
        try {
            String sql = "SELECT * FROM Voucher WHERE TrangThai = ? AND SoLuong >= ? AND NgayBatDau <= ? AND NgayKetThuc >= ? AND id = ? "
                    ;
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, "Hoạt động");
            ps.setInt(2, 1);
            ps.setDate(3, Date.valueOf(LocalDate.now()));
            ps.setDate(4, Date.valueOf(LocalDate.now()));
            ps.setInt(5, id);
//            ps.setDouble(6, totalMoney);
//            ps.setDouble(7, totalMoney);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                voucher = new Vouchermode();
                voucher.setId(rs.getInt("Id"));
                voucher.setTenVoucher(rs.getString("TenVoucher"));
                voucher.setIdNhanVien(rs.getInt("IdNhanVien"));
                voucher.setSoLuong(rs.getInt("SoLuong"));
                voucher.setGiaTriToiThieu(rs.getBigDecimal("GiaTriToiThieu"));
                voucher.setGiaTriToiDa(rs.getBigDecimal("GiaTriToiDa"));
                voucher.setNgayBatDau(rs.getTimestamp("NgayBatDau"));
                voucher.setNgayKetThuc(rs.getTimestamp("NgayKetThuc"));
                voucher.setTrangThai(rs.getString("TrangThai"));
                voucher.setNgayTao(rs.getDate("NgayTao"));
                voucher.setNguoiTao(rs.getString("NguoiTao"));
                voucher.setNgaySua(rs.getDate("NgaySua"));
                voucher.setNguoiSua(rs.getString("NguoiSua"));
                voucher.setGiatri(rs.getBigDecimal("GiaTri"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return voucher;
    }

    public void capNhatVoucher(Vouchermode voucher) {
        try {
            String sql = "UPDATE Voucher SET TenVoucher = ?, IdNhanVien = ?, SoLuong = ?, GiaTriToiThieu = ?, GiaTriToiDa = ?, NgayBatDau = ?, NgayKetThuc = ?, TrangThai = ?, NgayTao = ?, NguoiTao = ?, NgaySua = ?, NguoiSua = ?, GiaTri = ? WHERE Id = ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setString(1, voucher.getTenVoucher());
            ps.setInt(2, voucher.getIdNhanVien());
            ps.setInt(3, voucher.getSoLuong());
            ps.setBigDecimal(4, voucher.getGiaTriToiThieu());
            ps.setBigDecimal(5, voucher.getGiaTriToiDa());
            ps.setTimestamp(6, voucher.getNgayBatDau());
            ps.setTimestamp(7, voucher.getNgayKetThuc());
            ps.setString(8, voucher.getTrangThai());
            ps.setDate(9, voucher.getNgayTao());
            ps.setString(10, voucher.getNguoiTao());
            ps.setDate(11, voucher.getNgaySua());
            ps.setString(12, voucher.getNguoiSua());
            ps.setBigDecimal(13, voucher.getGiatri());
            ps.setInt(14, voucher.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Vouchermode> timVoucherTheoTuKhoa(String tuKhoa) {
        List<Vouchermode> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Voucher WHERE TenVoucher LIKE ? OR IdNhanVien LIKE ? OR SoLuong LIKE ? OR GiaTriToiThieu LIKE ? OR GiaTriToiDa LIKE ? OR NgayBatDau LIKE ? OR NgayKetThuc LIKE ? OR TrangThai LIKE ? OR NgayTao LIKE ? OR NguoiTao LIKE ? OR NgaySua LIKE ? OR NguoiSua LIKE ? OR GiaTri LIKE ?";
            PreparedStatement ps = cn.prepareStatement(sql);
            for (int i = 1; i <= 13; i++) {
                ps.setString(i, "%" + tuKhoa + "%");
            }
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Vouchermode voucher = new Vouchermode();
                voucher.setId(rs.getInt("Id"));
                voucher.setTenVoucher(rs.getString("TenVoucher"));
                voucher.setIdNhanVien(rs.getInt("IdNhanVien"));
                voucher.setSoLuong(rs.getInt("SoLuong"));
                voucher.setGiaTriToiThieu(rs.getBigDecimal("GiaTriToiThieu"));
                voucher.setGiaTriToiDa(rs.getBigDecimal("GiaTriToiDa"));
                voucher.setNgayBatDau(rs.getTimestamp("NgayBatDau"));
                voucher.setNgayKetThuc(rs.getTimestamp("NgayKetThuc"));
                voucher.setTrangThai(rs.getString("TrangThai"));
                voucher.setNgayTao(rs.getDate("NgayTao"));
                voucher.setNguoiTao(rs.getString("NguoiTao"));
                voucher.setNgaySua(rs.getDate("NgaySua"));
                voucher.setNguoiSua(rs.getString("NguoiSua"));
                voucher.setGiatri(rs.getBigDecimal("GiaTri"));
                list.add(voucher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Vouchermode> getVouchersByStatus(String status) {
        List<Vouchermode> vouchers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Voucher WHERE TrangThai = ?";
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vouchermode voucher = new Vouchermode();
                voucher.setId(rs.getInt("Id"));
                voucher.setTenVoucher(rs.getString("TenVoucher"));
                voucher.setIdNhanVien(rs.getInt("IdNhanVien"));
                voucher.setSoLuong(rs.getInt("SoLuong"));
                voucher.setGiaTriToiThieu(rs.getBigDecimal("GiaTriToiThieu"));
                voucher.setGiaTriToiDa(rs.getBigDecimal("GiaTriToiDa"));
                voucher.setNgayBatDau(rs.getTimestamp("NgayBatDau"));
                voucher.setNgayKetThuc(rs.getTimestamp("NgayKetThuc"));
                voucher.setTrangThai(rs.getString("TrangThai"));
                voucher.setNgayTao(rs.getDate("NgayTao"));
                voucher.setNguoiTao(rs.getString("NguoiTao"));
                voucher.setNgaySua(rs.getDate("NgaySua"));
                voucher.setNguoiSua(rs.getString("NguoiSua"));
                voucher.setGiatri(rs.getBigDecimal("GiaTri"));
                vouchers.add(voucher);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vouchers;
    }

    public List<Vouchermode> getVouchersByStatus(String status, int page, int pageSize) {
        List<Vouchermode> vouchers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY Id) AS RowNum, * FROM Voucher WHERE TrangThai = ?) AS Vouchers WHERE RowNum BETWEEN ? AND ?";
            PreparedStatement stmt = cn.prepareStatement(sql);
            stmt.setString(1, status);
            int start = (page - 1) * pageSize + 1;
            int end = start + pageSize - 1;
            stmt.setInt(2, start);
            stmt.setInt(3, end);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Vouchermode voucher = new Vouchermode();
                voucher.setId(rs.getInt("Id"));
                voucher.setTenVoucher(rs.getString("TenVoucher"));
                voucher.setIdNhanVien(rs.getInt("IdNhanVien"));
                voucher.setSoLuong(rs.getInt("SoLuong"));
                voucher.setGiaTriToiThieu(rs.getBigDecimal("GiaTriToiThieu"));
                voucher.setGiaTriToiDa(rs.getBigDecimal("GiaTriToiDa"));
                voucher.setNgayBatDau(rs.getTimestamp("NgayBatDau"));
                voucher.setNgayKetThuc(rs.getTimestamp("NgayKetThuc"));
                voucher.setTrangThai(rs.getString("TrangThai"));
                voucher.setNgayTao(rs.getDate("NgayTao"));
                voucher.setNguoiTao(rs.getString("NguoiTao"));
                voucher.setNgaySua(rs.getDate("NgaySua"));
                voucher.setNguoiSua(rs.getString("NguoiSua"));
                voucher.setGiatri(rs.getBigDecimal("GiaTri"));
                vouchers.add(voucher);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vouchers;
    }

    public int getTotalPageByStatus(String status, int pageSize) {
        int totalVouchers = 0;
        try {
            String countQuery = "SELECT COUNT(*) AS TotalCount FROM Voucher WHERE TrangThai = ?";
            PreparedStatement countStmt = cn.prepareStatement(countQuery);
            countStmt.setString(1, status);
            ResultSet countResult = countStmt.executeQuery();
            if (countResult.next()) {
                totalVouchers = countResult.getInt("TotalCount");
            }
            countResult.close();
            countStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (int) Math.ceil((double) totalVouchers / pageSize);
    }
}
