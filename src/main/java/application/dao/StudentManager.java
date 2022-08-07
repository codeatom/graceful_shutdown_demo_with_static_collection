package application.dao;

import java.util.ArrayList;
import java.util.List;
import application.model.Student;
import application.sequencer.StudentSequencer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import static application.maintenence.StaticResources.STUDENT_FILE;


public class StudentManager {

    private static List<Student> students = new ArrayList<>();
    public static List<Student> getStudents() {
        return students;
    }


    public Student createStudent(String name, String email) {
        Student student = new Student(StudentSequencer.nextStudentId(), name, email);
        students.add(student);
        return student;
    }


    public static void saveStudents(){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
            objectWriter.writeValue(STUDENT_FILE, students);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void loadStudents(){
        List<Student> existingStudents = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            existingStudents = objectMapper.readValue(STUDENT_FILE, new TypeReference<List<Student>>() {});
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        students = existingStudents;
    }

}