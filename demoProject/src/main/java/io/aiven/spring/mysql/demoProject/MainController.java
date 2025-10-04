package io.aiven.spring.mysql.demoProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// this MainController is for url

@RestController // this class is a rest-controller // to handle http request

@RequestMapping(path = "/demo")  // it represents url starts with "/demo"
public class MainController {

    @Autowired
    private UserRepository userRepository;  // this variable is used to handle our data

    @PostMapping(path = "/add") // if we go to "/add" url we should be able to add a user // this is only for post request
    public @ResponseBody User addNewUser(@RequestParam String name, @RequestParam String email) {
        User springUser = new User();
        springUser.setName(name);
        springUser.setEmail(email);
        userRepository.save(springUser);
        return springUser;

        // @ResponseBody : is using because we are returning a user type response
        // @RequestParam : it is parameter to get post request
    }

    @GetMapping(path = "/all") // if we go to "/all" url it should show list of all users
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();

        // @ResponseBody : it is returning response body like json or .xml with all the users you want to get
    }
}
