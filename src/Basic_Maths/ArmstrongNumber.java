package Basic_Maths;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        int copy = num;
        int count = (num == 0) ? 1 : (int)(Math.log10(num) + 1);
        int sum = 0;
        int temp = num;
        while (temp > 0) {
            int lastnum = temp % 10;
            sum += Math.pow(lastnum, count);
            temp /= 10;
        }
        if(sum == copy){
            System.out.println("It is Armstrong.");
        }else{
            System.out.println("Not a Armstrong");
        }
    }
}
