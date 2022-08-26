package pro.sky.employee;

import exception.EmployeeAlreadyAdded;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    static EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    void addEmployeeWithSalary() {
        Employee person = employeeService.addEmployee("Иван", "Иванов", 15700, 1);
        assertTrue(person.getName().equals("Иван") && person.getSurname().equals("Иванов") && person.getSalary() == 15700 && person.getDepartment() == 1);
    }

    @Test
    void addEmployeeIsExisted() {
        Employee person = employeeService.addEmployee("Сергей", "Петров", 18000, 1);
        assertTrue(person.getName().equals("Сергей") && person.getSurname().equals("Петров") && person.getSalary() == 15700 && person.getDepartment() == 1);
        Assertions.assertThrows(EmployeeAlreadyAdded.class,() -> {employeeService.addEmployee("Сергей", "Петров", 18000, 1);;});
    }

    @Test
    void deleteEmployee() {
    }

    @Test
    void findEmployee() {
    }

    @Test
    void getAllEmployeeList() {
    }
}