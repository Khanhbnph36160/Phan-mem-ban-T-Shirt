/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import Model.ChatLieu;
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
public class ChatLieuRepositoyImpl implements BaseRepository<ChatLieu> {

    private Connection conn;
    private String sql;

    public ChatLieuRepositoyImpl() {

        try {
            conn = DBConnection.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ChatLieu add(ChatLieu object) {
        sql = "INSERT INTO ChatLieu(TenChatLieu, NguoiTao, NgayTao, NguoiSua, NgaySua) VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getTenChatLieu());
            ps.setString(2, object.getNguoiTao());
            ps.setDate(3, object.getNgayTao());
            ps.setString(4, object.getNguoiSua());
            ps.setDate(5, object.getNgaySua());

            ps.execute();
            return object;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ChatLieu update(ChatLieu object, Integer id) {
        sql = "UPDATE ChatLieu SET TenChatLieu =?, NguoiTao =?, NgayTao =?, NguoiSua =?, NgaySua =? WHERE id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, object.getTenChatLieu());
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
    public ChatLieu getOne(Integer id) {
        sql = "SELECT * FROM ChatLieu WHERE id =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ChatLieu cl = null;
            while (rs.next()) {
                cl = new ChatLieu();
                cl.setId(rs.getInt(1));
                cl.setTenChatLieu(rs.getString(2));
                cl.setNgayTao(rs.getDate(3));
                cl.setNguoiTao(rs.getString(4));
                cl.setNgaySua(rs.getDate(5));
                cl.setNguoiSua(rs.getString(6));

            }

            return cl;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ChatLieu> findAll(String tenChatLieu) {
        sql = "SELECT * FROM ChatLieu WHERE (? is null or TenChatLieu like ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            if (tenChatLieu == null) {
                ps.setString(1, null);
                ps.setString(2, null);
            } else {
                ps.setString(1, tenChatLieu);
                ps.setString(2, "%" + tenChatLieu + "%");
            }
            ResultSet rs = ps.executeQuery();
            List<ChatLieu> chatLieuList = new ArrayList<>();
            while (rs.next()) {
                ChatLieu cl = new ChatLieu();
                cl.setId(rs.getInt(1));
                cl.setTenChatLieu(rs.getString(2));
                cl.setNgayTao(rs.getDate(3));
                cl.setNguoiTao(rs.getString(4));
                cl.setNgaySua(rs.getDate(5));
                cl.setNguoiSua(rs.getString(6));

                chatLieuList.add(cl);

            }

            return chatLieuList;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ChatLieu findEntityByName(String name) {
        sql = "SELECT * FROM ChatLieu WHERE TenChatLieu =?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            ChatLieu cl = null;
            while (rs.next()) {
                cl = new ChatLieu();
                cl.setId(rs.getInt(1));
                cl.setTenChatLieu(rs.getString(2));
                cl.setNgayTao(rs.getDate(3));
                cl.setNguoiTao(rs.getString(4));
                cl.setNgaySua(rs.getDate(5));
                cl.setNguoiSua(rs.getString(6));
            }
            return cl;
        } catch (Exception e) {
            System.out.print(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

}
