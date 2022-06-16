package idea.Object;

import idea.DataBase.injection.Role;
import lombok.*;

import java.math.BigInteger;
import java.util.UUID;

/**
 * @author Jaloliddin Baxodirov
 * @Time 2022-06-6/8/2022-2:45 PM-13
 * @Project Lombok-Example
 */

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
