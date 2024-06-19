/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import Model.MauSac;
import Model.SanPhamChiTiet;
import repository.DBConnection;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import repository.BaseRepository;
import repository.SanPhamChitietRepository;
import view.SanPhamChiTietView;

/**
 *
 * @author QHC
 */
public class SanPhamChiTietRepositoryImpl implements BaseRepository<SanPhamChiTiet>, SanPhamChitietRepository {

    private Connection conn;
    private String sql;

    public SanPhamChiTietRepositoryImpl() {

        try {
            conn = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public SanPhamChiTiet add(SanPhamChiTiet object) {
        sql = "INSERT INTO spct(IdSanPham, IdMauSac, IdSize, IdChatLieu, IdThuongHieu, Gia, NgayTao, TrangThai) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, object.getIdSanPham());
            ps.setInt(2, object.getIdMauSac());
            ps.setInt(3, object.getIdSize());
            ps.setInt(4, object.getIdChatLieu());
            ps.setInt(5, object.getIdThuongHieu());
            ps.setBigDecimal(6, object.getGia());
            ps.setDate(7, object.getNgayTao());
            ps.setString(8, object.getTrangThai());

            ps.execute();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SanPhamChiTiet update(SanPhamChiTiet object, Integer id) {
        sql = "UPDATE spct SET IdSanPham =?, IdMauSac =?, IdSize =?, IdChatLieu =?, IdThuongHieu =?, Gia =? WHERE id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, object.getIdSanPham());
            ps.setInt(2, object.getIdMauSac());
            ps.setInt(3, object.getIdSize());
            ps.setInt(4, object.getIdChatLieu());
            ps.setInt(5, object.getIdThuongHieu());
            ps.setBigDecimal(6, object.getGia());
            ps.setInt(7, id);

            int i = ps.executeUpdate();
            System.out.println(i);
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SanPhamChiTiet getOne(Integer id) {
        sql = "SELECT * FROM SPCT WHERE id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            SanPhamChiTiet spct = null;
            while (rs.next()) {
                spct = new SanPhamChiTiet();
                spct.setId(rs.getInt(1));
                spct.setIdMauSac(rs.getInt(2));
                spct.setIdSanPham(rs.getInt(3));
                spct.setIdHinhAnh(rs.getInt(4));
                spct.setIdThuongHieu(rs.getInt(5));
                spct.setIdChatLieu(rs.getInt(6));
                spct.setIdSize(rs.getInt(7));
                spct.setGia(rs.getBigDecimal(8));
                spct.setTrangThai(rs.getString(9));
            }
            return spct;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SanPhamChiTietView> findAllSanPhamChiTiet(Integer idSanPham, String trangThai) {
        sql = "Select spct.id, spct.NgayTao, ms.tenMau, s.TenSize, cl.TenChatLieu, "
                + "th.TenThuongHieu, sp.soLuong, spct.gia, sp.id, sp.tensanpham from SPCT spct "
                + "join MauSac ms on spct.IdMauSac = ms.id "
                + "join Size s on spct.idSize = s.id "
                + "join ThuongHieu th on spct.idTHuongHieu = th.id "
                + "join ChatLieu cl on spct.idChatLieu = cl.id "
                + "join SanPham sp on spct.idSanPham = sp.id "
                + "where (? is null or sp.id = ?) "
                + "and (? is null or spct.TrangThai = ?) ";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if (idSanPham == null) {
                ps.setString(1, null);
                ps.setString(2, null);
            } else {
                ps.setInt(1, idSanPham);
                ps.setInt(2, idSanPham);
            }

            if (trangThai == null) {
                ps.setString(3, null);
                ps.setString(4, null);
            } else {
                ps.setString(3, trangThai);
                ps.setString(4, trangThai);
            }
            ResultSet rs = ps.executeQuery();
            List<SanPhamChiTietView> sanPhamChiTietList = new ArrayList<>();
            while (rs.next()) {
                SanPhamChiTietView spct = new SanPhamChiTietView();
                spct.setId(rs.getInt(1));
                spct.setNgayNhap(rs.getDate(2));
                spct.setMauSac(rs.getString(3));
                spct.setSize(rs.getString(4));
                spct.setChatLieu(rs.getString(5));
                spct.setHang(rs.getString(6));
                spct.setSoLuong(rs.getInt(7));
                spct.setGia(rs.getBigDecimal(8));
                spct.setIdSanPham(rs.getInt(9));
                spct.setTenSanPham(rs.getString(10));

                sanPhamChiTietList.add(spct);
            }
            return sanPhamChiTietList;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<SanPhamChiTiet> findAll(String ten) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer findSPCTByMauSacAndChatLieuAndSizeAndThuongHieuAndSanPham(int idSanPham, int idMauSac, int idSize, int idChatLieu, int idThuongHieu) {
        try {
            sql = "SELECT * FROM SPCT spct "
                    + "LEFT JOIN SanPham sp on spct.IdSanPham = sp.Id "
                    + "LEFT JOIN MauSac ms on spct.IdMauSac = ms.Id "
                    + "LEFT JOIN ChatLieu cl on spct.IdChatLieu = cl.Id "
                    + "LEFT JOIN ThuongHieu th on spct.IdThuongHieu = th.Id "
                    + "LEFT JOIN Size s on spct.IdSize = s.Id "
                    + "WHERE sp.Id = ? AND ms.Id = ? AND s.Id = ? AND cl.Id = ? AND th.Id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idSanPham);
            ps.setInt(2, idMauSac);
            ps.setInt(3, idSize);
            ps.setInt(4, idChatLieu);
            ps.setInt(5, idThuongHieu);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public SanPhamChiTiet findEntityByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateTrangThaiSPCT(Integer id, String trangThai) {
        try {
            sql = "UPDATE SPCT set TrangThai = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, trangThai);
            ps.setInt(2, id);
            int record = ps.executeUpdate();
            System.out.println("record: " + record);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
