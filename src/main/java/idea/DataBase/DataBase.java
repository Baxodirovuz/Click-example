package idea.DataBase;

import idea.Object.Admin;
import idea.Object.User;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jaloliddin Baxodirov
 * @Time 2022-06-6/8/2022-2:59 PM-27
 * @Project Lombok-Example
 */
public class DataBase {

    public ArrayList<User> userList = new ArrayList<>();
    public ArrayList<Admin> adminList = new ArrayList<>();

    public Scanner intScanner = new Scanner(System.in);
    public Scanner strScanner = new Scanner(System.in);

}
