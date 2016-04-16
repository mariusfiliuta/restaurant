package services;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.UserRepository;

import javax.validation.OverridesAttribute;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    // Instantiation of first layer(repository)
    @Autowired
    private UserRepository userRepository;


    // Find functions
    @Override
    public List<User> findAll(){ return userRepository.findAll(); }
    @Override
    public List<User> findByRole(String role){ return userRepository.findByRole(role);}
    @Override
    public List<User> findByContactName(String contactName){ return userRepository.findByContactName(contactName);}
    @Override
    public List<User> findByContactNameContaining(String contactName){ return userRepository.findByContactNameContaining(contactName);}

    // Exists functions
    @Override
    public boolean existsByUserName(String userName){ return userRepository.existsUserName(userName);}

    // Delete functions
    @Override
    public void deleteByRole(String role){ userRepository.deleteByRole(role);}
    @Override
    public void deleteByUserName(String userName){ userRepository.deleteByUserName(userName);}
    @Override
    public void deleteByContactName(String contactName){ userRepository.deleteByContactName(contactName);}


    // Update functions
    @Override
    public boolean add(String userName, String password, String role, String contactName){
        if(userRepository.existsUserName(userName))
            return false;
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setRole(role);
        user.setContactName(contactName);
        userRepository.save(user);
        return true;

    }
    @Override
    public boolean edit(User user)
    {
        if(!userRepository.existsUserName(user.getUserName()))
            return false;

        userRepository.save(user);
        return true;
    }

    /*
    Functie fara utilitate
    @Override
    public void setContactNameForUserName(String contactName, String userName){ userRepository.setContactNameForUserName(contactName, userName);}
    */


}
