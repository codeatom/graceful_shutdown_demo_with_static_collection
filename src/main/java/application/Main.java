package application;

import application.dao.CourseManager;
import application.dao.StudentManager;
import application.maintenence.ApplicationTerminator;
import application.maintenence.Initializer;
import application.model.Course;
import application.model.Student;


public class Main {

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        CourseManager courseManager = new CourseManager();


        //Load data from JSON and Properties files
        Initializer.init();


        for(Student student : StudentManager.getStudents()){
            System.out.println(student.toString() + "\n");
        }

        for(Course course : CourseManager.getCourses()){
            System.out.println(course.toString() + "\n");
        }


//        Student student_1 = studentManager.createStudent("Chris Lucky", "cl@yahoo.com");
//        Student student_2 = studentManager.createStudent("Vic Anders", "va@gmail.com");
//        Student student_3 = studentManager.createStudent("Harris Zander", "hz@provider.com");
//
//        Course course_1 = courseManager.createCourse("Java", 10);
//        course_1.getStudents().add(student_1);
//        course_1.getStudents().add(student_2);
//        course_1.getStudents().add(student_3);
//
//        Course course_2 = courseManager.createCourse("C sharp", 10);
//        Course course_3 = courseManager.createCourse("Javascript", 3);



        //Save data to JSON and Properties files
        Runtime.getRuntime().addShutdownHook(new ApplicationTerminator());

        while(true); //Used to keep the app running in order to simulate closing the app manually.
    }

}