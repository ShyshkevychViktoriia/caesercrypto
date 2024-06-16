import caeser.CryptoAlphabet;

import java.io.*;

//import static caeser.CryptoAlphabet.alphabet;
//import static caeser.CryptoAlphabet.ukrainian;

public class FileService {

    public static void createFile(String path) throws IOException {
        File file = new File(path); // new file which be changed with new information
    }

    public static void writeFile(String path, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(content);
        }
    }

    public static String readFile(String path) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append(System.lineSeparator());
            }
        }
        return contentBuilder.toString().trim();
    }

}

