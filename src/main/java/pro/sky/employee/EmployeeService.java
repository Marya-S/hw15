package pro.sky.employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    List<Employee>listEmployee = null;
    public String addEmployee(String name, String surname);
    public String deleteEmployee(String name, String surname);
    public String findEmployee(String name, String surname);

    public Map<String, String>  printAllList();
}
