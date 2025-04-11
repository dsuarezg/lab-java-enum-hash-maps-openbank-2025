import java.util.HashMap;
import java.util.Map;

public class Student {

    private String name;
    private int grade;

    public Student(String name, int grade) {
        setName(name);
        setGrade(grade);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) throws IllegalArgumentException {
     if (grade >= 0 && grade <= 100) {
        this.grade = grade;
     } else {
        throw new IllegalArgumentException("Grade must be between 0 and 100");
     }
    }

    public static Map<String, Student> increasesGrade(Map<String, Student> students) {
        for (Student student : students.values()) {
            if (student.getGrade() < 100) {
                student.setGrade((student.getGrade() *10) / 100 + student.getGrade());
            }
        }
        return students;
    }

    public static void main(String[] args) {

        Map<String, Student> students = new HashMap<>();

        students.put("John", new Student("John", 55));
        students.put("Mike", new Student("Mike", 83));
        students.put("Mary", new Student("Mary", 74));
        students.put("Jane", new Student("Jane", 89));

        for (Student student : students.values()) {
            System.out.println(student.getName() + " has a grade of " + student.getGrade());
        }

        Map<String, Student> updatedStudents = increasesGrade(students);

        for (Student student : updatedStudents.values()) {
            System.out.println(student.getName() + " has a new grade of " + student.getGrade());
        }
    }
}
