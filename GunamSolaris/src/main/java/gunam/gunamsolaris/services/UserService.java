package gunam.gunamsolaris.services;

import gunam.gunamsolaris.entities.User;
import gunam.gunamsolaris.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    ResponseEntity<List<User>> getAllUsers();

    ResponseEntity<String> addUser(User user) ;

    ResponseEntity<User> findUserById(int id) ;

    ResponseEntity<String> updateUser(int id,User user) ;

    ResponseEntity<String> deleteUser(int id);


}
