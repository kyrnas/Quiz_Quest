package cs0.DBApi.Services;

import cs0.DBApi.Models.Status;
import cs0.DBApi.Models.User;
import cs0.DBApi.Repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }

    public Status registerUser(User newUser){
        if(getUserByUsername(newUser.getUsername()) != null){
            System.out.println("User Already exists!");
            return Status.USER_ALREADY_EXISTS;
        }
        else if(getUserByEmail(newUser.getEmail()) != null){
            System.out.println("User Already exists!");
            return Status.USER_ALREADY_EXISTS;
        }
        else{
            newUser.setLoggedIn(true);
            saveUser(newUser);
            return Status.SUCCESS;
        }
    }

    public Status loginUser(User user){
        if(user.getUsername() != null){
            User existingUser = getUserByUsername(user.getUsername());
            if (existingUser == null) {
                return Status.FAILURE;
            }
            else {
                if(user.getPass().equals(existingUser.getPass())){
                    existingUser.setLoggedIn(true);
                    return Status.SUCCESS;
                }
                else{
                    return Status.FAILURE;
                }
            }
        }
        else if(user.getEmail() != null) {
            User existingUser = getUserByEmail(user.getEmail());
            if (existingUser == null) {
                return Status.FAILURE;
            }
            else {
                if(user.getPass().equals(existingUser.getPass())){
                    existingUser.setLoggedIn(true);
                    return Status.SUCCESS;
                }
                else{
                    return Status.FAILURE;
                }
            }
        }
        else {
            return Status.FAILURE;
        }
    }

    public Status logoutUser(User user){
        if(user.getUsername() != null) {
            User existingUser = getUserByUsername(user.getUsername());
            existingUser.setLoggedIn(false);
            saveUser(existingUser);
            return Status.SUCCESS;
        }
        else if(user.getEmail() != null) {
            User existingUser = getUserByEmail(user.getEmail());
            existingUser.setLoggedIn(false);
            saveUser(existingUser);
            return Status.SUCCESS;
        }
        else {
            return Status.FAILURE;
        }
    }

    public User getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public User getUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }


}
