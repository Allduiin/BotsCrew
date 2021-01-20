package dao.impl;

import dao.DepartmentDao;
import exceptions.DataProcessingException;
import model.Department;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import util.HibernateUtil;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
    @Override
    public Department add(Department department) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
            return department;
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
