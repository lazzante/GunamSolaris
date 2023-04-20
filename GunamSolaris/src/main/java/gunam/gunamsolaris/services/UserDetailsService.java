package gunam.gunamsolaris.services;

import gunam.gunamsolaris.repositories.UserRepository;
import gunam.gunamsolaris.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findUserByUsername(username);
        return user.map(SecurityUser::new).orElseThrow(()->new UsernameNotFoundException("Username Not Found - "+username));



    }
}
