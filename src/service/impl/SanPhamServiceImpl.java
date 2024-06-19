/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import Model.SanPham;
import java.util.List;
import repository.BaseRepository;
import repository.SanPhamRepository;
import repository.impl.SanPhamRepositoryImpl;
import service.BaseService;
import service.SanPhamService;
import view.SanPhamView;

/**
 *
 * @author QHC
 */
public class SanPhamServiceImpl implements BaseService<SanPham>, SanPhamService{
    
    private final BaseRepository<SanPham> sanPhamRepository = new SanPhamRepositoryImpl();    
    private final SanPhamRepository spRepository = new SanPhamRepositoryImpl();

    

    @Override
    public String add(SanPham object) {
        sanPhamRepository.add(object);
        return null;
    }

    @Override
    public String update(SanPham object, Integer id) {
        sanPhamRepository.update(object, id);
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SanPham getOne(Integer id) {
        return (SanPham) sanPhamRepository.getOne(id);
    }

    @Override
    public List<SanPhamView> findAllSanPham(String tenSanPham) {
        return spRepository.findAllCustom(tenSanPham);
    }
    
    public static void main(String[] args) {
        for(SanPhamView sp: new SanPhamServiceImpl().findAllSanPham(null)) {
            System.out.println(sp);
        }
                
    }

    @Override
    public List<SanPham> findAll(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SanPham findEntityByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
