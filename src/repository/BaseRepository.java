/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;

/**
 *
 * @author QHC
 */
public interface BaseRepository<T> {
    
    /**
     *
     */
    T add(T object);
    
    T update(T object, Integer id);
    
    boolean delete(Integer id);
    
    T getOne(Integer id);
    
    T findEntityByName(String name);
    
    List<T> findAll(String tenChatLieu);
    
}
