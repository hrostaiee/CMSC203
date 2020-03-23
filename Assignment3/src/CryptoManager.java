
/**
 * @author Hasib Rostaiee This Class is data-model for the methods to encrypt
 *         and decrypt texts based on Caesar Cipher and Bellaso Cipher
 *         approaches
 */
public class CryptoManager {

	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII
	 * codes according to the LOWER_BOUND and UPPER_BOUND characters
	 * 
	 * @param plainText a string to be encrypted, if it is within the allowable
	 *                  bounds
	 * @return true if all characters are within the allowable bounds, false if any
	 *         character is outside
	 */
	public static boolean stringInBounds(String plainText) {
		// throw new RuntimeException("method not implemented");
		boolean isInbound = true;
		for (int i = 0; i < plainText.length(); i++) {
			char l = plainText.charAt(i);
			if (!(l >= LOWER_BOUND && l <= UPPER_BOUND)) {
				isInbound = false;
				break;
			}
		}
		return isInbound;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher. The integer key specifies
	 * an offset and each character in plainText is replaced by the character
	 * \"offset\" away from it
	 * 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key       an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		// throw new RuntimeException("method not implemented");
		String encrypted = "";
		//If the text contains invalid error, print the message for in stead of encryption
		if (!stringInBounds(plainText)) {
			encrypted = "Text Contains Invalid Character";
		} else {
			
			/*
				if the provided key is bigger than the UPPER_BOUND value, 
				decrease by subtracting the RANGE value from it until it
				become less or equal to UPPER_BOUND
			 */
			while (key > UPPER_BOUND) {
				key -= RANGE;
			}
			
			/*
			 * Loop though the text string and for each character add the ASCII code to it and
			 * add the new character to the encrypted text. if the addition become out of bound,
			 * decrease it by RANGE unitl become less than the UPPER_BOUND
			 */
			for (int i = 0; i < plainText.length(); i++) {
				char l = plainText.charAt(i);
				int code = (l + key);
				while (code > UPPER_BOUND) {
					code -= RANGE;
				}
				char e = (char) code;
				encrypted += e;
			}

		}
		return encrypted;
	}

	/**
	 * Encrypts a string according the Bellaso Cipher. Each character in plainText
	 * is offset according to the ASCII value of the corresponding character in
	 * bellasoStr, which is repeated to correspond to the length of plainText
	 * 
	 * @param plainText  an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character
	 *                   by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		// throw new RuntimeException("method not implemented");
		String encrypted = "";
		//Validation message if the text provided has invalid character
		if (!stringInBounds(plainText)) {
			encrypted = "Text Contains Invalid Character";
		} else {
			//validation text if the provided key has invalid character
			if (!stringInBounds(bellasoStr)) {
				encrypted = "Key string contains Invalid Character";
			}

			else {
				/*
				 * if the length of the provided key is less than the provided text,
				 * keep adding characters to the end of key, by getting characters from beginning
				 * until the length become as as the length of provided text.
				 */
				if (bellasoStr.length() < plainText.length()) {
					int fill = (plainText.length() - bellasoStr.length());
					for (int i = 0; i < fill; i++) {
						char l = bellasoStr.charAt(i);
						bellasoStr += l;
					}
				}
				/*
				 * Loop though the text characters and add the ASCII code f the key character to it for the same index
				 * if the addition become out of bound, decrease it by RANGE unitl become less than the UPPER_BOUN
				 */
				for (int i = 0; i < plainText.length(); i++) {
					int code = (bellasoStr.charAt(i) + plainText.charAt(i));
					while (code > UPPER_BOUND) {
						code -= RANGE;
					}
					char e = (char) code;
					encrypted += e;
				}
			}
		}
		return encrypted;
	}

	/**
	 * Decrypts a string according to the Caesar Cipher. The integer key specifies
	 * an offset and each character in encryptedText is replaced by the character
	 * \"offset\" characters before it. This is the inverse of the encryptCaesar
	 * method.
	 * 
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key           an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		// throw new RuntimeException("method not implemented");
		while (key > UPPER_BOUND) {
			key -= RANGE;
		}
		String decrypted = "";
		for (int i = 0; i < encryptedText.length(); i++) {
			char l = encryptedText.charAt(i);
			int code = (l - key);
			while (code < LOWER_BOUND) {
				code += RANGE;
			}
			char e = (char) code;
			decrypted += e;

		}

		return decrypted;
	}

	/**
	 * Decrypts a string according the Bellaso Cipher. Each character in
	 * encryptedText is replaced by the character corresponding to the character in
	 * bellasoStr, which is repeated to correspond to the length of plainText. This
	 * is the inverse of the encryptBellaso method.
	 * 
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr    an uppercase string that specifies the offsets,
	 *                      character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		// throw new RuntimeException("method not implemented");
		String decrypted = "";
		if (bellasoStr.length() < encryptedText.length()) {
			int fill = (encryptedText.length() - bellasoStr.length());
			for (int i = 0; i < fill; i++) {
				char l = bellasoStr.charAt(i);
				bellasoStr += l;
			}
		}
		for (int i = 0; i < encryptedText.length(); i++) {
			int code = (encryptedText.charAt(i) - bellasoStr.charAt(i));
			while (code < LOWER_BOUND) {
				code += RANGE;
			}
			char e = (char) code;
			decrypted += e;
		}

		return decrypted;
	}

}
