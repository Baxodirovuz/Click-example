package idea.Object;

import idea.DataBase.injection.Role;
import lombok.*;

import java.math.BigInteger;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Admin {
    private String username;
    private String password;
    private String id = UUID.randomUUID().toString();
    private String plasticNumber;
    private int plasticPassword;
    private BigInteger moneyWallet;
    private Role role;
}
