package com.example.demo;

public class Chip {

	private String status="Non Encrypted";
	private Encrypt encrypt;
	

	public String getAndSendStatus() {
		encrypt();
		transmit();
		return getStatus();
	}

	private void transmit() {
		System.out.println("Transmitted the chip status: "+getStatus());
	}

	private void encrypt() {
		this.status= encrypt.encrypt(getStatus());
	}

	private String getStatus() {
		return status;
	}

	public void setEncryptionForm(Encrypt encrypt) {
		this.encrypt = encrypt;
	}

}
