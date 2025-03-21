package ra.presentation;

import ra.business.config.InputMethods;

public class HRManagement {
    public static void main(String[] args) {
        showHRManagementMenu();
    }
    public static void showHRManagementMenu() {
        while(true) {
            System.out.println("+-------------------HR MANAGEMENT------------------------+");
            System.out.println("+ 1. Quản lý phòng ban                                   +");
            System.out.println("+ 2. Quản lý nhân viên                                   +");
            System.out.println("+ 3. Thoát                                               +");
            System.out.println("+--------------------------------------------------------+");

            System.out.println("Hãy nhập lựa chọn: ");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    DepartmentManagement.showDepartmentManagementMenu();
                    break;
                case 2:
                    EmployeeMamagement.showEmployeeManagementMenu();
                    break;
                case 3:
                    System.out.println("Cảm ơn và hẹn gặp lại!!");
                    return;
                default:
                    System.err.println("Lựa chon không hợp lệ. Vui lòng nhập lại!!");
                    break;
            }
        }
    }
}
