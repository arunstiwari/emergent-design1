package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Client {
	
	@Autowired
	Chip chip;
	
	@Autowired
	ConfigFactory configFactory;
	
	public Chip createChip() {
		chip.setTransmitter(configFactory.getTransmit());
		chip.setEncrypt(configFactory.getEncrypt());
		return chip;
	}

}
