package pro.sky.employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee employeeWithMaxSalaryInDepartment(int depart);
    Employee employeeWithMinSalaryInDepartment(int depart);
    List<Employee> printEmployeeInDepartment(int depart);
    Map<Integer,List<Employee>> getAllEmployeeWithDepartment();


}
