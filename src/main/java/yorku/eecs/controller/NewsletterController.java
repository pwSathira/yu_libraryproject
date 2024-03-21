package yorku.eecs.controller;

import yorku.eecs.logic.CsvUtil;
import yorku.eecs.model.item.Item;
import yorku.eecs.model.user.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NewsletterController {

    private String path = "src/main/resources/data/newsletterdata.csv";

    public void subscribe(User user, String newsletter) throws ControllerError {
        String id = user.getStringId();
        try{
            List<String> records = CsvUtil.getRecordByColumn(path, newsletter, 0);
            assert records != null;
            records.add(id);
            CsvUtil.writeCsv(Arrays.asList(records), path, false);
        }catch (Exception e){
            throw new ControllerError("Error subscribing to newsletter", e);
        }
    }

    public void unsubscribe(User user, String newsletter) throws ControllerError {
        String id = user.getStringId();
        try{
            List<String> records = CsvUtil.getRecordByColumn(path, newsletter, 0);
            assert records != null;
            records.remove(id);
            CsvUtil.writeCsv(Arrays.asList(records), path, false);
        }catch (Exception e){
            throw new ControllerError("Error unsubscribing from newsletter", e);
        }
    }

    public List<String> getSubscriptions(User user) throws ControllerError {
        String id = user.getStringId();
        List<String> subscriptions = new ArrayList<>();
        try{
            List<String> nytimes = CsvUtil.getRecordByColumn(path, "NYTimes", 0);
            List<String> guardian = CsvUtil.getRecordByColumn(path, "Guardian", 0);
            List<String> bloomberg = CsvUtil.getRecordByColumn(path, "Bloomberg", 0);
            for (int i = 0; i < nytimes.size(); i++) {
                if (nytimes.get(i).equals(id)) {
                    subscriptions.add("NYTimes");
                    break;
                }
            }
            for (int i = 0; i < guardian.size(); i++) {
                if (guardian.get(i).equals(id)) {
                    subscriptions.add("Guardian");
                    break;
                }
            }
            for (int i = 0; i < bloomberg.size(); i++) {
                if (bloomberg.get(i).equals(id)) {
                    subscriptions.add("Bloomberg");
                    break;
                }
            }
        }catch (Exception e) {
            throw new ControllerError("Error getting subscriptions", e);
        }
        return subscriptions;
    }

}
