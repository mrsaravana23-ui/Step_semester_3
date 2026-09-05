package constructors_keywords.class_problems;

class SrmStudent {
    static String collegeName;
    static String academicYear;
    String name;

    static {
        collegeName = "SRM University";
        academicYear = "2026-2027";
        System.out.println("College info loaded");
    }

    public SrmStudent(String name) {
        this.name = name;
        System.out.println("Student record created: " + name);
    }
}

public class CollegeSetup {
    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};
        for (String name : names) {
            new SrmStudent(name);
        }
    }
}