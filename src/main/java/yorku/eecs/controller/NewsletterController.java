package yorku.eecs.controller;

import yorku.eecs.logic.CsvUtil;
import yorku.eecs.model.item.Item;
import yorku.eecs.model.user.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class NewsletterController {

    private final String path = "src/main/resources/data/newsletterdata.csv";

    public void subscribe(User user, String newsletter) throws ControllerError {
        String id = user.getStringId();
        int column = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String firstLine = reader.readLine(); // Only read the first row for the newsletters
            String[] newsletters = firstLine.split(",");
            for (int i = 0; i < newsletters.length; i++) {
                if (newsletters[i].equals(newsletter)) {
                    column = i;
                    break;
                }
            }

            List<String[]> rows = new ArrayList<>();
            String line;
            String[] row;
            while ((line = reader.readLine()) != null) {
                row = line.split(",");
                rows.add(row);
            }
            reader.close();
            for (int i = 1; i < rows.size(); i++) { // Start from 1 to skip header row
                row = rows.get(i);
                row[column] += "," + id; // Append the id
            }

            PrintWriter writer = new PrintWriter(new FileWriter(path));
            for (String[] newRow : rows) {
                StringBuilder rowString = new StringBuilder();
                for (int i = 0; i < newRow.length; i++) {
                    if (i > 0) {
                        rowString.append(",");
                    }
                    rowString.append(newRow[i]);
                }
                writer.println(rowString.toString());
            }
            writer.close();
        }catch (Exception e){
            throw new ControllerError("Error subscribing to newsletter", e);
        }
    }

    public void unsubscribe(User user, String newsletter) throws ControllerError {
        String id = user.getStringId();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            int column = 0;
            String firstLine = reader.readLine(); // Only read the first row for the newsletters
            String[] newsletters = firstLine.split(",");
            for (int i = 0; i < newsletters.length; i++) {
                if (newsletters[i].equals(newsletter)) {
                    column = i;
                    break;
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[column].equals(id)) {
                    columns[column] = "";
                }
                StringBuilder newLine = new StringBuilder();
                for (int i = 0; i < columns.length; i++) {
                    if (i > 0) {
                        newLine.append(",");
                    }
                    newLine.append(columns[i]);
                }

                // Write the modified line to the original file
                writer.write(newLine.toString());
                writer.newLine();
            }
            writer.close();
            reader.close();
        }catch (Exception e){
            throw new ControllerError("Error unsubscribing from newsletter", e);
        }
    }

    public List<String> getSubscriptions(User user) throws ControllerError {
        String id = user.getStringId();
        List<String> subscriptions = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[0].equals(id)) {
                    subscriptions.add("NYTimes");
                }
                if (columns[1].equals(id)) {
                    subscriptions.add("Guardian");
                }
                if (columns[2].equals(id)) {
                    subscriptions.add("Bloomberg");
                }
            }
            reader.close();
        }catch (Exception e) {
            throw new ControllerError("Error getting subscriptions", e);
        }
        return subscriptions;
    }

}
