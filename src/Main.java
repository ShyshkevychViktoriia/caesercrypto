import caeser.CaesarCipher;

import java.io.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opNumber; //opNumber - optional mumber
        do {
            System.out.println("Enter an operation (encrypt - 1, or decrypt - 2, bruteForce - 3) "); // get the path of file from user
            String operation = scanner.nextLine();  //read path
            opNumber = Integer.parseInt(operation);

            if (opNumber == 1 || opNumber == 2 || opNumber == 3) {
                break;
            }

            System.out.println("Wrong operation number"); // get the path of file from user
        } while (true);

        System.out.println("Enter the file path: "); // get the path of file from user
        String filePath = scanner.nextLine();  //read path

        int key;

        if (opNumber == 1) {
            System.out.println("Enter the key value for Caesercrypt: "); // get a key from user (0-35) of dont know nummer
            key = scanner.nextInt();
            try {
                String text = FileService.readFile(filePath);
                String encodedText = CaesarCipher.encode(text, key);
                System.out.println(encodedText);
                String newPathFile = filePath + CaesarCipher.ENCRYPTED;
                FileService.createFile(newPathFile);
                FileService.writeFile(newPathFile, encodedText);
                System.out.println("Encrypted");
            } catch (IOException e) {
                System.out.println("Error file reading");
                System.out.println(e.getMessage());
            }
        } else if (opNumber == 2) {
            System.out.println("Enter the key value for Caesercrypt: "); // get a key from user (0-35) of dont know nummer
            key = scanner.nextInt();
            try {
                String text = FileService.readFile(filePath);
                String decodedText = CaesarCipher.decode(text, key);
                System.out.println(decodedText);
                String newPathFile = filePath + CaesarCipher.DECRYPTED;
                FileService.createFile(newPathFile);
                FileService.writeFile(newPathFile, decodedText);
                System.out.println("Decrypted");
            } catch (IOException e) {
                System.out.println("Error file reading");
                System.out.println(e.getMessage());
            }
        } if (3 == opNumber) {
            try {
                String text = FileService.readFile(filePath);
                String bruteForcetext = CaesarCipher.bruteForce(text);
                System.out.println(bruteForcetext);
                String newPathFile = filePath + CaesarCipher.BRUTE_FORCED;
                FileService.createFile(newPathFile);
                FileService.writeFile(newPathFile, bruteForcetext);
                System.out.println("BRUTE_FORCED");
            } catch (IOException e) {
                System.out.println("Error file reading");
                System.out.println(e.getMessage());
            }
        }
    }
}
