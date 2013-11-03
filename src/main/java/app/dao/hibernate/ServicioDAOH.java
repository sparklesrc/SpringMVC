/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.ServicioDAO;
import app.model.Servicio;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */

//Spring va automaticamente q esto es un bean de tipo repositorio y le va inyectar
//el session factory...

@Repository("servicioDAO")
public class ServicioDAOH extends BaseHibernateDAO implements ServicioDAO {
    
    
    
    public List<Servicio> list() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        //El criteria recibe una clase,,, se le envia
        //no es necesario q sea del tipo de Objeto de ServicioDAO
        
        Criteria criteria = this.getSession().createCriteria(Servicio.class);
        return criteria.list();

    }

    public Servicio get(Servicio t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        Criteria criteria = this.getSession().createCriteria(Servicio.class);
        criteria.add(Restrictions.eq("id", t.getId())); //La propiedad q se pone entre comillas es lo q hemos puesto en el MAPEO del model
        return (Servicio) criteria.uniqueResult();
    }

    public void save(Servicio t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.getSession().save(t);
    }

    public void update(Servicio t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.getSession().update(t);
    }

    public void delete(Servicio t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.getSession().delete(t);
    }

   
}
