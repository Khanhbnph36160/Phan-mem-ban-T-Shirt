/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import Model.Size;
import java.util.List;
import repository.BaseRepository;
import repository.impl.SizeRepositoryImpl;
import service.BaseService;

/**
 *
 * @author QHC
 */
public class SizeServiceImpl implements BaseService<Size>{
    
    private final BaseRepository<Size> sizeRepository = new SizeRepositoryImpl();

    @Override
    public String add(Size object) {
        sizeRepository.add(object);
        return null;
    }

    @Override
    public String update(Size object, Integer id) {
        sizeRepository.update(object, id);
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Size getOne(Integer id) {
        return (Size) sizeRepository.getOne(id);
    }

    @Override
    public List<Size> findAll(String name) {
        return sizeRepository.findAll(name);
    }

    @Override
    public Size findEntityByName(String name) {
        return sizeRepository.findEntityByName(name);
    }
    
}
