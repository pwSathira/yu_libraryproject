package yorku.eecs.controller;

import yorku.eecs.logic.CsvUtil;
import yorku.eecs.model.Student;
import java.io.BufferedReader;

public class StudentController {
    Student student;
    private final String path = "src/main/resources/data/studentdata.csv";

    public void createStudent(Student student) {
        this.student = student;
        try {
            //Read CSV to see latest ID
            String id = CsvUtil.getLastID(path);
            //Increment ID
            int newID = Integer.parseInt(id) + 1;
            String record = student.getFirstName() + "," + student.getLastName() + "," + newID;
            CsvUtil.writeCsv(student.toCSV(newID), path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent() {
        // TODO implement here
    }

    public Student readStudent(String id) {
        try {
            String record = CsvUtil.getRecordByID(path, id);
            String[] values = record.split(",");
            Student student = new Student();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public void deleteStudent() {
        // TODO implement here
    }

    public String toCSV(Student student) {
//        String 
        return null;
    }


}
