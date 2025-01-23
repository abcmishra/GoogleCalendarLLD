import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private Map<String,String>  userPasswords;
    public AccountManager(){
        this.userPasswords= new HashMap<>();
    }
    public  void createAccount(User user,String password){
      if(!userPasswords.containsKey(user.getId())){
          user.setPassword(password);
          userPasswords.put(user.getId(),password);
      }
      System.out.println("User is already registered");
    }

    public boolean authenticate(String userId,String password){
        return userPasswords.containsKey(userId) && userPasswords.get(userId).equals(password);
    }


}
