package caeser;

public class CryptoAlphabet {
    public static final String lettersUpperCase = "ABCDEFGHIKLMNOPRSTUVWXYZ"; // was private become public
    public static final String lettersLowerCase = "abcdefghiklmnoprstuvwxyz";
    public static final String numbers = "0123456789";
   public static final String symbols = ".,?!%#@*&+-=";
   public static final String ukrainianAlphabet  = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ" + "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя" + symbols+ numbers;
    public static final String englishAlphabet = lettersUpperCase + lettersLowerCase + symbols + numbers;

  //  public static final String alphabet = "ABCDEFGHIKLMNOPRSTUVWXYZ" + "abcdefghiklmnoprstuvwxyz"+ "0123456789"+ ".,?!%#@*&+-=" + "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ" + "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
    public static boolean defineLanguage(String text) {
      for (char chars : text.toCharArray()) {
          if (ukrainianAlphabet.indexOf(chars) == -1) {
              return true;
          } else if (englishAlphabet.indexOf(chars) != -1) {
              return false;
          }
      }
      return false;

    }
    public static boolean isUkrainianCharacter(char ch) {
        // Uppercase Ukrainian letters: А-Я, Ґ, Є, І, Ї, Й
        // Lowercase Ukrainian letters: а-я, ґ, є, і, ї, й
        return (ch >= '\u0410' && ch <= '\u044F') || ch == '\u0490' || ch == '\u0491' ||
                ch == '\u0404' || ch == '\u0454' ||
                ch == '\u0406' || ch == '\u0456' ||
                ch == '\u0407' || ch == '\u0457';
    }

    public static boolean isUkrainianString(String str) {
        for (char ch : str.toCharArray()) {
            if (isUkrainianCharacter(ch)) {
                return true;
            }
        }
        return false;
    }
}

