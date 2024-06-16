import caeser.CaesarCipher;
import caeser.CryptoAlphabet;

import java.io.*;
import java.util.Scanner;



import static java.awt.SystemColor.text;


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
        String text = null;
        try {
            text = FileService.readFile(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        boolean isUkr = CryptoAlphabet.isUkrainianString(text);
        String alphabet =  CryptoAlphabet.englishAlphabet;
        if (isUkr) {
            System.out.println("is Ukrainian alphabet");
            alphabet = CryptoAlphabet.ukrainianAlphabet;
        } else {
            System.out.println(" is English alphabet");
        }
        if (opNumber == 1) {
            System.out.println("Enter the key value for Caesercrypt: "); // get a key from user (0-35) of dont know nummer
            key = scanner.nextInt();
            try {
                String encodedText = CaesarCipher.encode(text, key,alphabet);
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
                String decodedText = CaesarCipher.decode(text, key, alphabet);
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
                String bruteForcetext = CaesarCipher.bruteForce(text,alphabet);
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
