package com.example.midtermapp;

public class Employee {
    String emp_id;
    String emp_name;
    double emp_salary;

    public Employee(String emp_id, String emp_name, double emp_salary) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_salary = emp_salary;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public double getEmp_salary() {
        return emp_salary;
    }

    public void setEmp_salary(double emp_salary) {
        this.emp_salary = emp_salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id='" + emp_id + '\'' +
                ", emp_name='" + emp_name + '\'' +
                ", emp_salary=" + emp_salary +
                '}';
    }

    public double calculateTax(){

        double provincialTax = (emp_salary * 9)/100;
        double federalTax = (emp_salary*7)/100;
        return (provincialTax + federalTax);
    }
}
