package dao.impl;

import dao.LectorDao;
import exceptions.DataProcessingException;
import model.Lector;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class LectorDaoImpl implements LectorDao {
    @Override
    public Lector add(Lector lector) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(lector);
            transaction.commit();
            return lector;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Error adding department", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
