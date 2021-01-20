package dao.impl;

import dao.EntityManager;
import exceptions.DataProcessingException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class EntityManagerImpl<T> implements EntityManager<T> {
    @Override
    public T add(T t) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(t);
            transaction.commit();
            return t;
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
