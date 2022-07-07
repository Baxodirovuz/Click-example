package idea.DataBase.injection;

public interface FindInterface {
    boolean findUser(String username,String password);
    boolean findAdmin(String username,String password);
}
