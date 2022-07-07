package idea.Controller;

import idea.DataBase.DataBase;
import idea.DataBase.injection.FindInterface;
import idea.DataBase.injection.PlasticNumberRandom;
import idea.DataBase.injection.PrintInterface;
import idea.DataBase.injection.Role;
import idea.Object.Admin;
import idea.Object.Card;
import idea.Object.User;
import idea.Service.ServiceAdmin;
import idea.Service.ServiceUser;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;


public class Controller extends DataBase implements PrintInterface, FindInterface, PlasticNumberRandom {

    private final ServiceUser serviceUser = ServiceUser.getServiceUser();
    private final ServiceAdmin serviceAdmin = ServiceAdmin.getServiceAdmin();
    public String id = "";
    private final User user = new User();

    @SneakyThrows
    public void menu() {
        println("========= Login service =========");
        println(" <1> Sign in");
        println(" <2> Sign up");
        println(" <0> Exit");
        print("Enter option: ");
        switch (intScanner.nextInt()) {
            case 1 -> signIn(user);
            case 2 -> signUp(user);
            case 0 -> print("");
            default -> {
                printErr("Entered option not found!");
                printErr("Try again");
                Thread.sleep(3000);
                menu();
            }
        }
    }

    @SneakyThrows
    private void signUp(User user) {
        ArrayList<Card> cards = new ArrayList<>();
        Card card = new Card();
        print("Enter firstName: ");
        user.setFirstName(strScanner.nextLine());
        print("Enter lastName: ");
        user.setLastName(strScanner.nextLine());
        print("Enter age: ");
        user.setAge(intScanner.nextInt());
        print("Enter phoneNumber: ");
        user.setPhoneNumber(strScanner.nextLine());
        print("Enter email: ");
        user.setEmail(strScanner.nextLine());
        print("Enter username: ");
        user.setUsername(strScanner.nextLine());
        print("Enter password: ");
        user.setPassword(strScanner.nextLine());
        user.setId(UUID.randomUUID().toString());
        user.setPlasticNumber("8600"+generalReflector());
        print("Enter plastic password: ");
        user.setPlasticPassword(intScanner.nextInt());
        user.setMoneyWallet(null);
        user.setRole(Role.USER);
        user.setCards(cards);
        user.setCondition(true);
        card.setPlasticNumber(user.getPlasticNumber());
        card.setPlasticPassword(user.getPlasticPassword());
        user.cards.add(card);
        userList.add(user);
        menu();
    }

    @SneakyThrows
    private void signIn(User user) {
        print("Enter username: ");
        String username = strScanner.nextLine();
        print("Enter password: ");
        String password = strScanner.nextLine();
        if (findUser(username, password)) {
            serviceUser.userSection(user);
        } else if (findAdmin(username, password)) {
            serviceAdmin.adminSection(user);
        } else {
            printErr("This entered username or password invalid");
            printErr("Try again!");
            Thread.sleep(3000);
            signIn(user);
        }
    }

    @Override
    public void println(String str) {
        System.out.println(str);
    }

    @Override
    public void printErr(String str) {
        System.err.println(str);
    }

    @Override
    public boolean findUser(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean findAdmin(String username, String password) {
        for (Admin admin : adminList) {
            if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                id = admin.getId();
                return true;
            }
        }
        return false;
    }

    @Override
    public void print(String str) {
        System.out.println(str);
    }

    @Override
    public Long returnNuber(long aStart, long aEnd, Random aRandom) {
        if (aStart > aEnd) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        }
        long range = aEnd - aStart + 1;
        return (long) (range * aRandom.nextDouble());
    }

    @Override
    public Long generalReflector() {
        long START = 100000000000L;
        long END = 999999999999L;
        Random random = new Random();
        Long num = null;
        for (int idx = 1; idx <= 11; ++idx) {
            num = returnNuber(START, END, random);
        }
        return num;
    }
}
