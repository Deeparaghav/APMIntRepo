package com.casestudy.tests;

import java.util.Scanner;

public class PrimeNumberUptoGivenNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int n,b,i,m;
			System.out.println("Enter a maximum number till which the prime numbers are to be generated");
			Scanner in = new Scanner(System.in); 
			int a = in.nextInt(); 	     
			primeFactorsTo(a);
		}
		
	private static void primeFactorsTo(int m) 
	{
		// TODO Auto-generated method stub
		if(m==0||m==1)
		{  
			   System.out.println(m+" is not prime number");      
		 }
		else
		{ 
		System.out.println("Prime numbers are: ");
		for(int b=2;b<=m;b++)
		{
								
			int i=2;
			while(b%i!=0)
			{
				i++;
			}
	  	 	if(i==b)
	  	 	{
	  	 		System.out.println("   "+b) ;
	  	 	}
			
	  }
			  }
	 	return;
	}
}

