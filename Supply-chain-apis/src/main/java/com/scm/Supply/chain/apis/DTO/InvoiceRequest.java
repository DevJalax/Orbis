package com.scm.Supply.chain.apis.DTO;

import java.util.List;

public class InvoiceRequest {

	private String customerName;
    private List<InvoiceItem> invoiceItems;
    
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public List<InvoiceItem> getInvoiceItems() {
		return invoiceItems;
	}
	public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
		this.invoiceItems = invoiceItems;
	}
    
    
	
}
