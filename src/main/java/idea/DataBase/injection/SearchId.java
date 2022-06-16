package idea.DataBase.injection;

import idea.Object.User;

/**
 * @author Jaloliddin Baxodirov
 * @Time 2022-06-6/8/2022-10:26 PM-34
 * @Project Lombok-Example
 */
public interface SearchId {
    boolean searchUserId(String id);
    void showCardMore(User user);
    boolean searchId(User user,Integer plasticNumber);
}
