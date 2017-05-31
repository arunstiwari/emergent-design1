package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class ConfigFactory {
	
	IEncrypt encrypt;
	
	Transmit transmitter;

	public Transmit getTransmit() {
		return transmitter;
	}

	public IEncrypt getEncrypt() {
		return encrypt;
	}
	
	public void setEncrypt(IEncrypt encrypt) {
		this.encrypt = encrypt;
	}
	
	public void setTransmitter(Transmit transmitter) {
		this.transmitter = transmitter;
	}

}
