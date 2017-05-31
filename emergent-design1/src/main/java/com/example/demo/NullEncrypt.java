package com.example.demo;

public class NullEncrypt implements IEncrypt {

	@Override
	public String encrypt(String status) {
		return "Null_Encrypted_Message";
	}

}
