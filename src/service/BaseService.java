/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;

/**
 *
 * @author QHC
 */
public interface BaseService<T> {

    String add(T object);

    String update(T object, Integer id);

    boolean delete(Integer id);

    T getOne(Integer id);
    
    T findEntityByName(String name);
    
    List<T> findAll(String name);

}
