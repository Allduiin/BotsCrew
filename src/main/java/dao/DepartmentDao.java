package dao;

import model.Department;

public interface DepartmentDao extends EntityManager<Department> {
    Department getByName(String nameOfDepartment);
}
