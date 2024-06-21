package com.scm.Supply.chain.apis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Email;
import com.scm.Supply.chain.apis.Repo.EmailRepository;

@Service
public class EmailService {

    private final EmailRepository emailRepository;

    @Autowired
    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public Email findEmailBySubject(String subject) {
        return emailRepository.findEmailBySubject(subject);
    }

    public Email findEmailByBody(String body) {
        return emailRepository.findEmailByBody(body);
    }
    
    public Email findEmailById(Long id) {
    	return emailRepository.findEmailById(id);
    }

    public List<Email> getAllEmails() {
        return emailRepository.findAll();
    }

    public Email createEmail(Email email) {
        return emailRepository.save(email);
    }

    public Email updateEmail(Email email) {
        return emailRepository.save(email);
    }

    public void deleteEmail(Long id) {
        emailRepository.deleteById(id);
    }
}
