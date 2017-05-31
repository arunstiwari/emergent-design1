package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTest {

	IEncrypt encrypt;

	Transmit transmitter;

	@Autowired
	ConfigFactory configFactory;

	@Autowired
	Client client;

	@Before
	public void setup() {
		encrypt = new Encrypt64();
		transmitter = new Transmit();
		configFactory.setEncrypt(encrypt);
		configFactory.setTransmitter(transmitter);
	}

	@Test
	public void getAndSendStatusOfAChipForPGP64Encryption() throws Exception {
		String ENCRYPTED_STATUS = "PGP64 Encryption";

		Chip chip = client.createChip();
		String status = chip.getAndSendStatus();

		assertEquals(ENCRYPTED_STATUS, status);
	}

	@Test
	public void getAndSendStatusOfAChipForNullEncryption() throws Exception {
		String NULL_ENCRYPTED_MESSAGE = "Null_Encrypted_Message";

		encrypt = new NullEncrypt();
		configFactory.setEncrypt(encrypt);

		Chip chip = client.createChip();
		String status = chip.getAndSendStatus();

		assertEquals(NULL_ENCRYPTED_MESSAGE, status);
	}

	@Test
	public void getAndSendStatusOfAChipForPGP128Encryption() throws Exception {
		String NULL_ENCRYPTED_MESSAGE = "PGP128 Encryption";

		encrypt = new Encrypt128();
		configFactory.setEncrypt(encrypt);

		Chip chip = client.createChip();
		String status = chip.getAndSendStatus();

		assertEquals(NULL_ENCRYPTED_MESSAGE, status);
	}

}
