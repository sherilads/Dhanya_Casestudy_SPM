package com.example.CustomerService;

import javax.persistence.Embeddable;

@Embeddable
public class Invoice {
	
	long invoiceid;
	Double invoiceAmount;
	String invoicedate;
	
	public Invoice() {
	
	}
	public long getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(long invoiceid) {
		this.invoiceid = invoiceid;
	}
	public Double getInvoiceAmount() {
		return invoiceAmount;
	}
	public void setInvoiceAmount(Double invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}
	public String getInvoicedate() {
		return invoicedate;
	}
	public void setInvoicedate(String invoicedate) {
		this.invoicedate = invoicedate;
	}
	public Invoice(long invoiceid, Double invoiceAmount, String invoicedate) {
		super();
		this.invoiceid = invoiceid;
		this.invoiceAmount = invoiceAmount;
		this.invoicedate = invoicedate;
	}
	

}
