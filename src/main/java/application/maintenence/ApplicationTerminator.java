package application.maintenence;

import java.io.*;
import java.util.Properties;

import application.dao.CourseManager;
import application.dao.StudentManager;
import application.sequencer.CourseSequencer;
import application.sequencer.StudentSequencer;
import static application.maintenence.StaticResources.SEQUENCERS_FILE;


public class ApplicationTerminator extends Thread{

    public void run() {
        saveSequencerValue();
        StudentManager.saveStudents();
        CourseManager.saveCourses();
    }

    public void saveSequencerValue(){
        Properties properties = new Properties();
        properties.setProperty("currentStudentId", String.valueOf(StudentSequencer.getStudentSequencer()));
        properties.setProperty("currentCourseId", String.valueOf(CourseSequencer.getCourseSequencer()));

        try(FileWriter writer = new FileWriter(SEQUENCERS_FILE)){
            properties.store(writer, "Latest sequencer values");
        }catch (IOException ex){
            ex.getMessage();
        }
    }

}