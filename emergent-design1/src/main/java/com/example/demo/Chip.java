package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Chip {

	private String status="Non Encrypted";
	
	private Transmit transmit;

	private IEncrypt encrypt;
	
	public String getAndSendStatus() {
		encrypt();
		transmit();
		return getStatus();
	}

	private void transmit() {
		this.transmit.transmit(getStatus());
	}

	private void encrypt() {
		this.status= this.encrypt.encrypt(getStatus());
	}

	private String getStatus() {
		return status;
	}

	public void setTransmitter(Transmit transmit) {
		this.transmit = transmit;
	}

	public void setEncrypt(IEncrypt encrypt) {
		this.encrypt = encrypt;
	}
	
	

}
