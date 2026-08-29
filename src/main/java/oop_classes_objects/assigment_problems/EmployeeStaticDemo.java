package oop_classes_objects.assigment_problems;

class EmployeeStatic {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeStatic(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class EmployeeStaticDemo {
    public static void main(String[] args) {
        new EmployeeStatic("Alice", 50000);
        new EmployeeStatic("Bob", 60000);
        new EmployeeStatic("Charlie", 70000);

        EmployeeStatic.printCompanyInfo();
    }
}