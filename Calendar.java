import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calendar {
    private String id;
    private String name;
    private User owner;
    private List<String> events;
    private Map<String, PermissionType> permissions;

    public Calendar(String id,String name,User owner){
        this.id=id;
        this.name=name;
        this.owner=owner;
        this.events= new ArrayList<>();
        this.permissions= new HashMap<>();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }

    public Map<String, PermissionType> getPermissions() {
        return permissions;
    }

    public void setPermissions(Map<String, PermissionType> permissions) {
        this.permissions = permissions;
    }

    public void addEvent(String eventId) {
        events.add(eventId);
    }

    public void removeEvent(String eventId) {
        events.remove(eventId);
    }

    public void editEvent(String eventId, Event newEvent) {
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).equals(eventId)) {
                events.set(i, newEvent.getId());
                break;
            }
        }
    }

    private void updateCentralStore(String eventId, Event newEvent) {

        System.out.println("Updating event with ID: " + eventId + " in the central store.");
    }
}