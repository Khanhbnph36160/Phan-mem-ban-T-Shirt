/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.*;
import repository.DBConnection;

/**
 *
 * @author thaitv
 */
public class LoginService {
    
    private static Connection conn = DBConnection.getConnection();
    
    public String idNhanVienByEmail(String email){
        String idNhanVien = null;
        String sql = "SELECT Id FROM NhanVien WHERE Email = ?";
        try {   
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                idNhanVien = rs.getString("Id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idNhanVien;
    }
    
}
