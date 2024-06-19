/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import Model.ChatLieu;
import com.microsoft.sqlserver.jdbc.StringUtils;
import java.util.List;
import repository.impl.ChatLieuRepositoyImpl;
import repository.BaseRepository;
import service.BaseService;

/**
 *
 * @author QHC
 */
public class ChatLieuServiceImpl implements BaseService<ChatLieu> {

    private BaseRepository chatLieuRepositoy = new ChatLieuRepositoyImpl();

    @Override
    public String add(ChatLieu object) {
        chatLieuRepositoy.add(object);
        return null;
    }

    @Override
    public String update(ChatLieu object, Integer id) {
        chatLieuRepositoy.update(object, id);
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ChatLieu getOne(Integer id) {
        return (ChatLieu) chatLieuRepositoy.getOne(id);
    }

    @Override
    public List<ChatLieu> findAll(String name) {
        return chatLieuRepositoy.findAll(name);
    }

    @Override
    public ChatLieu findEntityByName(String name) {
        return (ChatLieu) chatLieuRepositoy.findEntityByName(name);
    }

}
