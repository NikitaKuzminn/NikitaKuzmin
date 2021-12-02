package home.epam.hw7.entities;

import com.epam.jdi.tools.DataClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends DataClass<User> {

    public static User DEFAULT_USER = new User("Roman", "Jdi1234", "ROMAN IOVLEV");

    public String login;
    public String password;
    public String fullName;

    public User(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }
}
