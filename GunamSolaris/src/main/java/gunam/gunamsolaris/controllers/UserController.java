package gunam.gunamsolaris.controllers;

import gunam.gunamsolaris.entities.User;
import gunam.gunamsolaris.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return userService.getAllUsers();
    }


    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody User user) throws Exception {
        return userService.addUser(user);
    }


    @GetMapping("/user/{id}")
    ResponseEntity<User> findUserById(@PathVariable("id") int id) {

        return userService.findUserById(id);

    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") int id,@RequestBody User user) throws Exception {
        return userService.updateUser(id,user);
    }


    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){
        return userService.deleteUser(id);
    }

}