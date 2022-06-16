package idea.Service;

import idea.Object.User;

public interface AdminAssistant {
    void showUsers(User user);
    void remove(User user);
    void showPlastic(User user);
    void bankFunds(User user);
    void changeUsers(User user);
}
