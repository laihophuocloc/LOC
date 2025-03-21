package ra.business.design;

import ra.business.dto.DepartmentHighestQuantityEmployee;
import ra.business.entity.Departments;

public interface IDepartmentsDesign extends IGenericDesign<Departments, Integer> {
    DepartmentHighestQuantityEmployee ShowDepartmentHighestQuantityEmployee();

}
