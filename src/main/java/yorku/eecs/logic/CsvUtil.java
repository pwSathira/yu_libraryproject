package yorku.eecs.logic;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvUtil {
    // Read from a CSV file
    public static List<List<String>> readCsv(String filePath) throws CSVError {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new CSVError("Error reading CSV file", e);
        }
        return records;
    }
    // Write to a CSV file
    public static void writeCsv(List<List<String>> records, String filePath, boolean append) throws CSVError {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath, append))) {
            for (List<String> record : records) {
                pw.println(String.join(",", record));
            }
        } catch (IOException e) {
            throw new CSVError("Error writing to CSV file", e);
        }
    }
    // Get the last instance from the CSV file, from a specified column
    public static String getLastInstanceByColumn(String filePath, int columnIndex) throws CSVError {
        List<List<String>> records = readCsv(filePath);
        if (!records.isEmpty() && records.get(records.size() - 1).size() > columnIndex) {
            return records.get(records.size() - 1).get(columnIndex);
        }
        return null;
    }
    // Get a record by a specified value in any specified column
    public static List<String> getRecordByColumn(String filePath, String searchValue, int columnIndex) throws CSVError {
        List<List<String>> records = readCsv(filePath);
        for (List<String> record : records) {
            if (record.size() > columnIndex && record.get(columnIndex).equals(searchValue)) {
                return record;
            }
        }
        return null;
    }
    //Remove specified record from CSV file
    public static void removeRecordByColumn(String filePath, String searchValue, int columnIndex) throws CSVError {
        List<List<String>> records = readCsv(filePath);
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).size() > columnIndex && records.get(i).get(columnIndex).equals(searchValue)) {
                records.remove(i);
                break;
            }
        }
        writeCsv(records, filePath, false);
    }
}
