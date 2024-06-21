package com.scm.Supply.chain.apis.Entity;

import java.time.LocalDate;
import java.util.List;

import com.scm.Supply.chain.apis.DTO.InvoiceItem;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="invoice")
public class Invoice {

	    private String customerName;
	    private LocalDate invoiceDate;
	    private double totalAmount;
	    private List<InvoiceItem> items;
	    
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public LocalDate getInvoiceDate() {
			return invoiceDate;
		}
		public void setInvoiceDate(LocalDate invoiceDate) {
			this.invoiceDate = invoiceDate;
		}
		public double getTotalAmount() {
			return totalAmount;
		}
		public void setTotalAmount(double totalAmount) {
			this.totalAmount = totalAmount;
		}
		public List<InvoiceItem> getItems() {
			return items;
		}
		public void setItems(List<InvoiceItem> items) {
			this.items = items;
		}
	    
}
