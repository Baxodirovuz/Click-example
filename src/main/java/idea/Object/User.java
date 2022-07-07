package idea.Object;

import idea.DataBase.injection.Role;
import lombok.*;

import java.util.ArrayList;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String firstName;
    private String lastName;
    private Integer age;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;
    private String id = UUID.randomUUID().toString();
    private String plasticNumber;
    private Integer plasticPassword;
    private Integer moneyWallet;
    private Boolean condition;
    private Role role;
    public ArrayList<Card> cards;
}
