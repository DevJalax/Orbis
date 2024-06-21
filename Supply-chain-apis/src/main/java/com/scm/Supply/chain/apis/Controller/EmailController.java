package com.scm.Supply.chain.apis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.Entity.Email;
import com.scm.Supply.chain.apis.Service.EmailService;

@RestController
@RequestMapping("/api/emails")
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping
    public ResponseEntity<List<Email>> getAllEmails() {
        List<Email> emails = emailService.getAllEmails();
        return new ResponseEntity<>(emails, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Email> getEmailById(@PathVariable Long id) {
        Email email = emailService.findEmailById(id);
        return new ResponseEntity<>(email, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Email> createEmail(@RequestBody Email email) {
        Email newEmail = emailService.createEmail(email);
        return new ResponseEntity<>(newEmail, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Email> updateEmail(@PathVariable Long id, @RequestBody Email email) {
        Email updatedEmail = emailService.updateEmail(email);
        return new ResponseEntity<>(updatedEmail, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmail(@PathVariable Long id) {
        emailService.deleteEmail(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

