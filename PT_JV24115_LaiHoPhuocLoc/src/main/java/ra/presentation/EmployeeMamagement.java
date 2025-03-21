package ra.presentation;

import ra.business.config.InputMethods;
import ra.business.design.IEmployeeDesign;
import ra.business.designimpl.EmployeeDesignImpl;
import ra.business.entity.Departments;
import ra.business.entity.Employee;

import java.util.List;

public class EmployeeMamagement {
    private static final IEmployeeDesign employeeDesign = new EmployeeDesignImpl();
    public static void showEmployeeManagementMenu() {
        while (true){
            System.out.println("+-------------------EMPLOYEE-MENU--------------------------+");
            System.out.println("+ 1. Danh sách nhân viên                                   +");
            System.out.println("+ 2. Thêm mới nhân viên                                    +");
            System.out.println("+ 3. Cập nhật thông tin nhân viên                          +");
            System.out.println("+ 4. Xóa nhân viên                                         +");
            System.out.println("+ 5. Hiên thị danh sách nhân viên theo phòng ban           +");
            System.out.println("+ 6. Tìm kiêm nhân viên theo tên                           +");
            System.out.println("+ 7. Top 5 nhân viên có mức lương cao nhất                 +");
            System.out.println("+ 8. Thoát                                                 +");
            System.out.println("+----------------------------------------------------------+");

            System.out.println("Hãy nhập lựa chọn: ");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    List<Employee> showEmployeesList = employeeDesign.findAll();
                    if(showEmployeesList.isEmpty()){
                        System.err.println("Danh sách trống");
                    } else {
                        System.out.printf("+%s+%s+%s+%s+%s+%s+\n","-".repeat(4),"-".repeat(20),"-".repeat(20),"-".repeat(12),"-".repeat(10),"-".repeat(4));
                        System.out.printf("|%-4s|%-20s|%-20s|%-12s|%-10s|%-10s|\n","ID", "Employee Name", "Position", "Salary", "HireDate", "Department ID");
                        System.out.printf("+%s+%s+%s+%s+%s+%s+\n","-".repeat(4),"-".repeat(20),"-".repeat(20),"-".repeat(12),"-".repeat(10),"-".repeat(4));
                        showEmployeesList.forEach(Employee::displayData);
                    }
                    break;
                case 2:
                    Employee addNewEmployee = new Employee();
                    addNewEmployee.inputData();
                    employeeDesign.save(addNewEmployee);
                    System.out.println("Thêm mới thành công!");
                    break;
                case 3:
                    System.out.println("Nhập mã nhân viên cần cập nhật: ");
                    int idEdit = InputMethods.getInteger();
                    Employee employeesEdit = employeeDesign.findById(idEdit);
                    if(employeesEdit == null){
                        System.err.println("Không tìm thấy id cần cập nhật");
                    } else {
                        System.out.println("Thông tin cũ: ");
                        System.out.printf("+%s+%s+%s+%s+\n", "-".repeat(4), "-".repeat(20), "-".repeat(20), "-".repeat(10));
                        System.out.printf("|%-4s|%-20s|%-20s|%-10s|\n", "ID", "CategoryName", "Description", "Status");
                        System.out.printf("+%s+%s+%s+%s+\n", "-".repeat(4), "-".repeat(20), "-".repeat(20), "-".repeat(10));
                        employeesEdit.displayData();
                        System.out.println("Nhập thông tin mới: ");
                        employeesEdit.inputDataEdit();
                        employeeDesign.save(employeesEdit);
                        System.out.println("Cập nhật thành công");
                    }
                    break;
                case 4:
                    System.out.println("Nhập mã nhân viên cần xóa: ");
                    int idDelete = InputMethods.getInteger();
                    Employee employeesDelete = employeeDesign.findById(idDelete);
                    if(employeesDelete == null){
                        System.err.println("Không tìm thây nhân viên cần xóa!!");
                    } else {
                        employeeDesign.delete(idDelete);
                        System.out.println("Xóa thành công!");
                    }
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    System.out.println("Danh sách nhân viên có lương cao nhất: ");
                    List<Employee> showTop5EmployeesSalary = employeeDesign.findTop5HighestEmployee();
                    if(showTop5EmployeesSalary.isEmpty()){
                        System.err.println("Danh sách trống");
                    } else {
                        System.out.printf("+%s+%s+%s+%s+%s+%s+\n","-".repeat(4),"-".repeat(20),"-".repeat(20),"-".repeat(12),"-".repeat(10),"-".repeat(4));
                        System.out.printf("|%-4s|%-20s|%-20s|%-12s|%-10s|%-10s|\n","ID", "Employee Name", "Position", "Salary", "HireDate", "Department ID");
                        System.out.printf("+%s+%s+%s+%s+%s+%s+\n","-".repeat(4),"-".repeat(20),"-".repeat(20),"-".repeat(12),"-".repeat(10),"-".repeat(4));
                        showTop5EmployeesSalary.forEach(Employee::displayData);
                    }
                    break;
                case 8:
                    HRManagement.showHRManagementMenu();
                    break;
                default:
                    System.err.println("Lựa chon không hợp lệ. Vui lòng nhập lại!!");
                    break;
            }


        }
    }
}
