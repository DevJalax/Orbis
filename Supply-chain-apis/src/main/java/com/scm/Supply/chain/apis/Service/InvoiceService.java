package com.scm.Supply.chain.apis.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.scm.Supply.chain.apis.DTO.InvoiceItem;
import com.scm.Supply.chain.apis.DTO.InvoiceRequest;
import com.scm.Supply.chain.apis.Entity.Invoice;

@Service
public class InvoiceService {

	 public Invoice generateInvoice(InvoiceRequest request) throws Exception {
	        // Validate the request
	        if (request == null || request.getCustomerName() == null || request.getInvoiceItems() == null) {
	            throw new Exception("Invalid request");
	        }

	        // Calculate the total amount
	        double totalAmount = 0;
	        for (InvoiceItem item : request.getInvoiceItems()) {
	            totalAmount += item.getPrice() * item.getQuantity();
	        }

	        // Create the invoice
	        Invoice invoice = new Invoice();
	        invoice.setCustomerName(request.getCustomerName());
	        invoice.setInvoiceDate(LocalDate.now());
	        invoice.setTotalAmount(totalAmount);

	        List<InvoiceItem> invoiceitems = null;
	        // Add items to the invoice
	        for (InvoiceItem item : request.getInvoiceItems()) {
	        	invoiceitems.add(item);
	            invoice.setItems(invoiceitems);
	        }

	        return invoice;
	    }
	
}
