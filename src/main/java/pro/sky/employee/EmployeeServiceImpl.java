package pro.sky.employee;

import exception.EmployeeAlreadyAdded;
import exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> listEmployee = new ArrayList<>();

    public Employee addEmployee(String name, String surname) {
        Employee employee = new Employee(name, surname);
        for (Employee element : listEmployee
        ) {
            if (element.getName().equals(name) && element.getSurname().equals(surname)) {
                throw new EmployeeAlreadyAdded("Сотрудник уже добавлен в список");
            }
        }
        listEmployee.add(employee);
        return employee;
    }

    public Employee deleteEmployee(String name, String surname) {
        for (Employee employee : listEmployee
        ) {
            if (employee.getName().equals(name) && employee.getSurname().equals(surname)) {
                listEmployee.remove(employee);
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    public Employee findEmployee(String name, String surname) {
        for (Employee employee : listEmployee
        ) {
            if (employee.getName().equals(name) && employee.getSurname().equals(surname)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    public List<Employee> printAllList() {
        return listEmployee;
    }
}

