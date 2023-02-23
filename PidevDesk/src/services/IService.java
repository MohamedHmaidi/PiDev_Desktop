/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ashre
 * @param <T>
 */
public interface IService<T> {
    public void ajouter(T t) throws SQLException;
    public void modifier(T t) throws SQLException;
    public void supprimer(T t) throws SQLException;
    public List<T> Consulter(T t) throws SQLException;
    public T afficherParId(int panier_id) throws SQLException;
    
}
