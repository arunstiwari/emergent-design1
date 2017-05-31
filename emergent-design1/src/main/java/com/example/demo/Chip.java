package com.example.demo;

public class Chip {

	private String status="Non Encrypted";
	

	public String getAndSendStatus() {
		encrypt();
		transmit();
		return getStatus();
	}

	private void transmit() {
		System.out.println("Transmitted the chip status: "+getStatus());
	}

	private void encrypt() {
		this.status= "PGP64 Encryption";
	}

	private String getStatus() {
		return status;
	}

}
