package idea.Service;

import idea.Controller.Controller;
import idea.Object.Card;
import idea.Object.User;
import lombok.SneakyThrows;

/**
 * @author Jaloliddin Baxodirov
 * @Time 2022-06-6/8/2022-3:32 PM-27
 * @Project Lombok-Example
 */
public class ServiceAdmin extends Controller implements AdminAssistant {

    private static ServiceAdmin serviceAdmin = new ServiceAdmin();

    public static ServiceAdmin getServiceAdmin() {
        return serviceAdmin;
    }

    public void adminSection(User user,String id) {
        println(" <1> Show users");
        println(" <2> Remove users");
        println(" <3> Show plastic");
        println(" <4> Bank funds");
        println(" <5> Change user");
        println(" <9> Log out");
        println(" <0> Exit");
        switch (intScanner.nextInt()) {
            case 1 -> showUsers(user);
            case 2 -> remove(user);
            case 3 -> showPlastic(user);
            case 4 -> bankFunds(user);
            case 5 -> changeUsers(user);
        }

    }

    @SneakyThrows
    @Override
    public void showUsers(User user) {
        println(" <1> Block users");
        println(" <2> Active users");
        println(" <0> Back");
        print("Enter option: ");
        switch (intScanner.nextInt()) {
            case 1 -> {
                for (User showUser : userList) {
                    if (!(showUser.getCondition())) {
                        println("Name: " + showUser.getFirstName());
                        println("PlaticNumber: " + showUser.getPlasticNumber());
                        println("Money: " + showUser.getMoneyWallet());
                        showUsers(user);
                    }
                }
            }
            case 2 -> {
                for (User showUser : userList) {
                    if ((showUser.getCondition())) {
                        println("Name: " + showUser.getFirstName());
                        println("PlaticNumber: " + showUser.getPlasticNumber());
                        println("Money: " + showUser.getMoneyWallet());
                        showUsers(user);
                    }

                }
            }
            case 3 -> adminSection(user, id);
            default -> {
                println("Entered option not found!");
                println("Try again!");
                Thread.sleep(3000);
                showUsers(user);
            }
        }
    }

    @SneakyThrows
    @Override
    public void remove(User user) {
        for (User showUser : userList) {
            println("Name: " + showUser.getFirstName());
            println("Surname: " + showUser.getLastName());
            println("Username: " + showUser.getUsername());
            println("Password: " + showUser.getPassword());
            println("Id: " + showUser.getId());
            for (Card card : showUser.cards) {
                println("Card number: " + card.getPlasticNumber());
                println("Card password: " + card.getPlasticPassword());
            }
        }
        print("Enter user id: ");
        String userId = strScanner.nextLine();
        for (int i = 0; i >= userList.size(); i++) {
            if (userList.get(i).getId().equals(id)) {
                userList.remove(i);
                Thread.sleep(3000);
                println("Deletion was performed");
                adminSection(user, id);
            } else {
                printErr("Entered id invalid!");
                printErr("Try enter!");
                Thread.sleep(3000);
                remove(user);
            }
        }
    }

    @Override
    public void showPlastic(User user) {

    }

    @Override
    public void bankFunds(User user) {
        Integer bankFunds = 0;
        for (int i = 0; i >= userList.size(); i++) {
            bankFunds += userList.get(i).getMoneyWallet();
        }
        println("Bank of funds money: " + bankFunds);
    }

    @Override
    public void changeUsers(User user) {
        for (User showUser : userList) {
            println("Username: " + showUser.getUsername());
            println("Id: " + showUser.getId());
        }
        print("Enter option: ");
        String userId = strScanner.nextLine();
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getId().equals(userId)){
                print("Enter user new first name: ");
                userList.get(i).setFirstName(strScanner.nextLine());
                print("Enter user new last name: ");
                userList.get(i).setLastName(strScanner.nextLine());
            }
        }
    }
}

