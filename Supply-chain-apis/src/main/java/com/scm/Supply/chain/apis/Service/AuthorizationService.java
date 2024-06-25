package com.scm.Supply.chain.apis.Service;

import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.User;
import com.scm.Supply.chain.apis.Repo.ServiceRepository;
import com.scm.Supply.chain.apis.Repo.UserRepository;

@Service
public class AuthorizationService {
	
    private final UserRepository userRepository;
    
    private final ServiceRepository serviceRepository;
    
    private final WarrantClient warrantClient;

    public AuthorizationService(UserRepository userRepository, ServiceRepository serviceRepository, WarrantClient warrantClient) {
        this.userRepository = userRepository;
        this.serviceRepository = serviceRepository;
        this.warrantClient = warrantClient;
    }

    public boolean hasAccess(String username, String serviceName) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new Exception("User not found"));

        Service service = serviceRepository.findByName(serviceName)
                .orElseThrow(() -> new Exception("Service not found"));

        return warrantClient.hasAccess(user.getRole(), service.getId());
    }
}