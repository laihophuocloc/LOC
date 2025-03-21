package ra.business.dao;

import ra.business.entity.Employee;

import java.util.List;

public interface IEmployeeDao extends IGenericDao<Employee, Integer> {
    List<Employee> showEmployeeListByDepartment();
    List<Employee> findByName(String name);
    List<Employee> findTop5HighestEmployee();
}
