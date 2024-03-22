package yorku.eecs.controller;

import yorku.eecs.logic.CsvUtil;
import yorku.eecs.model.item.Item;
import yorku.eecs.model.user.User;

import javax.swing.*;
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

    public void subscribe(User user, String newsletter) {
        try{
            user.getSubscribedList().add(newsletter);
            String id = user.getStringId();
            List<String> records = CsvUtil.getRecordByColumn(path, id, 0);
            if (records != null) {
                //Update entry
                List<String> modifiableRecords = new ArrayList<>();
                modifiableRecords.add(0, user.getStringId());
                modifiableRecords.add(1, serializeNewsletterList(user.getSubscribedList()));
                CsvUtil.removeRecordByColumn(path, id, 0);
                CsvUtil.writeCsv(Arrays.asList(modifiableRecords), path, true);
            } else {
                //Create new entry
                List<List<String>> newRecord = new ArrayList<>();
                newRecord.add(Arrays.asList(id, serializeNewsletterList(user.getSubscribedList())));
                CsvUtil.writeCsv(newRecord, path, true);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String serializeNewsletterList(ArrayList<String> subscribedList) {
        return String.join(",", subscribedList);
    }

    public void unsubscribe(User user, String newsletter) {
        getSubscribeList(user);
        List<String> subscribeList = user.getSubscribedList();
        subscribeList.remove(newsletter);
        try{
            String id = user.getStringId();
            List<String> records = CsvUtil.getRecordByColumn(path, id, 0);
            if (records != null) {
                //Update entry
                List<String> modifiableRecords = new ArrayList<>();
                modifiableRecords.add(0, user.getStringId());
                modifiableRecords.add(1, serializeNewsletterList(user.getSubscribedList()));
                CsvUtil.removeRecordByColumn(path, id, 0);
                CsvUtil.writeCsv(Arrays.asList(modifiableRecords), path, true);
            } else {
                //Throw error that user does not exist
                System.out.println("User does not exist");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Get subscribe list
    public User getSubscribeList(User user) {
        try {
            String id = user.getStringId();
            List<String> records = CsvUtil.getRecordByColumn(path, id, 0);
            if (records != null) {
                ArrayList<String> subscribedList = new ArrayList<>(Arrays.asList(records.get(1).split(",")));
                user.setSubscribedList(subscribedList);
            } else {
                user.setSubscribedList(new ArrayList<>());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
