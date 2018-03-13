/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.interfaces;

import java.util.List;

/**
 *
 * @author Ons Ben Othmen
 */
public interface BasicInterface<T, R> {
        
    void add(T t);
   
    void update(T t);

    void delete(T id);

    List<T> getAll();

    T findById(R id);
}
