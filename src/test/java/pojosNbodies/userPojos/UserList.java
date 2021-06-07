package pojosNbodies.userPojos;


import lombok.*;

@Getter @Setter
@AllArgsConstructor
public class UserList {

    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

}
