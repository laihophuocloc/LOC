package ra.business.entity;

import ra.business.config.InputMethods;

public class Departments {
    private int departmentId;
    private String departmentName;
    private boolean departmentStatus;

    public Departments() {
    }

    public Departments(int departmentId, String departmentName, boolean departmentStatus) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentStatus = departmentStatus;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public boolean isDepartmentStatus() {
        return departmentStatus;
    }

    public void setDepartmentStatus(boolean departmentStatus) {
        this.departmentStatus = departmentStatus;
    }

    public void inputData(){
        System.out.println("Nhập tên phòng ban: ");
        this.departmentName = InputMethods.getString();
    }
    public void inputDataEdit(){
        System.out.println("Nhập tên phòng ban: ");
        this.departmentName = InputMethods.getString();
        System.out.println("Nhập trạng thái");
        this.departmentStatus = InputMethods.getBoolean();
    }

    public void displayData(){
        System.out.printf("|%-4d|%-20s|%-15s|\n",this.departmentId, this.departmentName, this.departmentStatus);
        System.out.printf("+%s+%s+%s+\n","-".repeat(4),"-".repeat(20),"-".repeat(15));

    }
}
