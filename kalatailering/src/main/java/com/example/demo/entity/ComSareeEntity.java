package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
@Data
@Entity
public class ComSareeEntity
{
	@Id
	private int costomerId;
	private String customerName;
	private long customerNumber;
	private int Price;
	private String kuchuType;
	@Temporal(TemporalType.DATE)
	private String receivedDate;
	@Temporal(TemporalType.DATE)
	private String DeliverydDate;
	public int getCostomerId() {
		return costomerId;
	}
	public void setCostomerId(int costomerId) {
		this.costomerId = costomerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public long getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(long customerNumber) {
		this.customerNumber = customerNumber;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getKuchuType() {
		return kuchuType;
	}
	public void setKuchuType(String kuchuType) {
		this.kuchuType = kuchuType;
	}
	public String getReceivedDate() {
		return receivedDate;
	}
	public void setReceivedDate(String receivedDate) {
		this.receivedDate = receivedDate;
	}
	public String getDeliverydDate() {
		return DeliverydDate;
	}
	public void setDeliverydDate(String deliverydDate) {
		DeliverydDate = deliverydDate;
	}


}
