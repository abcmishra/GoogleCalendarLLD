import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class AuthenticationService {
    private AccountManager accountManager;
    private Set<String> activeSessions; // To track signed-in users
    private  CalendarManager calendarManager;

    public AuthenticationService(AccountManager accountManager,CalendarManager calendarManager) {
        this.accountManager = accountManager;
        this.activeSessions = new HashSet<>();
        this.calendarManager=calendarManager;
    }

    public boolean signIn(String userId, String password) {
        if (accountManager.authenticate(userId, password)) {
            activeSessions.add(userId);
            return true;
        }
        return false;
    }

    public void signOut(String userId) {
        activeSessions.remove(userId);
    }

    public void register(User user, String password) {
        accountManager.createAccount(user, password);
        Calendar defaultCalendar = new Calendar(user.getId(), user.getName(),"abc");
        defaultCalendar.setId("default-" + user.getId());
        defaultCalendar.setName("Default Calendar");
        defaultCalendar.setOwner(user);
        defaultCalendar.setEvents(new ArrayList<>());
        calendarManager.addCalendar(user.getId(), defaultCalendar);
    }


    public boolean isSignedIn(String userId) {
        return activeSessions.contains(userId);
    }
}
