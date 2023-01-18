package com.example.MavenProject;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

    @RestController
    @RequestMapping("/EmpDetails")
    public class EmployeeController {
        List<Employee> employees = new ArrayList<Employee>();
        @GetMapping(value = "/employee")
        public String returnValue() {
            return "Employee Details";
        }

        @GetMapping(value = "/employeeDetails")
        public Employee getEmployeeDetails(@RequestParam int id) throws Exception {
            Employee e1 = new Employee(101, "Bhavya", "Manager");
            Employee e2 = new Employee(102, "Harshini", "Salesman");
            Employee e3 = new Employee(103, "Asha", "Clerk");
            for (Employee employee : employees) {
                if (id == employee.id) {

                    return employee;
                }
            }
            return null;
        }

        @PostMapping(value = "/add")
        public String addNewEmployee(@RequestBody Employee e1) {
            Employee e = new Employee(e1.id, e1.name, e1.role);
            employees.add(e);
            return "Employee added Successfully";
        }

        @PutMapping(value = "/update")
        public String updateEmployeeDetails(@RequestBody Employee e1) throws Exception {
            for (Employee employee : employees) {
                if (employee.id == e1.id) {
                    BeanUtils.copyProperties(e1, employee);
                    return "Employee details updated";
                }
            }
            return null;
        }

        @GetMapping(value = "/studentDetails/{name}")
        public Employee getEmployeeDetails(@PathVariable String name) throws Exception {
            Employee e1 = new Employee(101, "Bhavya", "Manager");
            Employee e2 = new Employee(102, "Harshini", "Salesman");
            Employee e3 = new Employee(103, "Asha", "Clerk");
            for (Employee employee : employees) {
                if (name.equalsIgnoreCase(employee.name)) {

                    return employee;
                }
            }
            return null;
        }

        @DeleteMapping(value = "/delete/{id}")
        public String deleteEmployeeById(@PathVariable int id) throws Exception {
            Employee e4 = new Employee(104, "pradeeb", "Accounts");
            Employee e5 = new Employee(105, "rajesh", "Purchase");
            for (Employee employee : employees) {
                if (id == employee.id) {
                    employees.remove(employee);
                    return employee.name + "deleted";
                }
            }
            return null;
        }
    }


