package ra.business.designimpl;

import ra.business.dao.IDepartmentsDao;
import ra.business.daoimpl.DepartmentsDaoImpl;
import ra.business.design.IDepartmentsDesign;
import ra.business.dto.DepartmentHighestQuantityEmployee;
import ra.business.entity.Departments;

import java.util.List;

public class DepartmentsDesignImpl implements IDepartmentsDesign {
    public static final IDepartmentsDao departmentsDao = new DepartmentsDaoImpl();
    @Override
    public DepartmentHighestQuantityEmployee ShowDepartmentHighestQuantityEmployee() {
        return null;
    }

    @Override
    public List<Departments> findAll() {
        return departmentsDao.findAll();
    }

    @Override
    public void save(Departments entity) {
        departmentsDao.save(entity);
    }

    @Override
    public void delete(Integer id) {
        departmentsDao.delete(id);
    }

    @Override
    public Departments findById(Integer id) {
        return departmentsDao.findById(id);
    }
}
