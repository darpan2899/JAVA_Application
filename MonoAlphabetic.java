
import java.util.Scanner;
public class MonoAlphabetic {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		String Asc="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Desc="ZYXWVUTSRQPONMLKJIHGFEDCBA";
		String A=Asc;
		String B=A;
		System.out.print("enter plain text");
		String pt=sc.nextLine();
		pt=pt.toUpperCase();
		String ct="";
		int choice,choice1;
		
		
		
		    System.out.println("press 1 for Ascending\npress 2 for Descending");
			System.out.println("enter your choice");
			choice1 = sc.nextInt();
			if(choice1==1)
			{
				B=Asc;
			}
			else if(choice1==2)
			{
				B=Desc;
			}
			else
			{
				System.out.print("Wrong input");
			    System.exit(0);
			}
			
			
		
			System.out.print("enter the key");
			String gap = sc.nextLine();
			String key = sc.nextLine();
			key=key.toUpperCase();
			
			
			String temp="";
			for (int i = 0; i < key.length(); i++)
			{
		        if(!temp.contains(String.valueOf(key.charAt(i))))
		        {
		            temp += String.valueOf(key.charAt(i));
		        }
		    }
			
			key=temp;
			
			for(int i=0;i<key.length();i++)
			{
				B=B.replace(key.charAt(i),' ');

				B=B.replace(" ", "");
			}
		    key=key + B;
		    System.out.println(key);
		    
		    System.out.println("press 1 for encryption\npress 2 for decryption");
			System.out.println("enter your choice");
			choice = sc.nextInt();
			
			if(choice==1)
			{
			for(int i=0;i<pt.length();i++)
			{
				if(Character.isLetter(pt.charAt(i)))
				{
					int k = A.indexOf(pt.charAt(i));
					
				
					ct=ct + key.charAt(k);
					
					
				}
				else
				{
					ct=ct+ pt.charAt(i);
				}
				System.out.println(ct);
			
			}
			System.out.print(ct);
		}
		else if(choice==2)	
		{
			for(int i=0;i<pt.length();i++)
			{
				if(Character.isLetter(pt.charAt(i)))
				{
					int k = key.indexOf(pt.charAt(i));
					
				
					ct=ct + A.charAt(k);
					
					
				}
				else
				{
					ct=ct+ pt.charAt(i);
				}
				System.out.println(ct);
			
			}
			System.out.print(ct);	
		}
		else
		{
			System.out.print("Wrong input");
		    System.exit(0);
		}

			
		
	}

}
