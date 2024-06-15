package caeser;

public class CaesarCipher {
    public static String ENCRYPTED = "[ENCRYPTED]";
    public static String DECRYPTED = "[DECRYPTED]";
    public static String BRUTE_FORCED = "[BRUTE_FORCED]";

    public static String encode(String text, int key) {
        StringBuilder sb = new StringBuilder();
        for (char chars : text.toCharArray()) {
            int index = CryptoAlphabet.alphabet.indexOf(Character.toUpperCase(chars));
            if (index != -1) {
                int newIndex = (index + key) % CryptoAlphabet.alphabet.length();
                sb.append(CryptoAlphabet.alphabet.charAt(newIndex));
            } else {
                sb.append(chars); // chars!!!! in code is letters, symbols and numbers.
            }
        }
        return sb.toString();
    }

    public static String decode(String text, int key) {
        return encode(text, CryptoAlphabet.alphabet.length() - (key % CryptoAlphabet.alphabet.length())); // if  length of key more than alphabet - devide.
    }
    public static String bruteForce (String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CryptoAlphabet.alphabet.length(); i++) {
            sb.append(decode(String.valueOf(text), i)).append("\n");
        }
        return sb.toString();
    }
}
