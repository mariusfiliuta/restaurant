package repositories;


import model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public List<User> findAll();
    public List<User> findByRole(String role);
}
