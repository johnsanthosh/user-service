package controller;
import model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.UserRepository;

import java.util.*;

@CrossOrigin("http://localhost:4200")
@RestController()
@RequestMapping(value = "/user-service")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/")
    String home() {
        return "Spring Boot Application Running.";
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    List<UserModel> getUsers() {
        return this.userRepository.findAll();
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
    UserModel getUsers(@PathVariable String id) {
        return this.userRepository.findOne(id);
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(method = RequestMethod.PUT, value = "/users")
    void addUsers(@RequestBody Map<String, String> user) {
       UserModel userModel = new UserModel();
       userModel.setFirstName(user.get("firstName"));
       userModel.setLastName(user.get("lastName"));
       userModel.setAge(Integer.valueOf(user.get("age")));
       userModel.setPhoneNumber(user.get("phoneNumber"));
       this.userRepository.insert(userModel);
    }

    @CrossOrigin("http://localhost:4200")
    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    void deleteUser(@PathVariable String id) {
        this.userRepository.delete(id);
    }
}
