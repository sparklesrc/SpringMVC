package app.dao.hibernate;

import app.dao.BaseHibernateDAO;
import app.dao.ServicioDAO;
import app.model.Servicio;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//Spring va automaticamente q esto es un bean de tipo repositorio y le va inyectar
//el session factory...
@Repository("servicioDAO")
public class ServicioDAOH extends BaseHibernateDAO implements ServicioDAO {

    public List<Servicio> list() {

        //El criteria recibe una clase,,, se le envia
        //no es necesario q sea del tipo de Objeto de ServicioDAO

        Criteria criteria = this.getSession().createCriteria(Servicio.class);
        return criteria.list();
    }

    public Servicio get(Servicio t) {
        Criteria criteria = this.getSession().createCriteria(Servicio.class);
        criteria.add(Restrictions.eq("id", t.getId()));
        return (Servicio) criteria.uniqueResult();
    }

    @Transactional
    public void save(Servicio t) {
        this.getSession().save(t);
    }

    @Transactional
    public void update(Servicio t) {
        this.getSession().update(t);
    }

    @Transactional
    public void delete(Servicio t) {
        this.getSession().delete(t);
    }
}
