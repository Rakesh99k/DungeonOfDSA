package Basic_Maths;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        int copy = num;
        int lastnum;
        int rev = 0;
        while(num>0) {
            lastnum = num % 10;
            rev = (rev * 10) + lastnum;
            num = num/10;
        }
       if(rev == copy){
           System.out.println("It is Palindrome.");
       }else{
           System.out.println("Not a Palindrome");
       }
    }
}
