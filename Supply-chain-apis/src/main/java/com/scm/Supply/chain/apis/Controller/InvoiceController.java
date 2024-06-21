package com.scm.Supply.chain.apis.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scm.Supply.chain.apis.DTO.InvoiceRequest;
import com.scm.Supply.chain.apis.Entity.Invoice;
import com.scm.Supply.chain.apis.Service.InvoiceService;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

	private final InvoiceService invoiceService;

	@Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public Invoice generateInvoice(@RequestBody InvoiceRequest request) throws Exception {
        return invoiceService.generateInvoice(request);
    }
	
}
