package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTest {
	
	@Test
	public void getAndSendStatusOfAChip() throws Exception {
		Client client = new Client();
		Chip chip = client.createChip();
		String status = chip.getAndSendStatus();
		assertEquals("PGP64 Encryption", status);
	}

}
