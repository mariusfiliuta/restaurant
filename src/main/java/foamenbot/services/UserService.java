package foamenbot.services;

import foamenbot.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    List<User> findByRole(String role);
    List<User> findByContactName(String contactName);
    List<User> findByContactNameContaining(String contactName);

}
