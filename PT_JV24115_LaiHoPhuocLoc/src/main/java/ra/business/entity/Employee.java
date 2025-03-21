package ra.business.entity;

import ra.business.config.InputMethods;
import ra.business.design.IDepartmentsDesign;
import ra.business.designimpl.DepartmentsDesignImpl;

import javax.swing.plaf.InsetsUIResource;
//import java.sql.Date;
import java.util.Date;

public class Employee {
    private int employeeId;
    private String employeeName;
    private String position;
    private double salary;
    private Date hireDate;
    private int departmentId;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String position, double salary, Date hireDate, int departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
        this.departmentId = departmentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    public void inputData(){
        System.out.println("Nhập tên nhân viên: ");
        this.employeeName = InputMethods.getString();
        System.out.println("Nhập vị trí: ");
        this.position = InputMethods.getString();
        System.out.println("Nhập mức lương: ");
        this.salary = InputMethods.getDouble();
        System.out.println("Nhập ngày vào làm: ");
        this.hireDate = InputMethods.getDate();
        System.out.println("Chọn phòng ban: ");
        showDepartments();
        this.departmentId = InputMethods.getInteger();

    }
    public void inputDataEdit(){
        System.out.println("Nhập tên nhân viên: ");
        this.employeeName = InputMethods.getString();
        System.out.println("Nhập vị trí: ");
        this.position = InputMethods.getString();
        System.out.println("Nhập mức lương: ");
        this.salary = InputMethods.getDouble();
        System.out.println("Chọn phòng ban: ");
        showDepartments();
        this.departmentId = InputMethods.getInteger();

    }
    public void showDepartments(){
        IDepartmentsDesign departmentsDesign = new DepartmentsDesignImpl();
        Departments departments = new Departments();
        System.out.printf("+%s+%s+%s+%s+\n", "-".repeat(4), "-".repeat(20), "-".repeat(20), "-".repeat(10));
        System.out.printf("|%-4s|%-20s|%-20s|%-10s|\n", "ID", "CategoryName", "Description", "Status");
        System.out.printf("+%s+%s+%s+%s+\n", "-".repeat(4), "-".repeat(20), "-".repeat(20), "-".repeat(10));
        departmentsDesign.findAll().forEach(Departments::displayData);
    }
    public void displayData(){
        System.out.printf("|%-4d|%-20s|%-20s|%-12f|%-10s|%-10d|\n",this.employeeId, this.employeeName, this.position, this.salary, this.hireDate, this.departmentId);
        System.out.printf("+%s+%s+%s+%s+%s+%s+\n","-".repeat(4),"-".repeat(20),"-".repeat(20),"-".repeat(12),"-".repeat(10),"-".repeat(4));
    }
}
