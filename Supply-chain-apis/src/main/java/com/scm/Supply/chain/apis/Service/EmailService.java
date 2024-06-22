package com.scm.Supply.chain.apis.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Email;
import com.scm.Supply.chain.apis.Entity.Notification;
import com.scm.Supply.chain.apis.Repo.EmailRepository;

@Service
public class EmailService {

    private final EmailRepository emailRepository;
    
    private Email email = null;
    
    @Autowired
    private JavaMailSender javaMailSender;

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
    
    public void send(Notification notify) {
    	email = emailRepository.findEmailById(notify.getId());
    	SimpleMailMessage mailMessage = new SimpleMailMessage();
    	mailMessage.setTo(email.getTo());
    	mailMessage.setSubject(email.getSubject());
    	mailMessage.setText(email.getBody());
    	javaMailSender.send(mailMessage);
    }
    
}
