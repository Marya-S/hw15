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
    public String add(@RequestParam(value = "firstName", required = false) String name, @RequestParam(value = "lastName", required = false) String surname) {
        if (!(name == null) && (!(surname == null))) {
            return employeeService.addEmployee(name, surname);
        } else {
            System.out.println("Не все параметры заданы");
        }
        return null;
    }

   @GetMapping(path = "/remove")
    public String remove(@RequestParam(value = "firstName", required = false) String name, @RequestParam(value = "lastName", required = false) String surname) {
        if (!(name == null) && (!(surname == null))) {
            return employeeService.deleteEmployee(name, surname);
        } else {
            System.out.println("Не все параметры заданы");
        }
        return null;
    }

    @GetMapping(path = "/find")
    public String find(@RequestParam(value = "firstName", required = false) String name, @RequestParam(value = "lastName", required = false) String surname) {
        if (!(name == null) && (!(surname == null))) {
            return employeeService.findEmployee(name, surname);
        } else {
            System.out.println("Не все параметры заданы");
        }
        return null;
    }

    @GetMapping(path = "/getAll")
    public Map<String, String> returnAll() {
        return employeeService.printAllList();
    }
}
