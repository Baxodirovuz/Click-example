package idea.Service;

import idea.Controller.Controller;
import idea.DataBase.injection.SearchId;
import idea.Object.Card;
import idea.Object.User;
import lombok.SneakyThrows;

import java.math.BigInteger;

/**
 * @author Jaloliddin Baxodirov
 * @Time 2022-06-6/8/2022-4:53 PM-32
 * @Project Lombok-Example
 *
 *
 * <userSection>
 * 1 -> balansni ko`rish:  id orqali tanlagan hisob raqamlarini ko`rish
 * 2 -> elektron xisob yaratish: birnechta hisob raqam  yaratish
 * 3 -> hisob raqamni o`chirish: bir nechta hisob raqamlarini o`chirish
 * 3 -> pul o`tkazish: tanlagan hisob raqamga tanlagan hisob raqami orqali pul o`tkazish
 * 4 -> pul yechish: belgilangan miqdordagi pulni yechib olish
 * 5 -> pul qo`shish: belgilangan miqdordan oshmagan pul miqdorini qo`shish
 * 6 -> Log out
 * 7 -> Exit
 * <userSection/>
 */
public class ServiceUser extends Controller implements SearchId, MoneyProblem {

    private static ServiceUser serviceUser = new ServiceUser();

    public static ServiceUser getServiceUser() {
        return serviceUser;
    }

    @SneakyThrows
    public void userSection(User user) {
        println("======== User service ========");
        println(" <1> Show balance");
        println(" <2> Create wallet");
        println(" <3> Transfer");
        println(" <4> Withdraw");
        println(" <5> Add money");
        println(" <9> Log out");
        println(" <0> Exit");
        print("Enter option: ");
        switch (intScanner.nextInt()) {
            case 1 -> showBalans(user);
            case 2 -> creatWallet(user);
            case 3 -> transfer(user);
            case 4 -> withdraw(user);
            case 5 -> addMoney(user);
            case 9 -> menu();
            case 0 -> {}
            default -> {
                println("Entered option not found!");
                println("Try again!");
                Thread.sleep(3000);
            }

        }

    }

    private void withdraw(User user) {
        showCardMore(user);
        print("Enter card number: ");
        Integer cardPlasticNumber = intScanner.nextInt();
        for (int i = 0; i < user.cards.size(); i++) {
            if (user.cards.get(i).getPlasticNumber().equals(cardPlasticNumber)) {
                withdrawMoney(user, cardPlasticNumber, i);
            }
        }
        println("Entered card not found!");
    }

    private void transfer(User user) {
        for (User userArray : userList) {
            println("Username: " + userArray.getFirstName());
            println("User id: " + userArray.getId());
            println("==========================================");
        }
        print("Enter User id: ");
        String id = strScanner.nextLine();
        for (User findUser : userList) {
            if (findUser.getId().equals(id)) {
                showCardMore(user);
            }
        }
    }

    private void creatWallet(User user) {
        Card card = new Card();
        card.setPlasticPassword(Integer.valueOf("8600" + generalReflector()));
        println("Your plastic number is auto-generated");
        print("Enter plastic password: ");
        card.setPlasticPassword(intScanner.nextInt());
        println("You are your new plastic");
        println("Plastic number: " + card.getPlasticNumber());
        println("Plastic password: " + card.getPlasticPassword());
        user.cards.add(card);
        userSection(user);
    }

    private void showBalans(User user) {
        showCardMore(user);
    }

    @Override
    public boolean searchUserId(String id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void showCardMore(User user) {
        for (Card card : user.getCards()) {
            println("==========================================");
            println("Plastic number: " + card.getPlasticNumber());
            println("Plastic amount of money: " + user.getMoneyWallet());
            println("==========================================");
        }
    }

    @Override
    public boolean searchId(User user, Integer plasticNumber) {
        for (int i = 0; i <= user.cards.size(); i++) {
            if (user.cards.get(i).getPlasticNumber().equals(plasticNumber)) {
                withdrawMoney(user, plasticNumber, i);
            }
        }
        return false;
    }

    @SneakyThrows
    @Override
    public void withdrawMoney(User user, Integer plasticNumber, int count) {
        for (int i = 0; i < user.cards.size(); i++) {
            if (user.cards.get(i).getPlasticNumber().equals(plasticNumber)) {
                println("================= Money laundering department =================");
                println(" Limited quantity: 500000 so`m");
                print("Enter amount of money: ");
                Double price = intScanner.nextDouble();
                if ((user.getMoneyWallet() >= price)) {
                    println("Really let the money go");
                    println(" <1> Yes");
                    println(" <2> No");
                    println(" <0> Go back");
                    print("Enter option");
                    switch (intScanner.nextInt()) {
                        case 1 -> {
                            user.setMoneyWallet((int) (user.getMoneyWallet() - price));
                            userSection(user);
                        }
                        case 2 -> userSection(user);
                        case 0 -> userSection(user);
                        default -> {
                            println("Entered option not found ");
                            println("Try again!");
                            Thread.sleep(3000);
                            withdraw(user);
                        }
                    }
                }
            }
        }
    }

    @SneakyThrows
    @Override
    public void addMoney(User user) {
        println(" ================== Add money ==================");
        print("Enter money to be added: ");Double price = intScanner.nextDouble();
        System.out.println("Do you add money?");
        println(" <1> Yes");
        println(" <2> No");
        println(" <0> Go back");
        print("Enter option: ");
        switch (intScanner.nextInt()){
            case 1 -> {
                user.setMoneyWallet((int) (user.getMoneyWallet()+price));
                userSection(user);
            }
            case 2 -> userSection(user);
            case 0 -> userSection(user);
            default -> {
                println("Entered option not found ");
                println("Try again!");
                Thread.sleep(3000);
                withdraw(user);
            }
        }


    }
}
