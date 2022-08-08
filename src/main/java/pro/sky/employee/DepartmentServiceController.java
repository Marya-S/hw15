package pro.sky.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentServiceController {
    private final DepartmentService departmentService;

    public DepartmentServiceController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam(value = "departmentId") int department){
        return departmentService.employeeWithMaxSalaryInDepartment(department);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam(value = "departmentId") int department){
        return departmentService.employeeWithMinSalaryInDepartment(department);
    }

    @GetMapping(path = "/all", params = {"departmentId"})
    public List<Employee> printEmployeeInDepartment (@RequestParam int departmentId){
        return departmentService.printEmployeeInDepartment(departmentId);
    }

    @GetMapping(path = "/all")
    public Map<Integer, List<Employee>> printEmployeeInDepartment (){
        return departmentService.getAllEmployeeWithDepartment();
    }
}
