/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.model.Campo;
import app.model.Local;
import app.zelper.GenericDAO;
import java.util.List;

/**
 *
 * @author Administrador
 */
public interface CampoDAO extends GenericDAO<Campo>{
    
    
    
    //Aca vamos agregando metodos especiales para cada tipo
    //muy independientes al de los genericos
    public List<Campo> allByLocal(Local local);
    
    public Campo getByName(String descripcion);
    
}
