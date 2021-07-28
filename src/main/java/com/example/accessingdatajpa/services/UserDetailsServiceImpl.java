package com.example.accessingdatajpa.services;

import com.example.accessingdatajpa.models.User;
import com.example.accessingdatajpa.payload.request.SignupRequest;
import com.example.accessingdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }

    public Boolean loadByExistingUsername(SignupRequest signUpRequest) {
        return this.userRepository.existsByUsername(signUpRequest.getUsername());
    }

    public Boolean loadByExistingEmail(SignupRequest signUpRequest) {
        return this.userRepository.existsByEmail(signUpRequest.getEmail());
    }

}
