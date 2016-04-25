package foamenbot.repositories;


import foamenbot.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public List<User> findAll();
    public List<User> findByRole(String role);
    public List<User> findByContactName(String contactName);
    public List<User> findByContactNameContaining(String contactName);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM User u WHERE u.userName = ?1")
    public boolean existsUserName(String userName);

}
