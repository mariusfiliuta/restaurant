package repositories;


import model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    // Find functions
    public List<User> findAll();
    public List<User> findByRole(String role);
    public List<User> findByContactName(String contactName);
    public List<User> findByContactNameContaining(String contactName);

    // Exists functions
    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM User u WHERE u.userName = ?1")
    public boolean existsUserName(String userName);

    // Delete functions
    @Modifying
    @Transactional
    public void deleteByRole(String role);
    @Modifying
    @Transactional
    public void deleteByUserName(String userName);
    @Modifying
    @Transactional
    public void deleteByContactName(String contactName);

    // Update functions
    @Modifying
    @Transactional
    public User save(User user);

    /*
    Functie fara utilitate

    @Modifying
    @Transactional
    @Query("update User u set u.contactName = ?1 where u.userName = ?2")
    public void setContactNameForUserName(String contactName, String userName);
    */
}
