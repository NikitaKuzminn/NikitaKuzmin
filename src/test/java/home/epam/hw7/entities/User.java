package home.epam.hw7.entities;

import com.jdiai.tools.DataClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends DataClass<User> {

    public static User DEFAULT_USER = new User("Roman", "Jdi123", "ROMAN IOVLEV");

    public String name;
    public String password;
    public String fullName;

    public User(String name, String password, String fullName){
        this.name = name;
        this.password = password;
        this.fullName = fullName;
    }


}
