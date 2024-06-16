package caeser;

public class CaesarCipher {
    public static String ENCRYPTED = "[ENCRYPTED]";
    public static String DECRYPTED = "[DECRYPTED]";
    public static String BRUTE_FORCED = "[BRUTE_FORCED]";

    public static String encode(String text, int key, String alphabet) {
        StringBuilder sb = new StringBuilder();
        for (char chars : text.toCharArray()) {
            int index = alphabet.indexOf(Character.toUpperCase(chars));
            if (index != -1) {
                int newIndex = (index + key) % alphabet.length();
                sb.append(alphabet.charAt(newIndex));
            } else {
                sb.append(chars); // chars!!!! in code is letters, symbols and numbers.
            }
        }
        return sb.toString();
    }

    public static String decode(String text, int key, String alphabet) {
        return encode(text, alphabet.length() - (key % alphabet.length()), alphabet); // if  length of key more than alphabet - devide.
    }
    public static String bruteForce (String text, String alphabet) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alphabet.length(); i++) {
            sb.append(decode(String.valueOf(text), i, alphabet)).append("\n");
        }
        return sb.toString();
    }
}
