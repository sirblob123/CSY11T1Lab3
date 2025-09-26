import java.util.Scanner;

public class Main {
    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String s) {
        while (s.contains("()")) {
            s = s.replace("()", "");
        }
        return s.isEmpty();
    }

    // 2. reverseInteger
    public static String reverseInteger(int n) {
        return new StringBuilder(String.valueOf(n)).reverse().toString();
    }

    // 3. encryptThis
    public static String encryptThis(String input) {
        String encrypted = "";
        int spaces = 0;
        String spacelocation = "0";
        for (int k=0; k < input.length(); k++) {
            if (input.charAt(k)==' ') {
                spaces++;
                spacelocation += (k+1);
            }
        }
        for (int i=0; i <= spaces; i++) {
            String word = input.substring(spacelocation.charAt(i),spacelocation.charAt(i+1));
            encrypted += encryptWord(word);
            }
        return encrypted;
    }
    
    public static String encryptWord(String word) {
        char first = word.charAt(0);
        int ascii = first;
        if (word.length() == 1) return String.valueOf(ascii);
        if (word.length() == 2) return (ascii + word.substring(1));
        return (ascii + word.charAt(word.length()-1) + word.substring(2, word.length() - 1) + word.charAt(1));
    }


    // 4. decipherThis
    public static String decipherThis(String input) {
        String decrypted = "";
        int spaces = 0;
        String spacelocation = "0";
        for (int k=0; k < input.length(); k++) {
            if (input.charAt(k)==' ') {
                spaces++;
                spacelocation += (k+1);
            }
        }
        for (int i=0; i <= spaces; i++) {
            String word = input.substring(spacelocation.charAt(i),spacelocation.charAt(i+1));
            decrypted += encryptWord(word);
            }
        return decrypted;
    }
    public static String decryptWord(String word) {
        int ascii = 0;
        for (int i=0; i < word.length(); i++) {
            if (Character.isDigit(word.charAt(i))) {
                ascii = ascii*10 + Character.getNumericValue(word.charAt(i));
            } else {
                break;
            }
        }
        char first = (char) ascii;
        if (word.length() == 1) return String.valueOf(first);
        if (word.length() == 2) return (first + word.substring(1));
        return (first + word.charAt(word.length()-1) + word.substring(2, word.length() - 1) + word.charAt(1));
    }
}
