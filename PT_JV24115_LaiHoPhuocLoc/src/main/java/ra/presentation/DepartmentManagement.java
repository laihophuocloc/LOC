package ra.presentation;

import ra.business.config.InputMethods;
import ra.business.design.IDepartmentsDesign;
import ra.business.designimpl.DepartmentsDesignImpl;
import ra.business.entity.Departments;

import java.util.List;

public class DepartmentManagement {
    private static final IDepartmentsDesign departmentsDesign = new DepartmentsDesignImpl();
    public static void showDepartmentManagementMenu(){
        while(true){
            System.out.println("+-------------------DEPARTMENT-MENU------------------------+");
            System.out.println("+ 1. Danh sách phòng ban                                   +");
            System.out.println("+ 2. Thêm mới phòng ban                                    +");
            System.out.println("+ 3. Cập nhật thông tin phòng ban                          +");
            System.out.println("+ 4. Xóa phòng ban                                         +");
            System.out.println("+ 5. Hiên thị phòng ban có nhiều nhân viên nhất            +");
            System.out.println("+ 6. Thoát                                                 +");
            System.out.println("+----------------------------------------------------------+");

            System.out.println("Hãy nhập lựa chọn: ");
            byte choice = InputMethods.getByte();
            switch(choice){
                case 1:
                    List<Departments> showDepartmentsList = departmentsDesign.findAll();
                    if(showDepartmentsList.isEmpty()){
                        System.err.println("Danh sách trống");
                    } else {
                        System.out.printf("+%s+%s+%s+\n","-".repeat(4),"-".repeat(20),"-".repeat(15));
                        System.out.printf("|%-4s|%-20s|%-15s|\n","ID", "DepartmentName", "Status");
                        System.out.printf("+%s+%s+%s+\n","-".repeat(4),"-".repeat(20),"-".repeat(15));
                        showDepartmentsList.forEach(Departments::displayData);
                    }
                    break;
                case 2:
                    Departments addNewDepartment = new Departments();
                    addNewDepartment.inputData();
                    departmentsDesign.save(addNewDepartment);
                    System.out.println("Thêm mới thành công!");
                    break;
                case 3:
                    System.out.println("Nhập mã danh mục cần cập nhật: ");
                    int idEdit = InputMethods.getInteger();
                    Departments departmentsEdit = departmentsDesign.findById(idEdit);
                    if(departmentsEdit == null){
                        System.err.println("Không tìm thấy id cần cập nhật");
                    } else {
                        System.out.println("Thông tin cũ: ");
                        System.out.printf("+%s+%s+%s+%s+\n", "-".repeat(4), "-".repeat(20), "-".repeat(20), "-".repeat(10));
                        System.out.printf("|%-4s|%-20s|%-20s|%-10s|\n", "ID", "CategoryName", "Description", "Status");
                        System.out.printf("+%s+%s+%s+%s+\n", "-".repeat(4), "-".repeat(20), "-".repeat(20), "-".repeat(10));
                        departmentsEdit.displayData();
                        System.out.println("Nhập thông tin mới: ");
                        departmentsEdit.inputDataEdit();
                        departmentsDesign.save(departmentsEdit);
                        System.out.println("Cập nhật thành công");
                    }
                    break;
                case 4:
                    System.out.println("Nhập phòng ban cần xóa: ");
                    int idDelete = InputMethods.getInteger();
                    Departments departmentsDelete = departmentsDesign.findById(idDelete);
                    if(departmentsDelete == null){
                        System.err.println("Không tìm thây phòng ban cần xóa!!");
                    } else {
                        departmentsDesign.delete(idDelete);
                        System.out.println("Xóa thành công!");
                    }
                    break;
                case 5:
                    //Lamf Employee da
                    break;
                case 6:
                    HRManagement.showHRManagementMenu();
                    break;
                default:
                    System.err.println("Lựa chon không hợp lệ. Vui lòng nhập lại!!");
                    break;
            }
        }

    }
}
