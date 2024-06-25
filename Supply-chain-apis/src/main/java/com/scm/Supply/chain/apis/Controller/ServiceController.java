package com.scm.Supply.chain.apis.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Service.AuthorizationService;

@RestController
@RequestMapping("/services")
public class ServiceController {
	
    private final AuthorizationService authorizationService;

    public ServiceController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> getService(@PathVariable String name, @RequestHeader("Authorization") String token) {
        String username = jwtUtil.extractUsername(token.substring(7)); // remove "Bearer " prefix
        if (authorizationService.hasAccess(username, name)) {
            // return service data
            return ResponseEntity.ok("Service data");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied");
        }
    }
}
