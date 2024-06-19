/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;

/**
 *
 * @author QHC
 */
public class ChatLieu extends BaseEntity {

    private Integer id;
    private String tenChatLieu;

    public ChatLieu() {
    }

    public ChatLieu(Integer id, String tenChatLieu) {
        this.id = id;
        this.tenChatLieu = tenChatLieu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    @Override
    public String toString() {
        return "ChatLieu{" + "id=" + id + ", tenChatLieu=" + tenChatLieu + '}';
    }

}
