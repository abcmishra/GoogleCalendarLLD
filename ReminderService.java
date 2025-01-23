import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReminderService {
    private Map<String , List<Reminders>> reminders;

    public ReminderService(String userid,Reminders reminder){
    this.reminders= new HashMap<>();
    }
    public void addReminder(String userId, Reminders reminder) {
        reminders.computeIfAbsent(userId, k -> new ArrayList<>()).add(reminder);
    }

    public List<Reminders> getReminders(String userId) {
        return reminders.getOrDefault(userId, new ArrayList<>());
    }
}
