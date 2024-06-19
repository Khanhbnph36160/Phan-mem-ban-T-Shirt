/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import view.SanPhamView;

/**
 *
 * @author QHC
 */
public interface SanPhamRepository {
    List<SanPhamView> findAllCustom(String tenSanPham);
}
