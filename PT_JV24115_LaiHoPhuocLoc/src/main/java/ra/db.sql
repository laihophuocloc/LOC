Create database quanlynhansu;

Use quanlynhansu;

Create table Departments (
                             department_id int primary key auto_increment,
                             department_name varchar(50) not null unique,
                             department_status bit default 1
);

Create table Employee (
                          employee_id int primary key auto_increment,
                          employee_name varchar(50) not null unique,
                          position varchar(50) not null,
                          salary double not null check(salary>0),
                          hire_date DATE not null,
                          department_id int not null references Departments(department_id)
)
