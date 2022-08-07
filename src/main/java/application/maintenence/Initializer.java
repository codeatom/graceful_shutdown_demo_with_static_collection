package application.maintenence;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import application.dao.CourseManager;
import application.dao.StudentManager;
import application.sequencer.CourseSequencer;
import application.sequencer.StudentSequencer;


import static application.maintenence.StaticResources.SEQUENCERS_FILE;

public class Initializer {
    public static void init(){
        Properties properties = new Properties();

        String currentCourseId = "0";
        String currentStudentId = "0";

        try(FileReader reader = new FileReader(SEQUENCERS_FILE)){
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        currentStudentId = properties.getProperty("currentStudentId");
        currentCourseId = properties.getProperty("currentCourseId");

        StudentSequencer.setStudentSequencer(Integer.parseInt(currentStudentId));
        CourseSequencer.setCourseSequencer(Integer.parseInt(currentCourseId));


        StudentManager.loadStudents();
        CourseManager.loadCourses();
    }
}
