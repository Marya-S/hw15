package pro.sky.employee;

import exception.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    private DepartmentServiceImpl out;
    @Mock
    private EmployeeService employeeServiceMock;

    Map<String, Employee> listEmployee = new HashMap<>();

    {
        listEmployee.put("Иванов Сергей", new Employee("Сергей", "Иванов", 15500, 1));
        listEmployee.put("Федоров Антон", new Employee("Антон", "Федоров", 25700, 1));
        listEmployee.put("Дмитриева Ирина", new Employee("Ирина", "Дмитриева", 13900, 2));
        listEmployee.put("Фролов Егор", new Employee("Егор", "Фролов", 18700, 2));
        listEmployee.put("Петрова Екатерина", new Employee("Екатерина", "Петрова", 29700, 1));
    }

    @BeforeEach
    public void initOut() {
        out = new DepartmentServiceImpl(employeeServiceMock);
    }

    @Test
    void employeeWithMaxSalaryInDepartment() {
        when(employeeServiceMock.getAllEmployeeList()).thenReturn(listEmployee);
        assertEquals("Петрова Екатерина", out.employeeWithMaxSalaryInDepartment(1).getFullName());
        verify(employeeServiceMock, only()).getAllEmployeeList();
    }

    @Test
    void employeeWithMaxSalaryInEmptyDepartment() {
        when(employeeServiceMock.getAllEmployeeList()).thenReturn(listEmployee);
        assertThrows(EmployeeNotFoundException.class, () -> out.employeeWithMaxSalaryInDepartment(3));
    }

    @Test
    void employeeWithMinSalaryInDepartment() {
        when(employeeServiceMock.getAllEmployeeList()).thenReturn(listEmployee);
        assertEquals("Дмитриева Ирина", out.employeeWithMinSalaryInDepartment(2).getFullName());
        verify(employeeServiceMock, only()).getAllEmployeeList();
    }

    @Test
    void employeeWithMinSalaryInEmptyDepartment() {
        when(employeeServiceMock.getAllEmployeeList()).thenReturn(listEmployee);
        assertThrows(EmployeeNotFoundException.class, () -> out.employeeWithMinSalaryInDepartment(3));
    }

    @Test
    void printEmployeeInDepartment() {
        when(employeeServiceMock.getAllEmployeeList()).thenReturn(listEmployee);
        List<Employee> result = out.printEmployeeInDepartment(1);
        List<Employee> expectedResult = listEmployee.values().stream().filter(employee -> employee.getDepartment() == 1).collect(Collectors.toList());
        assertTrue(expectedResult.containsAll(result));
    }

    @Test
    void printEmployeeInEmptyDepartment() {
        when(employeeServiceMock.getAllEmployeeList()).thenReturn(listEmployee);
        assertTrue(out.printEmployeeInDepartment(3).isEmpty());
    }

    @Test
    void getAllEmployeeWithDepartment() {
        when(employeeServiceMock.getAllEmployeeList()).thenReturn(listEmployee);
        Map<Integer, List<Employee>> result = out.getAllEmployeeWithDepartment();
        Map<Integer, List<Employee>> expectedResult = listEmployee.values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        assertTrue(areEqualWithEmployeeValue(result, expectedResult));
    }

    private boolean areEqualWithEmployeeValue(Map<Integer, List<Employee>> first, Map<Integer, List<Employee>> second) {
        if (first.size() != second.size()) {
            return false;
        }
        boolean flag = false;
        Iterator<Integer> iterator = first.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            flag = first.get(key).containsAll(second.get(key));
        }
        return flag;
    }
}