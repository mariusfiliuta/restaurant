package foamenbot.services;

import foamenbot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import foamenbot.repositories.UserRepository;

import java.util.List;

@Service("userService")
@Configurable
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll(){ return userRepository.findAll(); }
    @Override
    public List<User> findByRole(String role){ return userRepository.findByRole(role);}
    @Override
    public List<User> findByContactName(String contactName){ return userRepository.findByContactName(contactName);}
    @Override
    public List<User> findByContactNameContaining(String contactName){ return userRepository.findByContactNameContaining(contactName);}
    @Override
    public User findByUserNameAndPassword(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName, password);
    }
    @Override
    public void save(User user) {
        userRepository.save(user);
    }
    @Override
    public List<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
