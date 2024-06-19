/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import repository.DBConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
import service.NhanVienService;

/**
 *
 * @author admin
 */
public class NhanVienServiceImpl implements NhanVienService {

    private Connection conn;

    public NhanVienServiceImpl() {
        try {
            conn = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<NhanVien> getAll() {
        List<NhanVien> list = new ArrayList<>();
        try {
            String q = "select ID,DiaChi, Email, Sdt, HoTen, GioiTinh, NgaySinh, CCCD, NgayTao, TrangThai from NhanVien where TrangThai !=0 ";
            PreparedStatement ps = conn.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String email = rs.getString("Email");
                String sdt = rs.getString("Sdt");
                String hoTen = rs.getString("HoTen");
                String diaChi = rs.getString("DiaChi");
                int gioiTinh = rs.getInt("GioiTinh"); // Lấy giới tính dưới dạng int
                Date ngaySinh = rs.getDate("NgaySinh");
                String CCCD = rs.getString("CCCD");
                Date ngayTao = rs.getDate("NgayTao");
                int trangThai = rs.getInt("TrangThai");
                NhanVien nv = new NhanVien(id, email, sdt, hoTen, diaChi, gioiTinh, ngaySinh, CCCD, ngayTao, trangThai); // Sửa khởi tạo của NhanVien để chấp nhận giới tính dưới dạng int
                list.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void them(NhanVien nv) throws Exception {
        if (nv == null) {
            throw new IllegalArgumentException("NhanVien cannot be null");
        }

        String sql = "INSERT INTO NhanVien(Email, Sdt, HoTen, GioiTinh, DiaChi,NgaySinh, CCCD, NgayTao, TrangThai) VALUES (?,?,?,?,?,?,?,?,?);";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nv.getEmail());
            ps.setString(2, nv.getSdt());
            ps.setString(3, nv.getHoTen());
            ps.setString(5, nv.getDiaChi());
            // Chuyển đổi giới tính từ int sang String nếu cần
            ps.setInt(4, nv.getGioiTinh());
            ps.setDate(6, nv.getNgaySinh());
            ps.setString(7, nv.getCCCD());
            ps.setDate(8, nv.getNgayTao());
            ps.setInt(9, nv.getTrangThai());

            ps.executeUpdate(); // Thực thi lệnh SQL
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Ném lại ngoại lệ để lớp gọi hàm biết được lỗi
        }
    }

    @Override
    public void sua(NhanVien nv, int id) throws Exception {
        String sql = "UPDATE NhanVien SET Email=?, Sdt=?, HoTen=?, DiaChi = ? ,GioiTinh=?, NgaySinh=?, CCCD=?, NgayTao=?, TrangThai=? WHERE ID=?;";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nv.getEmail());
            ps.setString(2, nv.getSdt());
            ps.setString(3, nv.getHoTen());
            ps.setString(4, nv.getDiaChi());
            ps.setInt(5, nv.getGioiTinh());
            ps.setDate(6, nv.getNgaySinh());
            ps.setString(7, nv.getCCCD());
            ps.setDate(8, nv.getNgayTao());
            ps.setInt(9, nv.getTrangThai());
            ps.setInt(10, id);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw e; // Ném lại ngoại lệ để thông báo cho lớp gọi về lỗi
        }
    }

    @Override
    public void xoa(int id) throws Exception {
        String q = "UPDATE NhanVien SET TrangThai = ? WHERE ID = ?";
        try (PreparedStatement ps = conn.prepareStatement(q)) {
            ps.setInt(1, 0);  // Giả sử 0 là giá trị cho trạng thái "Nghỉ làm"
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // Ném lại ngoại lệ để lớp gọi hàm biết được lỗi
        }
    }

    @Override
    public List<NhanVien> tim(String tenTK) {
        List<NhanVien> listNV = new ArrayList<>();
        try {
            String q = "select ID, Email, Sdt, DiaChi ,HoTen, GioiTinh, NgaySinh, CCCD, NgayTao, TrangThai from NhanVien where HoTen like ?";
            PreparedStatement ps = conn.prepareStatement(q);
            ps.setString(1, "%" + tenTK + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String email = rs.getString("Email");
                String sdt = rs.getString("Sdt");
                String hoTen = rs.getString("HoTen");
                String diaChi = rs.getString("DiaChi");
                // Chuyển đổi giới tính từ int sang String
                int gioiTinh = rs.getInt("GioiTinh"); // Giữ GioiTinh dưới dạng int
                Date ngaySinh = rs.getDate("NgaySinh");
                String CCCD = rs.getString("CCCD");
                Date ngayTao = rs.getDate("NgayTao");
                int trangThai = rs.getInt("TrangThai");
                NhanVien nv = new NhanVien(id, email, sdt, hoTen, diaChi, gioiTinh, ngaySinh, CCCD, ngayTao, trangThai);
                listNV.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }

    @Override
    public List<NhanVien> loc(String gt, String dCLoc, String ttLoc) {
        List<NhanVien> listNV = new ArrayList<>();
        try {
            listNV.clear();
            String q = "SELECT ID, Email, Sdt, HoTen, DiaChi ,GioiTinh, NgaySinh, CCCD, NgayTao, TrangThai FROM NhanVien WHERE GioiTinh LIKE ? AND TrangThai LIKE ?";
            if (dCLoc != null) {
                q += " AND DiaChi LIKE ?";
            }
            PreparedStatement ps = conn.prepareStatement(q);
            String gtLoc = null;
            ps.setString(1, "%" + gtLoc + "%");
            ps.setString(2, "%" + ttLoc + "%");

// Nếu dCLoc khác null thì set giá trị cho tham số thứ 3
            if (dCLoc != null) {
                ps.setString(3, "%" + dCLoc + "%");
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String email = rs.getString("Email");
                String sdt = rs.getString("Sdt");
                String hoTen = rs.getString("HoTen");
                String diaChi = rs.getString("DiaChi");
                int gioiTinh = rs.getInt("GioiTinh"); // Lấy giới tính dưới dạng int
                Date ngaySinh = rs.getDate("NgaySinh");
                String CCCD = rs.getString("CCCD");
                Date ngayTao = rs.getDate("NgayTao");
                int trangThai = rs.getInt("TrangThai");
                NhanVien nv = new NhanVien(id, email, sdt, hoTen, diaChi, gioiTinh, ngaySinh, CCCD, ngayTao, trangThai); // Sửa khởi tạo của NhanVien để chấp nhận giới tính dưới dạng int
                listNV.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }

}
