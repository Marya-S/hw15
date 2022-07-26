package pro.sky.employee;

import exception.EmployeeAlreadyAdded;
import exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, String> listEmployee = new HashMap<>();

    public String addEmployee(String name, String surname) {
        String fio = name + " " + surname;
        if (listEmployee.containsKey(fio)) {
            throw new EmployeeAlreadyAdded("Сотрудник уже добавлен в список");
        } else {
            listEmployee.put(fio, null);
        }
        return fio;
    }

    public String deleteEmployee(String name, String surname) {
        String fio = name + " " + surname;
        if (listEmployee.containsKey(fio)) {
            listEmployee.remove(fio);
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return fio;
    }

    public String findEmployee(String name, String surname) {
        String fio = name + " " + surname;
        if (listEmployee.containsKey(fio)) {
            return fio;
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    public Map<String, String> printAllList() {
        return listEmployee;
    }
}

