package dao.impl;

import dao.LectorDao;
import exceptions.DataProcessingException;
import java.util.List;
import model.Lector;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import util.HibernateUtil;

@Repository
public class LectorDaoImpl extends EntityManagerImpl<Lector> implements LectorDao {

    @Override
    public List<String> globalSearch(String template) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT name FROM lectors WHERE name LIKE '%" + template + "%'";
            return (List<String>) session.createQuery(hql).list();
        } catch (Exception e) {
            throw new DataProcessingException("Error getting department by name", e);
        }
    }
}
