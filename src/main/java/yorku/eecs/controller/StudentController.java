package yorku.eecs.controller;

import yorku.eecs.logic.CsvUtil;
import yorku.eecs.logic.FilePath;
import yorku.eecs.model.Student;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
/*
* CRUD Operations for Student Model
*
*
*
*
 */
public class StudentController {
    Student student;
    private final String path = FilePath.STUDENTDATA.getPath();

    public void createStudent(Student student) throws ControllerError{
        this.student = student;
        try {
            String currentId = CsvUtil.getLastInstanceByColumn(path, 0);
            assert currentId != null;
            currentId = Integer.toString(Integer.parseInt(currentId) + 1);
            CsvUtil.writeCsv(student.toCSV(student.getId()), path, true);
        } catch (Exception e) {
            throw new ControllerError("Student creation failed");
        }
    }

    public void updateStudent(Student student) throws ControllerError{
        try {
            List<String> record = CsvUtil.getRecordByColumn(path, student.getStringId(), 0);
            assert record != null;
            record.set(0, student.getUserName());
            record.set(1, student.getFirstName());
            record.set(2, student.getLastName());
            record.set(3, student.getPassword());
            record.set(4, student.getEmailAddress());
            CsvUtil.writeCsv(student.toCSV(student.getId()), path, false);
        } catch (Exception e) {
            throw new ControllerError("Student update failed");
        }
    }

    public Student readStudent(String id) throws ControllerError{
        try {
            List<String> record = CsvUtil.getRecordByColumn(path, student.getStringId(), 0);
            printRecords(record);
            Student student = new Student();
            assert record != null;
            student.setId(Integer.parseInt(record.get(0)));
            student.setUserName(record.get(1));
            student.setFirstName(record.get(2));
            student.setLastName(record.get(3));
            student.setEmailAddress(record.get(4));
            student.setPassword(record.get(5));
            return student;
        } catch (Exception e) {
            throw new ControllerError("Student not found");
        }
    }
    public void deleteStudent() {
        // TODO implement here
    }

    public void printRecords(List<String> records) {
        for (String record : records) {
            System.out.println(record);
        }
    }
}
