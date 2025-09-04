package Basic_Maths;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        System.out.println("Original number: "+ num);
        int lastnum;
        int rev = 0;
        while(num>0) {
            lastnum = num % 10;
            rev = (rev * 10) + lastnum;
            num = num/10;
        }
        System.out.println("Reversed number: "+rev);
    }
}
