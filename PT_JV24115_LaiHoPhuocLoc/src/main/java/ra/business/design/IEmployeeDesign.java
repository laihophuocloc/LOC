package ra.business.design;

import ra.business.entity.Employee;

import java.util.List;

public interface IEmployeeDesign extends IGenericDesign<Employee, Integer> {
    List<Employee> showEmployeeListByDepartment();
    List<Employee> findByName(String name);
    List<Employee> findTop5HighestEmployee();
}
