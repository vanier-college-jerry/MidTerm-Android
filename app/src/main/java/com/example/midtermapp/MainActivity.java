package com.example.midtermapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView emp_id, emp_name, emp_salary;
    private Button prev_employee, next_employee, calculate_tax;

    private int currentIndex = 0;

    ArrayList<Employee> employees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emp_id = findViewById(R.id.emp_id);
        emp_name = findViewById(R.id.emp_name);
        emp_salary = findViewById(R.id.emp_salary);

        // Buttons
        prev_employee = findViewById(R.id.prev_employee);
        next_employee = findViewById(R.id.next_employee);
        calculate_tax = findViewById(R.id.calculate_tax);


        employees = new ArrayList<>(Arrays.asList(
                new Employee("100", "Jerry", 1000.00),
                new Employee("101", "Urshil", 2000.00),
                new Employee("102", "Karishma", 1000.00)
        ));
        displayEmployeeInfo(currentIndex);
        prev_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex--;
                if (currentIndex >= 0) {
//                    emp_id.setText(employees.get(currentIndex).getEmp_id());
//                    emp_name.setText(employees.get(currentIndex).getEmp_name());
//                    emp_salary.setText(Double.toString(employees.get(currentIndex).getEmp_salary()));
                    displayEmployeeInfo(currentIndex);
                } else {
                    // Set currentIndex to the last employee index if it goes below 0
                    currentIndex = employees.size() - 1;
                    displayEmployeeInfo(currentIndex);
//                    emp_id.setText(employees.get(currentIndex).getEmp_id());
//                    emp_name.setText(employees.get(currentIndex).getEmp_name());
//                    emp_salary.setText(Double.toString(employees.get(currentIndex).getEmp_salary()));
                }

            }
        });

        next_employee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                if (currentIndex < employees.size()) {
                    displayEmployeeInfo(currentIndex);
                } else {
                    // Reset to the first employee if currentIndex exceeds the list size
                    currentIndex = 0;
                    displayEmployeeInfo(currentIndex);
                }

            }
        });

        calculate_tax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee currentEmployee = employees.get(currentIndex);
                double totalTax = currentEmployee.calculateTax();
                String message = "Total tax for " + currentEmployee.getEmp_name() + ": " + totalTax;
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void displayEmployeeInfo(int index) {
        if (index >= 0 && index < employees.size()) {
            Employee currentEmployee = employees.get(index);
            emp_id.setText(currentEmployee.getEmp_id());
            emp_name.setText(currentEmployee.getEmp_name());
            emp_salary.setText(currentEmployee.getEmp_salary() + "$");

            // You can add more TextView widgets for additional information if needed
        }
    }
}