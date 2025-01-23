import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Event {
    private String id;
    private String title;
    private String description;
    private User owner;
    private LocalDateTime createdAt;
    private Map<String ,EventStatus> inviteStatuses;
    private Map<String, List<Reminders>> reminders;

    private Schedule schedule;

    public Event(String id,String title,String description,User owner,LocalDateTime createdAt,Schedule schedule){
        this.id=id;
        this.title=title;
        this.description=description;
        this.owner=owner;
        this.createdAt=createdAt;
        this.description=description;
        this.inviteStatuses= new HashMap<>();
        this.reminders = new HashMap<>();
        this.schedule=schedule;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Map<String, EventStatus> getInviteStatuses() {
        return inviteStatuses;
    }

    public void setInviteStatus(String userId, EventStatus status) {
        inviteStatuses.put(userId, status);
    }
    public void setReminders(String userId, List<Reminders> userReminders) {
        if (reminders != null) {
            reminders.put(userId, userReminders);
        }
    }

    public  List<Reminders> getReminders(User user) {
        return reminders.get(user.getId());
    }

    public EventStatus getInviteStatus(String userId) {
        return inviteStatuses.getOrDefault(userId, EventStatus.PENDING);
    }
}
