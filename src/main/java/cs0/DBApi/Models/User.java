package cs0.DBApi.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

@Data
@Document
public class User {
    @Id
    private String id;
    @Field
    private String username;
    @Field
    private String email;
    @Field
    private String pass;
    private boolean loggedIn;

    public User(String username, String email, String pass) {
        this.username = username;
        this.email = email;
        this.pass = pass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, pass,
                loggedIn);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(pass, user.pass);
    }

}
