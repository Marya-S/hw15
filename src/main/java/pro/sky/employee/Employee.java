package pro.sky.employee;

public class Employee {
    private String name;
    private String surname;
    private double salary;
    private int department;

    public Employee(String name, String surname, double salary, int department) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.department = department;
    }

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFullName(){return this.surname +" " + this.name;}

    @Override
    public String toString() {
        return "Employee{" +
                " surname= " + surname +
                " name= " + name +
                '}';
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
}


