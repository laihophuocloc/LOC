package ra.business.daoimpl;

import ra.business.config.ConnectDB;
import ra.business.dao.IEmployeeDao;
import ra.business.entity.Employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements IEmployeeDao {
    @Override
    public List<Employee> showEmployeeListByDepartment() {
        return null;
    }

    @Override
    public List<Employee> findByName(String name) {
        List<Employee> list = new ArrayList<>();
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("{call ProcFindByNameEmployee(?)}");
            call.setString(1, name);
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Employee employees = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("employee_name"),
                        rs.getString("position"),
                        rs.getDouble("salary"),
                        rs.getDate("hire_date"),
                        rs.getInt("department_id")
                );
                list.add(employees);
            }
            return list;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public List<Employee> findTop5HighestEmployee() {
        List<Employee> list = new ArrayList<>();
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("{call Top5HighestEmployee()}");
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Employee employees = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("employee_name"),
                        rs.getString("position"),
                        rs.getDouble("salary"),
                        rs.getDate("hire_date"),
                        rs.getInt("department_id")
                );
                list.add(employees);
            }
            return list;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> list = new ArrayList<>();
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("{call ProcShowEmployeeList()}");
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Employee employees = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("employee_name"),
                        rs.getString("position"),
                        rs.getDouble("salary"),
                        rs.getDate("hire_date"),
                        rs.getInt("department_id")
                );
                list.add(employees);
            }
            return list;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Employee entity) {
        Connection conn = ConnectDB.openConnection();
        try{
            CallableStatement call;
            if(findById(entity.getEmployeeId())!=null){
                // Update
                call = conn.prepareCall("{call ProcUpdateEmployee(?,?,?,?,?)}");
                call.setInt(1, entity.getEmployeeId());
                call.setString(2, entity.getEmployeeName());
                call.setString(3, entity.getPosition());
                call.setDouble(4, entity.getSalary());
                call.setInt(5, entity.getDepartmentId());
            }else {
                // thêm mới
                call = conn.prepareCall("{call ProcInsertEmployee(?,?,?,?,?)}");
                call.setString(1, entity.getEmployeeName());
                call.setString(2, entity.getPosition());
                call.setDouble(3, entity.getSalary());
                call.setDate(4, new java.sql.Date(entity.getHireDate().getTime()));
                call.setInt(5, entity.getDepartmentId());
            }
            call.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public void delete(Integer id) {
        Connection conn = ConnectDB.openConnection();
        try{
            CallableStatement call = conn.prepareCall("{call ProcDeleteEmployee(?)}");
            call.setInt(1, id);
            call.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public Employee findById(Integer id) {
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("{call ProcFindByIdEmployee(?)}");
            call.setInt(1, id);
            ResultSet rs = call.executeQuery();
            if (rs.next()) {
                Employee employees = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("employee_name"),
                        rs.getString("position"),
                        rs.getDouble("salary"),
                        rs.getDate("hire_date"),
                        rs.getInt("department_id")
                );
                return employees;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
