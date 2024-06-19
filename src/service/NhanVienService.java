/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;
import model.NhanVien;

/**
 *
 * @author admin
 */
public interface NhanVienService {
    List<NhanVien> getAll();

    void them(NhanVien nv) throws Exception;

    void sua(NhanVien nv, int id) throws Exception;

    void xoa(int id) throws Exception;

    List<NhanVien> tim(String tenTK);

    List<NhanVien> loc(String gt, String dCLoc,String ttLoc);
    
}
