package test;

import java.util.Scanner;

public class sysin {

	public static void main(String[] args) {
		 Scanner scan = new Scanner(System.in);
	        
         int i = scan.nextInt();
         scan.nextLine();
        double d = scan.nextDouble();
        scan.nextLine();
        String s1 = scan.nextLine();
        
        scan.close();
        

        // Write your code here.

        System.out.println("String: " + s1);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
        
        
        /* input is 
         * 	42
			3.1415
			Welcome to HackerRank's Java tutorials!
         * 
         * 
         * Expected Output
                String: Welcome to HackerRank's Java tutorials!
                Double: 3.1415
                Int: 42
         */
        

	}

}
