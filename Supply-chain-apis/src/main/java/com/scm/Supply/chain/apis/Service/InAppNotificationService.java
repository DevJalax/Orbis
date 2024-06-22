package com.scm.Supply.chain.apis.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.scm.Supply.chain.apis.Entity.Notification;

@Service
public class InAppNotificationService {

	 private final FirebaseMessaging firebaseMessaging;
	 
	 private static final Logger logger = LoggerFactory.getLogger(InAppNotificationService.class);

	    public InAppNotificationService(FirebaseMessaging firebaseMessaging) {
	        this.firebaseMessaging = firebaseMessaging;
	    }
	    
	    public void send(Notification notify) throws FirebaseMessagingException {
	    	
	    	 Message messageToSend = Message.builder()
	                    .setTo(to)
	                    .setNotification(Notification.builder()
	                            .setTitle(notify.getMessage())
	                            .build())
	                    .build();
	    	
	    	 firebaseMessaging.send(messageToSend);
	    	 
	    }
	
}
