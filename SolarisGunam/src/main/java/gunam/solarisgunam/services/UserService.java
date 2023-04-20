package gunam.solarisgunam.services;

import gunam.solarisgunam.entities.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    ResponseEntity<List<User>> getAllUsers();

    ResponseEntity<String> addUser(User user) ;

    ResponseEntity<User> findUserById(int id) ;

    ResponseEntity<String> updateUser(int id,User user) ;

    ResponseEntity<String> deleteUser(int id);
}
