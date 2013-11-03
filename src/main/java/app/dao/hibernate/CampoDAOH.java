/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.CampoDAO;
import app.model.Campo;
import app.model.Local;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrador
 */
@Repository("campoDAO")
public class CampoDAOH extends BaseHibernateDAO implements CampoDAO {

    public List<Campo> list() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Criteria criteria = this.getSession().createCriteria(Campo.class);
        return criteria.list();

    }

    public Campo get(Campo t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Criteria criteria = this.getSession().createCriteria(Campo.class);
        criteria.add(Restrictions.eq("id", t.getId())); //La propiedad q se pone entre comillas es lo q hemos puesto en el MAPEO del model
        return (Campo) criteria.uniqueResult();
    }

    public void save(Campo t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.getSession().save(t);
    }

    public void update(Campo t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.getSession().update(t);
    }

    public void delete(Campo t) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.getSession().delete(t);
    }

    public List<Campo> allByLocal(Local local) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Criteria criteria = this.getSession().createCriteria(Campo.class);
        criteria.add(Restrictions.eq("local", local));
        return criteria.list();
    }

    public Campo getByName(String descripcion) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Criteria criteria = this.getSession().createCriteria(Campo.class);
        //Utiliza el LIKE
        //MATCHMODE es similar al %descripcion%
        //POR ESO COLOCA EN Q PARTE EL ANYWHERE
        criteria.add(Restrictions.like("descripcion", descripcion, MatchMode.ANYWHERE)); 
        //La propiedad q se pone entre comillas es lo q hemos puesto en el MAPEO del model
        return (Campo) criteria.uniqueResult();
    }
}
