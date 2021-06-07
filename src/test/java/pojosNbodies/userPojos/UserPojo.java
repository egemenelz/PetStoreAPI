package pojosNbodies.userPojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserPojo {

    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

}
