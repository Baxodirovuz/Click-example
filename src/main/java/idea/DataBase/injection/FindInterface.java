package idea.DataBase.injection;

/**
 * @author Jaloliddin Baxodirov
 * @Time 2022-06-6/8/2022-4:46 PM-04
 * @Project Lombok-Example
 */
public interface FindInterface {
    boolean findUser(String username,String password);
    boolean findAdmin(String username,String password);
}
