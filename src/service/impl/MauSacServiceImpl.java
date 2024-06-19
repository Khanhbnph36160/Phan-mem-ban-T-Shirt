/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import Model.MauSac;
import java.util.List;
import repository.BaseRepository;
import repository.impl.MauSacRepositoryImpl;
import service.BaseService;

/**
 *
 * @author QHC
 */
public class MauSacServiceImpl implements BaseService<MauSac> {

    private final BaseRepository<MauSac> mauSacRepository = new MauSacRepositoryImpl();

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MauSac getOne(Integer id) {
        return (MauSac) mauSacRepository.getOne(id);
    }

    @Override
    public String add(MauSac object) {
        mauSacRepository.add(object);
        return null;

    }

    @Override
    public String update(MauSac object, Integer id) {
        mauSacRepository.update(object, id);
        return null;
    }

    @Override
    public List<MauSac> findAll(String name) {
        return mauSacRepository.findAll(name);
    }

    @Override
    public MauSac findEntityByName(String name) {
        return mauSacRepository.findEntityByName(name);
    }

}
