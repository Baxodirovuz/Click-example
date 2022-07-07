package idea.DataBase.injection;

import idea.Object.User;


public interface SearchId {
    boolean searchUserId(String id);
    void showCardMore(User user);
    boolean searchId(User user,Integer plasticNumber);
}
