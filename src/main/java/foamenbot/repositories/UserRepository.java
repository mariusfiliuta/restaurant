package foamenbot.repositories;


import foamenbot.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
    List<User> findByRole(String role);
    List<User> findByContactName(String contactName);
    List<User> findByContactNameContaining(String contactName);
    User findByUserNameAndPassword(String userName, String Password);
    List<User> findByUserName(String userName);
    User findById(long id);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM User u WHERE u.userName = ?1")
    boolean existsUserName(String userName);

}
