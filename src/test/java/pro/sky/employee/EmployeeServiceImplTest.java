package pro.sky.employee;

import exception.EmployeeAlreadyAdded;
import exception.EmployeeNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

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
        Assertions.assertThrows(EmployeeAlreadyAdded.class, () -> {
            employeeService.addEmployee("Сергей", "Петров", 18000, 1);
        });
    }

    @Test
    void deleteEmployee() {
        employeeService.addEmployee("Виталий", "Семенов", 17000, 1);
        employeeService.deleteEmployee("Виталий", "Семенов");
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.findEmployee("Виталий", "Семенов");
        });
    }

    @Test
    void deleteIsNotExistedEmployee() {
        Assertions.assertThrows(EmployeeNotFoundException.class, () -> {
            employeeService.deleteEmployee("Абаракадабра", "Абраович");
        });
    }

    @Test
    void findEmployee() {
        employeeService.addEmployee("Лаврентий", "Филиппов", 17000, 1);
        Employee person = employeeService.findEmployee("Лаврентий", "Филиппов");
        Assertions.assertTrue(person.getName().equals("Лаврентий") && person.getSurname().equals("Филиппов")
                && person.getDepartment() == 1);
    }

    @Test
    void getAllEmployeeList() {
        Map<String, Employee> employeeList = employeeService.getAllEmployeeList();
        Assertions.assertNotNull(employeeList);
    }
}