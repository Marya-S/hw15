package pro.sky.employee;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity add(@RequestParam(value = "firstName", required = false) String name, @RequestParam(value = "lastName", required = false) String surname,
                        @RequestParam(value = "salary") double salary, @RequestParam(value = "department") int department) {
        if (!StringUtils.isAllEmpty(name, surname) && StringUtils.isAlpha(name) && StringUtils.isAlpha(surname)) {
            return new ResponseEntity(employeeService.addEmployee(StringUtils.capitalize(name), StringUtils.capitalize(surname), salary, department), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
        }
    }

    @GetMapping(path = "/remove")
    public ResponseEntity remove(@RequestParam(value = "firstName", required = false) String name, @RequestParam(value = "lastName", required = false) String surname) {
        if (!StringUtils.isAllEmpty(name, surname)) {
            return new ResponseEntity(employeeService.deleteEmployee(name, surname), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
        }
    }

    @GetMapping(path = "/find")
    public ResponseEntity find(@RequestParam(value = "firstName", required = false) String name, @RequestParam(value = "lastName", required = false) String surname) {
        if (!StringUtils.isAllEmpty(name, surname)) {
            return new ResponseEntity(employeeService.findEmployee(name, surname), HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
        }
    }

    @GetMapping(path = "/getAll")
    public Map<String, Employee> returnAll() {
        return employeeService.getAllEmployeeList();
    }
}
