/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import Model.ThuongHieu;
import java.util.List;
import repository.BaseRepository;
import repository.impl.ThuongHieuRepositoryImpl;
import service.BaseService;

/**
 *
 * @author QHC
 */
public class ThuongHieuServiceImpl implements BaseService<ThuongHieu> {

    private final BaseRepository<ThuongHieu> thuongHieuRepository = new ThuongHieuRepositoryImpl();

    @Override
    public String add(ThuongHieu object) {
        thuongHieuRepository.add(object);
        return null;
    }

    @Override
    public String update(ThuongHieu object, Integer id) {
        thuongHieuRepository.update(object, id);
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ThuongHieu getOne(Integer id) {
        return (ThuongHieu) thuongHieuRepository.getOne(id);
    }

    @Override
    public List<ThuongHieu> findAll(String name) {
        return thuongHieuRepository.findAll(name);
    }

    @Override
    public ThuongHieu findEntityByName(String name) {
        return thuongHieuRepository.findEntityByName(name);
    }

}
