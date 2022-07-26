package pro.sky.employee;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam(value = "firstName", required = false) String name, @RequestParam(value = "lastName", required = false) String surname) {
        if (!(name == null) && (!(surname == null))) {
            return employeeService.addEmployee(name, surname);
        } else {
            System.out.println("Не все параметры заданы");
        }
        return null;
    }

   @GetMapping(path = "/remove")
    public Employee remove(@RequestParam(value = "firstName", required = false) String name, @RequestParam(value = "lastName", required = false) String surname) {
        if (!(name == null) && (!(surname == null))) {
            return employeeService.deleteEmployee(name, surname);
        } else {
            System.out.println("Не все параметры заданы");
        }
        return null;
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam(value = "firstName", required = false) String name, @RequestParam(value = "lastName", required = false) String surname) {
        if (!(name == null) && (!(surname == null))) {
            return employeeService.findEmployee(name, surname);
        } else {
            System.out.println("Не все параметры заданы");
        }
        return null;
    }

    @GetMapping(path = "/getAll")
    public Map<String, Employee> returnAll() {
        return employeeService.printAllList();
    }
}
