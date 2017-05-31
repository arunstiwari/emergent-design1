package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTest {
	
	
	@Mock
	IEncrypt encrypt;
	
	@Mock
	Transmit transmitter;
	
	
	@Autowired
	ConfigFactory configFactory;
	
	@Autowired
	Client client;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		configFactory.setEncrypt(encrypt);
		configFactory.setTransmitter(transmitter);
	}
	
	@Test
	public void getAndSendStatusOfAChip() throws Exception {
		String ENCRYPTED_STATUS = "PGP64 Encryption";
	
		Mockito.when(encrypt.encrypt(Mockito.any())).thenReturn(ENCRYPTED_STATUS);
		Mockito.doCallRealMethod().when(transmitter).transmit(ENCRYPTED_STATUS);
		
		Chip chip = client.createChip();
		String status = chip.getAndSendStatus();
		
		assertEquals(ENCRYPTED_STATUS, status);
	}

}
