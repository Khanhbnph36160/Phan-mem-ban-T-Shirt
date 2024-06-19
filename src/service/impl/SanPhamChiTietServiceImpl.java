/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import Model.SanPhamChiTiet;
import java.util.List;
import repository.BaseRepository;
import repository.SanPhamChitietRepository;
import repository.impl.SanPhamChiTietRepositoryImpl;
import service.BaseService;
import service.SanPhamChiTietService;
import view.SanPhamChiTietView;

/**
 *
 * @author QHC
 */
public class SanPhamChiTietServiceImpl implements BaseService<SanPhamChiTiet>, SanPhamChiTietService{
    
    private final BaseRepository<SanPhamChiTiet> sanPhamChiTiet = new SanPhamChiTietRepositoryImpl();   
    private final SanPhamChitietRepository spChiTiet = new SanPhamChiTietRepositoryImpl();

    

    @Override
    public String add(SanPhamChiTiet object) {
        sanPhamChiTiet.add(object);
        return null;
    }

    @Override
    public String update(SanPhamChiTiet object, Integer id) {
        sanPhamChiTiet.update(object, id);
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SanPhamChiTiet getOne(Integer id) {
        return (SanPhamChiTiet) sanPhamChiTiet.getOne(id);
    }

    @Override
    public List<SanPhamChiTietView> findAllSanPhamChiTiet(Integer idSanPham, String trangThai) {
        return spChiTiet.findAllSanPhamChiTiet(idSanPham, trangThai);
    }

    @Override
    public List<SanPhamChiTiet> findAll(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer findSPCTByMauSacAndChatLieuAndSizeAndThuongHieuAndSanPham(int idSanPham, int idMauSac, int idSize, int idChatLieu, int idThuongHieu) {
        return spChiTiet.findSPCTByMauSacAndChatLieuAndSizeAndThuongHieuAndSanPham(idSanPham, idMauSac, idSize, idChatLieu, idThuongHieu);
    }

    @Override
    public SanPhamChiTiet findEntityByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateTrangThaiSanPham(Integer id, String trangThai) {
        spChiTiet.updateTrangThaiSPCT(id, trangThai);
    }
    
}
