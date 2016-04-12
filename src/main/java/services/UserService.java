package services;

import model.User;
import java.util.List;

public interface UserService {

    // Find functions
    List<User> findAll();
    List<User> findByRole(String role);
    List<User> findByContactName(String contactName);
    List<User> findByContactNameContaining(String contactName);

    // Exists functions
    boolean existsByUserName(String userName);

    // Delete functions
    void deleteByRole(String role);
    void deleteByUserName(String userName);
    void deleteByContactName(String contactName);

    // Update functions
    boolean add(String userName, String password, String role, String contactName);
    boolean edit(User user);

    /*
    Functie fara utilitate
    void setContactNameForUserName(String contactName, String userName);
    */
}
