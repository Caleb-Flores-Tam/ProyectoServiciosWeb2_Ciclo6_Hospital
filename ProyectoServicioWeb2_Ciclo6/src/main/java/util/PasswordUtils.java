package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {
	 public static String hashPassword(String password) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            byte[] hash = md.digest(password.getBytes());
	            StringBuilder sb = new StringBuilder();
	            for (byte b : hash) sb.append(String.format("%02x", b));
	            return sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	            throw new RuntimeException("Error al encriptar contrase�a", e);
	        }
	    }

	    public static boolean matchPassword(String inputPassword, String storedHash) {
	        return hashPassword(inputPassword).equals(storedHash);
	    }
}
