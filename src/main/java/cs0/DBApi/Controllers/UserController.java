package cs0.DBApi.Controllers;

import cs0.DBApi.Models.Status;
import cs0.DBApi.Models.User;
import cs0.DBApi.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users/register")
    public Status registerUser(@Valid @RequestBody User newUser){
        return userService.registerUser(newUser);
    }

    @PostMapping("/users/login")
    public Status loginUser(@Valid @RequestBody User user){
        //System.out.println("User: " + user.getUsername() + " " + user.getEmail() + " " + user.getPass());
        return userService.loginUser(user);
    }

    @PostMapping("/users/logout")
    public Status logUserOut(@Valid @RequestBody User user){
        return userService.logoutUser(user);
    }
}
