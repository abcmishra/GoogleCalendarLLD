import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalendarManager {
    private Map<String, List<Calendar>> userCalendars; // Maps userId to their calendars
    public CalendarManager(){
        this.userCalendars= new HashMap<>();
    }

    public void addCalendar(String userId, Calendar calendar) {
        userCalendars.computeIfAbsent(userId, k -> new ArrayList<>()).add(calendar);
    }

    public List<Calendar> getCalendars(String userId) {
        return userCalendars.getOrDefault(userId, new ArrayList<>());
    }

    public Calendar getCalendarById(String userId, String calendarId) {
        List<Calendar> calendars = getCalendars(userId);
        for (Calendar calendar : calendars) {
            if (calendar.getId().equals(calendarId)) {
                return calendar;
            }
        }
        return null;
    }

    public void deleteCalendar(String userId, String calendarId) {
        List<Calendar> calendars = getCalendars(userId);
        calendars.removeIf(calendar -> calendar.getId().equals(calendarId));
    }
}
