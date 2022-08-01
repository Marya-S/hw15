package pro.sky.employee;

import exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeBookServiceImpl implements EmployeeBookService{
    private final EmployeeService employeeService;
    private Map<String, Employee> employeeList;

    public EmployeeBookServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee employeeWithMaxSalaryInDepartment(int depart) {
         return  employeeService.getAllEmployeeList().values().stream()
                 .filter(employee -> employee.getDepartment()==depart)
                 .max(Comparator.comparingDouble(Employee::getSalary))
                 .orElseThrow(()-> new EmployeeNotFoundException("Сотрудник не найден"));
    }

    @Override
    public Employee employeeWithMinSalaryInDepartment(int depart) {
        return  employeeService.getAllEmployeeList().values().stream()
                .filter(employee -> employee.getDepartment()==depart)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow(()-> new EmployeeNotFoundException("Сотрудник не найден"));
    }

    @Override
    public List<Employee> printEmployeeInDepartment(int depart) {
        return employeeService.getAllEmployeeList().values().stream()
                .filter(employee -> employee.getDepartment()==depart)
                .collect(Collectors.toList());
    }

    @Override
    public Map<String,Employee> getAllEmployeeWithDepartment() {
        return employeeService.getAllEmployeeList();
    }
}
