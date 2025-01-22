/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentmanagement;

/**
 *
 * @author ejones2025
 */

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.println("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("Enter name for student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.println("Enter ID for student " + (i + 1) + ": ");
            String id = scanner.nextLine();

            String[] courseNames = new String[3];
            for (int j = 0; j < 3; j++) {
                System.out.println("Enter name of course " + (j + 1) + ": ");
                courseNames[j] = scanner.nextLine();
            }
            
           Student student = new Student(name, id, courseNames);
            students.add(student);
        }

        for (Student student : students) {
            System.out.println("\n Setting scores for " + student.toString());
            for (int j = 0; j < 3; j++) {
                System.out.println("Enter score for " + student.getTestScore(j) + " (" + student.getTestScore(j) + "): ");
                double score = scanner.nextDouble();
                student.setTestScore(j, score);
            }
        }

        System.out.println("\n Student Details:");
        for (Student student : students) {
            System.out.println(student);
        }

        scanner.close();
    }
}

class Course {
    private String courseName;
    private double testScore;

    public Course(String courseName) {
        this.courseName = courseName;
        this.testScore = 0.0;
    }

    public void setTestScore(double testScore) {
        this.testScore = testScore;
    }

    public double getTestScore() {
        return testScore;
    }

    public String getCourseName() {
        return courseName;
    }
}

class Student {
    private String name;
    private String id;
    private Course[] courses;

    public Student(String name, String id, String[] courseNames) {
        this.name = name;
        this.id = id;
        this.courses = new Course[3];
        for (int i = 0; i < 3; i++) {
            this.courses[i] = new Course(courseNames[i]);
        }
    }

    public void setTestScore(int courseIndex, double score) {
        if (courseIndex >= 0 && courseIndex < 3) {
            courses[courseIndex].setTestScore(score);
        } else {
            System.out.println("Invalid course index.");
        }
    }

    public double getTestScore(int courseIndex) {
        if (courseIndex >= 0 && courseIndex < 3) {
            return courses[courseIndex].getTestScore();
        } else {
            System.out.println("Invalid course index.");
            return -1;
        }
    }

    public double getAverage() {
        double total = 0;
        for (Course course : courses) {
            total += course.getTestScore();
        }
        return total / courses.length;
    }

    @Override
    public String toString() {
        StringBuilder details = new StringBuilder("Student Name: " + name + ", ID: " + id + "\n");
        for (int i = 0; i < courses.length; i++) {
            details.append("Course ").append(i + 1).append(" (" + courses[i].getCourseName() + "): ")
                    .append(courses[i].getTestScore()).append("\n");
        }
        details.append("Average Score: ").append(getAverage());
        return details.toString();
    }
}
