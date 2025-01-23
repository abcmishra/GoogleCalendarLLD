import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create AccountManager and AuthenticationService
        AccountManager accountManager = new AccountManager();
        CalendarManager calendarManager = new CalendarManager();
        AuthenticationService authService = new AuthenticationService(accountManager,calendarManager);

        // Create a user and register
        User user = new User("U1", "John Doe", "john@example.com","abc$12");

        user.setId("U1");
        user.setName("John Doe");
        user.setEmail("john@example.com");
        authService.register(user, "password123");

        // Sign in the user
        boolean signInResult = authService.signIn(user.getId(), "password123");
        System.out.println("User signed in: " + signInResult);

        // Create an event
        Event event = new Event(
                "E1",
                "Team Meeting",
                "Weekly sync-up",
                user,
                LocalDateTime.of(2025, 1, 24, 10, 0),
                LocalDateTime.of(2025, 1, 24, 11, 0),
                LocalDate.of(2025, 1, 24),
        );
        event.setId("E1");
        event.setTitle("Team Meeting");
        event.setDescription("Weekly sync-up");
        event.setOwner(user);
        event.setCreatedAt(LocalDateTime.now());

        // Create a schedule for the event
        Schedule schedule = new Schedule();
        schedule.setId("S1");
        schedule.setStartTime(LocalDateTime.of(2025, 1, 24, 10, 0));
        schedule.setEndTime(LocalDateTime.of(2025, 1, 24, 11, 0));
        event.setSchedule(schedule);

        // Create a calendar and add the event
        Calendar calendar = new Calendar();
        calendar.setId("C1");
        calendar.setName("Work Calendar");
        calendar.setOwner(user);
        calendar.setEvents(new ArrayList<>());
        calendar.addEvent(event.getId());

        System.out.println("Event added to calendar: " + event.getTitle());

        // Edit the event
        Event updatedEvent = new Event();
        updatedEvent.setId("E1");
        updatedEvent.setTitle("Updated Team Meeting");
        updatedEvent.setDescription("Updated weekly sync-up");
        updatedEvent.setOwner(user);
        updatedEvent.setCreatedAt(LocalDateTime.now());
        updatedEvent.setSchedule(schedule);

        calendar.editEvent(event.getId(), updatedEvent);
        System.out.println("Event updated in calendar: " + updatedEvent.getTitle());

        // Create a reminder for the event
        Reminders reminder = new Reminders(
                "R1",
                event.getId(),
                LocalDateTime.of(2025, 1, 24, 9, 45),
                Reminders.Notification.EMAIL
        );



        ReminderService reminderService = new ReminderService();
        reminderService.addReminder(user.getId(), reminder);

        System.out.println("Reminder added for event: " + reminder.getEventId());

        // Retrieve reminders
        List<Reminders> reminders = reminderService.getReminders(user.getId());
        System.out.println("Reminders for user: " + reminders.size());

        // Sign out the user
        authService.signOut(user.getId());
        System.out.println("User signed out: " + !authService.isSignedIn(user.getId()));
    }
}
