package Basic_Maths;

import java.util.Scanner;

public class CountDigits2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int num = sc.nextInt();

        int count = (int)(Math.log10(num)+1);

        System.out.println("The number of digits is : "+count);
    }
}
