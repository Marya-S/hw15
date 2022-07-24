package pro.sky.employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {
    List<Employee>listEmployee = null;
    public Employee addEmployee(String name, String surname);
    public Employee deleteEmployee(String name, String surname);
    public Employee findEmployee(String name, String surname);

    public List<Employee>printAllList();
}
