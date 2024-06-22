package com.scm.Supply.chain.apis.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.Entity.Customer;
import com.scm.Supply.chain.apis.Entity.Notification;
import com.scm.Supply.chain.apis.Repo.CustomerRepository;

@Service
public class SmsService {

	    @Autowired
	    private TwilioRestClient twilioRestClient;
	    
	    @Autowired
	    private CustomerRepository customerRepo;
	    
	    @Value({spring.sms.from})
	    private Long fromNum;
	    
	    public void send(Notification notify) {
	    	Optional<Customer> customer =null;
	    	customer = customerRepo.findById(notify.getId());
	    	 Message messageToSend = Message
	    			 .builder()
	    			 .from(fromNum)
	    			 .to(customer.get().getPhoneNumber())
	    			 .body(notify.getMessage())
	    			 .build();
	    	  twilioRestClient.getMessageClient().create(messageToSend);
	    }
	
}
