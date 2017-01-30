import java.util.Scanner;

public class armstrongNumber {

   public static boolean isArmstrong(int input) {
       String inputAsString = input + "";
       int numberOfDigits = inputAsString.length();
       int copyOfInput = input;
       int sum = 0;
       while (copyOfInput != 0) {
           int lastDigit = copyOfInput % 10;
           sum = sum + (int) Math.pow(lastDigit, numberOfDigits);
           copyOfInput = copyOfInput / 10;
       }
       if (sum == input) {
           return true;
       } else {
           return false;
       }
   }

   public static void printAll(int start, int end) {
       System.out.println("List of Armstrong Numbers between " + start + " and " + end + " :");
       for (int i = start; i <= end; i++) {
           if (isArmstrong(i)) {
               System.out.println(i);
           }
       }
   }

   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter start number: ");
       int start = scanner.nextInt();
       System.out.print("Enter end number: ");
       int end = scanner.nextInt();
       printAll(start, end);
   }
}