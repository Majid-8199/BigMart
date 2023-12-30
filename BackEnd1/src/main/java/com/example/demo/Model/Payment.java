package com.example.demo.Model;

import jakarta.persistence.Entity; 
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="PaymentDetails")
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	  private String  cardName;
	  @Id
	  @NotNull(message = "Card Number Required")
	  @Digits(integer = 16, fraction = 0, message = "Card number must contain 16-digits ")
	  private long cardNumber;
	  @NotBlank(message = "Enter Expiry Date")
	  @Pattern(regexp = "^(0[1-9]|1[0-2])\\/\\d{2}$", message = "Invalid Expiry Date")
	  private String cardExpiry;
	  @NotBlank(message = "Enter Upi ID")
	  @Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z].*$",message = "Invalid Upi ID")
	  private String upiNumber;
	  @NotBlank(message = "Enter Name")
	  private String name;
	  @NotBlank(message = "Enter Address")
	  private String address;
	  @NotBlank(message = "Enter Phone Number")
	  @Size(min = 10, message = "Minimum 10 digits")
	  private String contact_num;
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardExpiry() {
		return cardExpiry;
	}
	public void setCardExpiry(String cardExpiry) {
		this.cardExpiry = cardExpiry;
	}
	public String getUpiNumber() {
		return upiNumber;
	}
	public void setUpiNumber(String upiNumber) {
		this.upiNumber = upiNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact_num() {
		return contact_num;
	}
	public void setContact_num(String contact_num) {
		this.contact_num = contact_num;
	}
	  
	
}
