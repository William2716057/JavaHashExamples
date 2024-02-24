import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

//SHA-256 class
public class HashingExample {
    public static String hashSHA256(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(input.getBytes());
        return bytesToHex(hash);
    }
//SHA-512
    public static String hashSHA512(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-512");
        byte[] hash = digest.digest(input.getBytes());
        return bytesToHex(hash);
    }

//MD5 class
    public static String hashMD5(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        byte[] hash = digest.digest(input.getBytes());
        return bytesToHex(hash);
    }

  public static void main(String[] args) throws NoSuchAlgorithmException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String input = scanner.nextLine();
        scanner.close();

//SHA-256
String hashedSHA256 = hashSHA256(input);
System.out.println("SHA-256: " + hashedSHA256);

// SHA-512
String hashedSHA512 = hashSHA512(input);
System.out.println("SHA-512: " + hashedSHA512);

//MD5
String hashedMD5 = hashMD5(input);
        System.out.println("MD5: " + hashedMD5);
}

 private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
