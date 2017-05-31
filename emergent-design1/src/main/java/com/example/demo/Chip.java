package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Chip {

	private String status="Non Encrypted";
	
	@Autowired
	private ConfigFactory config;
	
	public String getAndSendStatus() {
		encrypt();
		transmit();
		return getStatus();
	}

	private void transmit() {
		this.config.getTransmit().transmit(getStatus());
	}

	private void encrypt() {
		this.status= this.config.getEncrypt().encrypt(getStatus());
	}

	private String getStatus() {
		return status;
	}

}
