package pro.sky.employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee>listEmployee = null;
    public Employee addEmployee(String name, String surname);
    public Employee deleteEmployee(String name, String surname);
    public Employee findEmployee(String name, String surname);

    public Map<String, Employee>  printAllList();
}
