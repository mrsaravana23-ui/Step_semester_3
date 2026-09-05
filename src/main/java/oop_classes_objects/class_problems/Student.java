package oop_classes_objects.class_problems;

class Student {
    String name;
    int attendance;
    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        new Student("Arun", 85);
        new Student("Bhavna", 90);

        Student.printCollegeInfo();
    }
}