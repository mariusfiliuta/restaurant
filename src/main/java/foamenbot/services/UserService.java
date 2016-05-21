package foamenbot.services;

import foamenbot.model.User;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(long id);
    List<User> findByRole(String role);
    List<User> findByContactName(String contactName);
    List<User> findByContactNameContaining(String contactName);
    User findByUserNameAndPassword(String userName, String password);
    List<User> findByUserName(String userName);
    void save(User user);
}
