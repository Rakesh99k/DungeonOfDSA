package Basic_Maths;

import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        int count = 0;
        while(num > 0){
            count = count + 1;
            num = num/10;
        }
        System.out.println("The number of digits is : "+count);
    }
}
