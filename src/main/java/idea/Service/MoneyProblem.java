package idea.Service;

import idea.Object.User;

public interface MoneyProblem {
    void withdrawMoney(User user, Integer plasticNumber,int count);
    void addMoney(User user);
}
