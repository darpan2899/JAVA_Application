import com.google.common.*;
import com.google.common.math.IntMath;

import org.apache.commons.math3.*;

import java.math.BigInteger;
import java.util.*;
public class RSA {

	public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
		
    	
		System.out.println("Enter the value of p(should be a prime number)");
		int p = sc.nextInt();
		
        System.out.println("Enter the value of q(should be a prime number)");
		int q = sc.nextInt();
	

		while(true)
		{
			if(IntMath.isPrime(p))
			{
				break;
			}
			else
			{
				System.out.println("Enter the value of p(should be a prime number)");
				p = sc.nextInt();
			}
		}
		while(true)
		{
			if(IntMath.isPrime(q))
			{
				break;
			}
			else
			{
				System.out.println("Enter the value of q(should be a prime number)");
				q = sc.nextInt();
			}
		}
		while(true)
		{
			if(p!=q)
			{
				break;
			}
			else
			{
				System.out.println("Enter the value of q(should not be equal to p)");
				q = sc.nextInt();
			}
		}
		
		int n = p * q;
		int toshunt = (p-1)*(q-1);
		int e=1;
		
		for(int i=1;i<toshunt;i++)
		{
			if(IntMath.isPrime(i))
			{
				if(IntMath.gcd(toshunt, i)==1)
				{
					e=i;
					break;
				}
			}
		}
		
		BigInteger be = new BigInteger(String.valueOf(e));
		BigInteger bt = new BigInteger(String.valueOf(toshunt));
		BigInteger bn = new BigInteger(String.valueOf(n));
		
		int d = be.modInverse(bt).intValue();
		
		BigInteger bd = new BigInteger(String.valueOf(d));
		
		System.out.println("Public Key = {" + e + "," + n + "}");
		System.out.println("Private Key = {" + d + "," + n + "}");
		
		
		 
			BigInteger M,C;
			System.out.println("Enter the length of plaintext");
			String tp = sc.nextLine();
			String input = sc.nextLine();
			while(true)
			{
				System.out.println("press 1 for encryption\npress 2 for decryption\npress 3 for exit");
				System.out.println("enter your choice");
				int choice = sc.nextInt();
			if(choice==1)
			{
			  
			   M =  new BigInteger(input);
			   C =  M.modPow(be, bn);
			  System.out.println("Length of ciphertext = " + C.toString());
			  input = C.toString();
			}
			else if(choice==2)	
		    {
			   C = new BigInteger(input);
		       M = C.modPow(bd, bn);
		       System.out.println("Length of plaintext = " + M.toString());
		       input = M.toString();
		
			}
			
			else if(choice == 3)
			{
				break;
			}
			else
		    {
			 System.out.print("Wrong input");
		     System.exit(0);
		    }
			 
			
			}
		
	}

}
