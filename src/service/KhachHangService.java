/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.KhachHang;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import repository.DBConnection;

/**
 *
 * @author QHC
 */
public class KhachHangService {
     private Connection conn;
    private String sql;
    
    public KhachHangService() {
        try {
            conn = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public ArrayList<KhachHang> getAllKhachhang() {
    ArrayList<KhachHang> kh = new ArrayList<>();
 
   sql = "select * from KhachHang";
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {                
               KhachHang khachHang = new KhachHang();
                khachHang.setId(rs.getInt(1));
                khachHang.setHoTen(rs.getString(2));
                khachHang.setGioiTinh(rs.getInt(3));
                khachHang.setSdt(rs.getString(4));
                khachHang.setDiaChi(rs.getString(5));
                khachHang.setNgayTao(rs.getDate(6));
                khachHang.setNguoiTao(rs.getString(7));
                khachHang.setNgaySua(rs.getDate(8));
                khachHang.setNguoiSua(rs.getString(9));
                kh.add(khachHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kh;
    }
     
     public KhachHang add(KhachHang object) {
        sql = "INSERT INTO KhachHang(HoTen, GioiTinh, SDT, DiaChi, NgayTao) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getHoTen());
            ps.setInt(2, object.getGioiTinh());
            ps.setString(3, object.getSdt());
            ps.setString(4, object.getDiaChi());
            ps.setDate(5, Date.valueOf(LocalDate.now()));

            ps.execute();
            return object;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
     
     public KhachHang update(KhachHang object, Integer id) {
        sql = "UPDATE KhachHang SET HoTen =?, GioiTinh =?, Sdt =?, DiaChi =?, NgayTao =? WHERE id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getHoTen());
            ps.setInt(2, object.getGioiTinh());
            ps.setString(3, object.getSdt());
            ps.setString(4, object.getDiaChi());
            ps.setDate(5, Date.valueOf(LocalDate.now()));
            ps.setInt(6, id);

            ps.execute();
            return object;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
      public List<KhachHang> findAll(String hoTen) {
        sql = "SELECT * FROM KhachHang WHERE (? is null or HoTen like ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if (hoTen == null) {
                ps.setString(1, null);
                ps.setString(2, null);
            } else {
                ps.setString(1, hoTen );
                ps.setString(2, "%" + hoTen  + "%");
            }
            ResultSet rs = ps.executeQuery();
            List<KhachHang> khachHangList = new ArrayList<>();
            while (rs.next()) {
                KhachHang cl = new KhachHang();
                cl.setId(rs.getInt(1));
                cl.setHoTen(rs.getString(2));
                cl.setGioiTinh(rs.getInt(3));
                cl.setSdt(rs.getString(4));
                cl.setDiaChi(rs.getString(5));
                cl.setNgayTao(rs.getDate(6));

               khachHangList.add(cl);

            }

            return khachHangList;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
     
     public static void main(String[] args) {
        for (KhachHang kh: new KhachHangService().getAllKhachhang()) {
            System.out.println(kh);
        }
    }
      
}
