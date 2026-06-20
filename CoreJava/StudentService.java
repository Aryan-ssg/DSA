package CoreJava;

import java.util.ArrayList;

public class StudentService {
    ArrayList<Student> students = new ArrayList<>();

    void addStudent(Student s) {
        students.add(s);
        System.out.println("Student added successfully");
    }

    void viewAllStudents() {
        if (students.size() == 0) {
            System.out.println("No students found.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                Student s = students.get(i);
                s.display();
            }
        }

    }

    

}
