package pro.sky.employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class EmployeeBookServiceController {
    private final EmployeeBookService employeeBookService;

    public EmployeeBookServiceController(EmployeeBookService employeeBookService) {
        this.employeeBookService = employeeBookService;
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalary(@RequestParam(value = "departmentId") int department){
        return employeeBookService.employeeWithMaxSalaryInDepartment(department);
    }

    @GetMapping(path = "/min-salary")
    public Employee minSalary(@RequestParam(value = "departmentId") int department){
        return employeeBookService.employeeWithMinSalaryInDepartment(department);
    }

    @GetMapping(path = "/all/{departmentId}")
    public void printEmployeeInDepartment (@RequestParam(value = "departmentId") int department){
        employeeBookService.printEmployeeInDepartment(department);
    }

    @GetMapping(path = "/all")
    public Map<String, Employee> printEmployeeInDepartment (){
        return employeeBookService.getAllEmployeeWithDepartment();
    }
}
