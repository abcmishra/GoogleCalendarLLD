import java.util.HashSet;
import java.util.Set;

public class AuthenticationService {
    private AccountManager accountManager;
    private Set<String> activeSessions; // To track signed-in users

    public AuthenticationService(AccountManager accountManager) {
        this.accountManager = accountManager;
        this.activeSessions = new HashSet<>();
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
    }

    public boolean isSignedIn(String userId) {
        return activeSessions.contains(userId);
    }
}
