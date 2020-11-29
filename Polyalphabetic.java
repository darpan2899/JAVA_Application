

import java.util.Scanner;
public class Polyalphabetic {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		String Row="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Col="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String mat[] = new  String[26];
		System.out.print("enter plain text");
		String pt=sc.nextLine();
		pt=pt.toUpperCase();
		pt=pt.replace(" ", "");
		String ct="";
		int choice;
			
			
		
			System.out.print("enter the key");
			String key = sc.nextLine();
			key=key.toUpperCase();
			int keyLen=key.length();
			int ptLen=pt.length();
			int a;
			if(keyLen>ptLen)
			{
				key=key.substring(0, ptLen);
			}
			for(int i=keyLen;i<ptLen;i++)
			{
				a=i % keyLen;
				key=key + key.charAt(a);
			}
			
			System.out.println(key);
			
			
			for(int i=0;i<26;i++)
			{
				mat[i]=Row.substring(i,Row.length()) + Row.substring(0,i);
			}
			
	       while(true)
	       {
		    System.out.println("press 1 for encryption\npress 2 for decryption\npress 3 for exit");
			System.out.println("enter your choice");
			choice = sc.nextInt();
			
			if(choice==1)
			{
			for(int k=0;k<ptLen;k++)
			{
				if(Character.isLetter(pt.charAt(k)))
				{
					 int i= Row.indexOf(pt.charAt(k));
					 int j= Col.indexOf(key.charAt(k));
					 ct=ct + mat[j].charAt(i);
					
				}
				else
				{
					ct=ct+ pt.charAt(k);
				}
			
			}
			System.out.println(ct);
		}
		else if(choice==2)	
		{
			for(int k=0;k<ptLen;k++)
			{
				if(Character.isLetter(pt.charAt(k)))
				{
					 
					 int j= Col.indexOf(key.charAt(k));
					 int i= mat[j].indexOf(pt.charAt(k));
					 ct=ct + Row.charAt(i);
					
				}
				else
				{
					ct=ct+ pt.charAt(k);
				}
			
			}
			System.out.println(ct);
		}
		else
		{
			System.out.print("Wrong input");
		    System.exit(0);
		}
			
			pt=ct;
			ct="";

	 }	
		
	}

}
