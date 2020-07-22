package com.casestudy.tests;

import java.util.Scanner;

public class PONumber {

		   public static void reverseMethod(int number) {
		       if (number < 10) {
			   System.out.println(number);
			   return;
		       }
		       else {
		           System.out.print(number % 10);
		           //Method is calling itself: recursion
		           reverseMethod(number/10);
		       }
		   }
		   public static void main(String args[])
		   {
			int num=0;
			System.out.println("Input your number and press enter: ");
			Scanner in = new Scanner(System.in);
			num = in.nextInt();
			System.out.print("Reverse of the input number is:");
			reverseMethod(num);
			num = num + 1;
			reverseMethod(num);
			System.out.println();
//			   or
////			   int num = 97654321;
//			   int num = 12345678;
//			   num = num + 10000000;
//			   System.out.println(num);
		   }
	}


