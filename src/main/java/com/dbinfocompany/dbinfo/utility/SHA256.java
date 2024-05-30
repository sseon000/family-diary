package com.dbinfocompany.dbinfo.utility;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {
	private String string_Sha;

	public SHA256(String string_Sha) {
		this.string_Sha = string_Sha;
	}

	public String changesha() throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		String oristring= this.string_Sha;
		md.update(oristring.getBytes());
		return bytesToHex(md.digest());
	}

	private String bytesToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}




}