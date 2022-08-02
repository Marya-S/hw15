package pro.sky.employee;

import exception.EmployeeAlreadyAdded;
import exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> listEmployee = new HashMap<>();

    public Employee addEmployee(String name, String surname) {
        Employee employee = new Employee(name,surname);
        if (listEmployee.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAdded("Сотрудник уже добавлен в список");
        } else {
            listEmployee.put(employee.getFullName(), employee);
        }
        return listEmployee.get(employee.getFullName());
    }

    public Employee deleteEmployee(String name, String surname) {
        Employee employee = new Employee(name,surname);
        if (listEmployee.containsKey(employee.getFullName())) {
            listEmployee.remove(employee.getFullName());
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return listEmployee.get(employee.getFullName());
    }

    public Employee findEmployee(String name, String surname) {
        Employee employee = new Employee(name,surname);
        if (listEmployee.containsKey(employee.getFullName())) {
            return listEmployee.get(employee.getFullName());
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    public Map<String, Employee> printAllList() {
        return listEmployee;
    }
}

