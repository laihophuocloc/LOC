package ra.business.daoimpl;

import ra.business.config.ConnectDB;
import ra.business.dao.IDepartmentsDao;
import ra.business.dto.DepartmentHighestQuantityEmployee;
import ra.business.entity.Departments;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentsDaoImpl implements IDepartmentsDao {
    @Override
    public DepartmentHighestQuantityEmployee ShowDepartmentHighestQuantityEmployee() {
        return null;
    }

    @Override
    public Departments findById(Integer id) {
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("{call ProcFindById(?)}");
            call.setInt(1, id);
            ResultSet rs = call.executeQuery();
            if (rs.next()) {
                Departments departments = new Departments(
                        rs.getInt("department_id"),
                        rs.getString("department_name"),
                        rs.getBoolean("department_status")
                );
                return departments;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Departments> findAll() {
        List<Departments> list = new ArrayList<>();
        Connection conn = ConnectDB.openConnection();
        try {
            CallableStatement call = conn.prepareCall("{call ProcShowDepartmentList()}");
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                Departments departments = new Departments(
                        rs.getInt("department_id"),
                        rs.getString("department_name"),
                        rs.getBoolean("department_status")
                );
                list.add(departments);
            }
            return list;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Departments entity) {
        Connection conn = ConnectDB.openConnection();
        try{
            CallableStatement call;
            if(findById(entity.getDepartmentId())!=null){
                // Update
                call = conn.prepareCall("{call ProcUpdateDepartment(?,?,?)}");
                call.setString(1, entity.getDepartmentName());
                call.setBoolean(2, entity.isDepartmentStatus());
                call.setInt(3, entity.getDepartmentId());
            }else {
                // thêm mới
                call = conn.prepareCall("{call ProcInsertDepartment(?)}");
                call.setString(1, entity.getDepartmentName());
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
            CallableStatement call = conn.prepareCall("{call ProcDeleteDepartment(?)}");
            call.setInt(1, id);
            call.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            ConnectDB.closeConnection(conn);
        }
    }

}
