package dao.impl;

import dao.DepartmentDao;
import model.Department;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl extends EntityManagerImpl<Department> implements DepartmentDao {
}
