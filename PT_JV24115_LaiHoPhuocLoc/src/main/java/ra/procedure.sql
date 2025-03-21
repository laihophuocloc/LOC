#1. Procedure of Departments
Create Procedure ProcInsertDepartment(department_name_in varchar(50))
    begin
        insert into departments (department_name) value (department_name_in);
    end;

Create Procedure ProcShowDepartmentList()
    begin
        select * from departments;
    end;

Create Procedure ProcUpdateDepartment(department_name_up varchar(50), department_status_up bit, department_id_up int)
    begin
        update departments
        set department_name = department_name_up, department_status = department_status_up
        where department_id = department_id_up;
    end;

Create Procedure ProcDeleteDepartment(department_id_del int)
    begin
        delete from departments where department_id = department_id_del;
    end;

Create Procedure ProcFindById(department_id_find int)
begin
    select * from departments where department_id = department_id_find;
end;

# Create Procedure ProcShowStudentHighestQuantity(department_name_cal varchar(50), )

#2. Procedure of Employee
Create Procedure ProcInsertEmployee(employee_name_in varchar(50), position_in varchar(50), salary_in double, hire_date_in date, department_id_in int)
begin
    insert into employee (employee_name, position, salary, hire_date, department_id) value (employee_name_in, position_in, salary_in, hire_date_in, department_id_in);
end;


Create Procedure ProcShowEmployeeList()
begin
    select * from employee;
end;

Create Procedure ProcUpdateEmployee(employee_id_up int, employee_name_up varchar(50), position_up varchar(50), salary_up double, department_id_up int)
begin
    update employee
    set employee_name = employee_name_up, position = position_up, salary = salary_up, department_id = department_id_up
    where employee_id = employee_id_up;
end;

Create Procedure ProcDeleteEmployee(employee_id_del int)
begin
    delete from employee where employee_id = employee_id_del;
end;

Create Procedure ProcFindByIdEmployee(employee_id_find int)
begin
    select * from employee where employee_id = employee_id_find;
end;

Create Procedure ProcFindByNameEmployee(employee_name_find int)
begin
    select * from employee where employee_name like concat('%',employee_name_find,'%');
end;
#Hien thi sin hvien theo phogng ban
Create Procedure Top5HighestEmployee()
begin
    select * from employee order by salary desc limit 5;
end;
Create Procedure ProcFindEmployeeByDepartment(department_id_find int)
begin
    select * from employee e join departments d on e.department_id = d.department_id
        where e.department_id = department_id_find;
end;