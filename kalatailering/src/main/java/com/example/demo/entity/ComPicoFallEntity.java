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
public class ComPicoFallEntity {
	@Id
	private int costomerId;
	private String costomerName;
	private long costomerNumber;
	private int price;
	@Temporal(TemporalType.DATE)
	private String receivedDate;
	@Temporal(TemporalType.DATE)
	private String DeliverydDate;
	private String pico;
	private String Fall;
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCostomerId() {
		return costomerId;
	}
	public void setCostomerId(int costomerId) {
		this.costomerId = costomerId;
	}
	public String getCostomerName() {
		return costomerName;
	}
	public void setCostomerName(String costomerName) {
		this.costomerName = costomerName;
	}
	public long getCostomerNumber() {
		return costomerNumber;
	}
	public void setCostomerNumber(long costomerNumber) {
		this.costomerNumber = costomerNumber;
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
	public String getPico() {
		return pico;
	}
	public void setPico(String pico) {
		this.pico = pico;
	}
	public String getFall() {
		return Fall;
	}
	public void setFall(String fall) {
		Fall = fall;
	}


}
