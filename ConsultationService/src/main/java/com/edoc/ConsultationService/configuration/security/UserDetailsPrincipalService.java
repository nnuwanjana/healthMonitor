package com.edoc.ConsultationService.configuration.security;

import com.edoc.ConsultationService.model.User;
import com.edoc.ConsultationService.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsPrincipalService implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailsPrincipalService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        UserPrincipal principal = new UserPrincipal(user);
        return principal;
    }
}
