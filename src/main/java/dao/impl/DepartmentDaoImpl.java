package dao.impl;

import dao.DepartmentDao;
import exceptions.DataProcessingException;
import model.Department;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import util.HibernateUtil;

@Repository
public class DepartmentDaoImpl extends EntityManagerImpl<Department> implements DepartmentDao {
    @Override
    public Department getByName(String nameOfDepartment) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return (Department) session
                    .createQuery("FROM departments WHERE name =: nameOfDepartment")
                    .setParameter("nameOfDepartment", nameOfDepartment)
                    .uniqueResult();
        } catch (Exception e) {
            throw new DataProcessingException("Error getting department by name", e);
        }
    }
}
