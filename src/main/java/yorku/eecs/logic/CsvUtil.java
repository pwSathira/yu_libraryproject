package yorku.eecs.logic;

import yorku.eecs.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvUtil {

    public static List<List<String>> readCsv(String filePath) throws IOException {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }
        return records;
    }

    public static void writeCsv(List<List<String>> records, String filePath) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (List<String> record : records) {
                pw.println(String.join(",", record));
            }
        }
    }

    //Get the last ID from the CSV file, from column 1
    public static String getLastID(String filePath) throws IOException {
        List<List<String>> records = readCsv(filePath);
        return records.get(records.size() - 1).get(0);
    }

    public static String getRecordByID(String path, String id) {
        try {
            List<List<String>> records = readCsv(path);
            for (List<String> record : records) {
                if (record.get(0).equals(id)) {
                    return String.join(",", record);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
