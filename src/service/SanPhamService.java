/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import view.SanPhamView;

/**
 *
 * @author QHC
 */
public interface SanPhamService {
    List<SanPhamView> findAllSanPham(String tenSanPham);
}
