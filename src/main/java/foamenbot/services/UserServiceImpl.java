package foamenbot.services;

import foamenbot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import foamenbot.repositories.UserRepository;

import java.util.List;

@Service
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

}
