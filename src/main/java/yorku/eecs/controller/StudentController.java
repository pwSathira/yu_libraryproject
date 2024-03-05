package yorku.eecs.controller;

import yorku.eecs.logic.CsvUtil;
import yorku.eecs.model.Student;
import java.io.BufferedReader;
import java.io.FileReader;

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

    public String CSVtoString(Student student) {
        String filePath = "src/main/resources/data/userdata.csv"; //Replace this with the filepath of csv file
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[0] == Integer.toString(student.getId())) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }


}
