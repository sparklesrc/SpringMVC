/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.SocioDAO;
import app.model.Socio;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Administrador
 */
public class SocioDAOH extends BaseHibernateDAO implements SocioDAO{
    
    public List<Socio> list() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Criteria criteria = this.getSession().createCriteria(Socio.class);
        return criteria.list();
    }

    public Socio get(Socio t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Criteria criteria = this.getSession().createCriteria(Socio.class);
        criteria.add(Restrictions.eq("id", t.getId())); //La propiedad q se pone entre comillas es lo q hemos puesto en el MAPEO del model
        return (Socio) criteria.uniqueResult();
    }

    public void save(Socio t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.getSession().save(t);
    }

    public void update(Socio t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.getSession().update(t);
    }

    public void delete(Socio t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.getSession().delete(t);
        
    }
    
}
