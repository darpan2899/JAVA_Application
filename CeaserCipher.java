import java.util.*;
public class CeaserCipher {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		String A="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String B="";
		System.out.print("enter plain text");
		String pt=sc.nextLine();
		pt=pt.toUpperCase();
		String ct="";
		System.out.println("press 1 for int key \n press 2 for char key");
		System.out.println("enter your choice");
		int choice = sc.nextInt();
		int choice1;
		int key=0;
		
		
		
		if(choice==1)
		{
			System.out.print("enter the key");
			key= sc.nextInt();
		}
		else if(choice==2)
		{
			System.out.print("enter the key");
			char alphakey = sc.next().charAt(0);
			alphakey= Character.toUpperCase(alphakey);
			key=A.indexOf(alphakey);
			
			
		}
		else
		{
			System.out.print("Wrong input");
		    System.exit(0);
		}
		
		for(int i=0;i<A.length();i++)
		{
			int j= (i + key) % 26;
			B=B+A.charAt(j);
			
		}
		
		System.out.println("press 1 for encryption\n press 2 for decryption");
		System.out.println("enter your choice");
		choice1 = sc.nextInt();
		
		
		
		
	if(choice1==1)
	{
		
		for(int i=0;i<pt.length();i++)
		{
			if(Character.isLetter(pt.charAt(i)))
			{
				int k = A.indexOf(pt.charAt(i));
				
				ct=ct + B.charAt(k);
				
			}
			else
			{
				ct=ct+ pt.charAt(i);
			}
			System.out.println(ct);
		
		}
		System.out.print(ct);
		
	}
	else if(choice1==2)
	{
		for(int i=0;i<pt.length();i++)
		{
			if(Character.isLetter(pt.charAt(i)))
			{
				int k = B.indexOf(pt.charAt(i));
				
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
