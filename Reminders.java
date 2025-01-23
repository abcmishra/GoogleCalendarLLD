import java.time.LocalDateTime;

public class Reminders {
    private String id;
    private String eventId;
    private LocalDateTime reminderTime;
    private NotificationType notificationType;

    public Reminders(String id, String eventId, LocalDateTime reminderTime, NotificationType notificationType) {
        this.id = id;
        this.eventId = eventId;
        this.reminderTime = reminderTime;
        this.notificationType = notificationType;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public LocalDateTime getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(LocalDateTime reminderTime) {
        this.reminderTime = reminderTime;
    }

    public NotificationType getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(NotificationType notificationType) {
        this.notificationType = notificationType;
    }
}
