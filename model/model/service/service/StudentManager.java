package service;

import java.util.*;
import model.Student;

public class StudentManager implements RecordActions {

    private Map<Integer, Student> studentMap = new HashMap<>();

    @Override
    public void addStudent(Student s) {
        if (studentMap.containsKey(s.getRollNo())) {
            System.out.println("Error: Student with this Roll No already exists!");
            return;
        }
        studentMap.put(s.getRollNo(), s);
        System.out.println("Student Added Successfully!");
    }

    @Override
    public void deleteStudent(int rollNo) {
        if (studentMap.remove(rollNo) != null)
            System.out.println("Student Deleted Successfully.");
        else
            System.out.println("Student Not Found!");
    }

    @Override
    public void updateStudent(int rollNo, String newCourse) {
        Student s = studentMap.get(rollNo);
        if (s != null) {
            s.setCourse(newCourse);
            System.out.println("Student Updated Successfully.");
        } else {
            System.out.println("Student Not Found!");
        }
    }

    @Override
    public Student searchStudent(int rollNo) {
        return studentMap.get(rollNo);
    }

    @Override
    public void viewAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No Records Found!");
            return;
        }
        for (Student s : studentMap.values()) {
            s.displayInfo();
        }
    }
}
