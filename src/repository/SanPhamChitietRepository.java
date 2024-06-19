/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
import view.SanPhamChiTietView;

/**
 *
 * @author QHC
 */
public interface SanPhamChitietRepository {
    List<SanPhamChiTietView> findAllSanPhamChiTiet(Integer idSanPham, String trangThai);
    Integer findSPCTByMauSacAndChatLieuAndSizeAndThuongHieuAndSanPham(int idSanPham, int idMauSac,
            int idSize, int idChatLieu, int idThuongHieu);
    void updateTrangThaiSPCT(Integer id, String trangThai);
}
