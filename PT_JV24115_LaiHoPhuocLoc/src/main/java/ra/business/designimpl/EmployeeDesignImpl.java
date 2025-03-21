package ra.business.designimpl;

import ra.business.dao.IEmployeeDao;
import ra.business.daoimpl.EmployeeDaoImpl;
import ra.business.design.IEmployeeDesign;
import ra.business.entity.Employee;

import java.util.List;

public class EmployeeDesignImpl implements IEmployeeDesign {
    private static final IEmployeeDao employeeDao = new EmployeeDaoImpl();
    @Override
    public List<Employee> showEmployeeListByDepartment() {
        return employeeDao.showEmployeeListByDepartment();
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeDao.findByName(name);
    }

    @Override
    public List<Employee> findTop5HighestEmployee() {
        return employeeDao.findTop5HighestEmployee();
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public void save(Employee entity) {
        employeeDao.save(entity);
    }

    @Override
    public void delete(Integer id) {
        employeeDao.delete(id);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeDao.findById(id);
    }
}
