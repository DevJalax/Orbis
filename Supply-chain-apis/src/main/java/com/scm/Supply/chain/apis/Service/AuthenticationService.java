package com.scm.Supply.chain.apis.Service;

import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.User;
import com.scm.Supply.chain.apis.Repo.UserRepository;

@Service
public class AuthenticationService {
	
    private final UserRepository userRepository;
    
    private final JwtUtil jwtUtil;

    public AuthenticationService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    public String login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new Exception("User not found"));

        if (passwordEncoder.matches(password, user.getPassword())) {
            return jwtUtil.generateToken(user);
        } else {
            throw new Exception("Invalid password");
        }
    }
}
