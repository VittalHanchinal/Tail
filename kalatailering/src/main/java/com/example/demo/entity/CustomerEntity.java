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
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String customerName;
	private long customerNumber;
	private int customerPrice;
	private String sleeveType;
	private double sleeveLength;
	private double sleeveAround;
	private double armHole;
	private String blouseType;
	private double blouseLengt;
	private double SHoulder;
	private double frontNeckDepth;
	private double backNeckDepth;
	private double Chest;
	private double Waist;
	@Temporal(TemporalType.DATE)
	private String receivedDate;
	@Temporal(TemporalType.DATE)
	private String DeliverydDate;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public int getCustomerPrice() {
		return customerPrice;
	}
	public void setCustomerPrice(int customerPrice) {
		this.customerPrice = customerPrice;
	}
	public String getSleeveType() {
		return sleeveType;
	}
	public void setSleeveType(String sleeveType) {
		this.sleeveType = sleeveType;
	}
	public double getSleeveLength() {
		return sleeveLength;
	}
	public void setSleeveLength(double sleeveLength) {
		this.sleeveLength = sleeveLength;
	}
	public double getSleeveAround() {
		return sleeveAround;
	}
	public void setSleeveAround(double sleeveAround) {
		this.sleeveAround = sleeveAround;
	}
	public double getArmHole() {
		return armHole;
	}
	public void setArmHole(double armHole) {
		this.armHole = armHole;
	}
	public String getBlouseType() {
		return blouseType;
	}
	public void setBlouseType(String blouseType) {
		this.blouseType = blouseType;
	}
	public double getBlouseLengt() {
		return blouseLengt;
	}
	public void setBlouseLengt(double blouseLengt) {
		this.blouseLengt = blouseLengt;
	}
	public double getSHoulder() {
		return SHoulder;
	}
	public void setSHoulder(double sHoulder) {
		SHoulder = sHoulder;
	}
	public double getFrontNeckDepth() {
		return frontNeckDepth;
	}
	public void setFrontNeckDepth(double frontNeckDepth) {
		this.frontNeckDepth = frontNeckDepth;
	}
	public double getBackNeckDepth() {
		return backNeckDepth;
	}
	public void setBackNeckDepth(double backNeckDepth) {
		this.backNeckDepth = backNeckDepth;
	}
	public double getChest() {
		return Chest;
	}
	public void setChest(double chest) {
		Chest = chest;
	}
	public double getWaist() {
		return Waist;
	}
	public void setWaist(double waist) {
		Waist = waist;
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

