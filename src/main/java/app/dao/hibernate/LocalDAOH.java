/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.LocalDAO;
import app.model.Local;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */

//USO DEL TAG REPOSITORY
//es para inyectar con el service
//pero se puede ver tbm su uso en el TEST
@Repository("localDAO")
public class LocalDAOH extends BaseHibernateDAO implements LocalDAO{

    public List<Local> list() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Criteria criteria = this.getSession().createCriteria(Local.class);
        return criteria.list();
    }

    public Local get(Local t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Criteria criteria = this.getSession().createCriteria(Local.class);
        criteria.add(Restrictions.eq("id", t.getId())); //La propiedad q se pone entre comillas es lo q hemos puesto en el MAPEO del model
        return (Local) criteria.uniqueResult();
    }

    public void save(Local t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.getSession().save(t);
    }

    public void update(Local t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.getSession().update(t);
    }

    public void delete(Local t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.getSession().delete(t);
    }
    
    
    
}
