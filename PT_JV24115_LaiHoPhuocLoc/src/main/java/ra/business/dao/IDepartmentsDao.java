package ra.business.dao;

import ra.business.dto.DepartmentHighestQuantityEmployee;
import ra.business.entity.Departments;

public interface IDepartmentsDao extends IGenericDao<Departments, Integer>{
    DepartmentHighestQuantityEmployee ShowDepartmentHighestQuantityEmployee();

}
