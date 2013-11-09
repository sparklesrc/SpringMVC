
package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.LocalDAO;
import app.model.Local;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


//USO DEL TAG REPOSITORY
//es para inyectar con el service
//pero se puede ver tbm su uso en el TEST

@Repository("localDAO")
public class LocalDAOH extends BaseHibernateDAO implements LocalDAO {

     public List<Local> list() {
        Criteria criteria = this.getSession().createCriteria(Local.class);
        return criteria.list();
    }

    public Local get(Local t) {
        Criteria criteria = this.getSession().createCriteria(Local.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Local) criteria.uniqueResult();
    }
    
    @Transactional
    public void save(Local t) {
        this.getSession().save(t);
    }

    @Transactional
    public void update(Local t) {
        this.getSession().update(t);
    }

    @Transactional
    public void delete(Local t) {
        this.getSession().delete(t);
    }
    
    
    
}
