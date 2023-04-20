package gunam.solarisgunam.services;

import gunam.solarisgunam.repositories.UserRepository;
import gunam.solarisgunam.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class JpaUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findUserByUsername(username);
        return user.map(SecurityUser::new).orElseThrow(()->new UsernameNotFoundException("Username Not Found - "+username));



    }
}