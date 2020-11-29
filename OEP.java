import java.security.*;
import java.math.*;
import java.util.*;
public class OEP {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int ch;
		
		System.out.println("1.SHA-1\n2.SHA-224\n3.SHA-256\n4.SHA-384\n5.SHA-512\n");
		System.out.println("Enter the choice for SHA");
		ch=sc.nextInt();
		
		System.out.println("Enter the string for which you want to perform");
		String gap = sc.nextLine();
		String message = sc.nextLine();
		
		switch(ch)
		{
			case 1:
			{
				try {
					MessageDigest md = MessageDigest.getInstance("SHA-1");
					
					byte messageDigest[] = md.digest(message.getBytes());
					
					BigInteger bigInteger = new BigInteger(1,messageDigest);
					
					String  hashtext = bigInteger.toString(16);
					
					while(hashtext.length() < 32)
					{
						hashtext = "0" + hashtext;
					}
					
					System.out.print("Hashtext=" + hashtext);
				} catch (NoSuchAlgorithmException e) {
				 
					e.printStackTrace();
				}
			}
			break;
			case 2:
			{
				try {
					MessageDigest md = MessageDigest.getInstance("SHA-224");
					
					byte messageDigest[] = md.digest(message.getBytes());
					
					BigInteger bigInteger = new BigInteger(1,messageDigest);
					
					String  hashtext = bigInteger.toString(16);
					
					while(hashtext.length() < 32)
					{
						hashtext = "0" + hashtext;
					}
					
					System.out.print("Hashtext=" + hashtext);
				} catch (NoSuchAlgorithmException e) {
				 
					e.printStackTrace();
				}
			}
			break;
			case 3:
			{
				try {
					MessageDigest md = MessageDigest.getInstance("SHA-256");
					
					byte messageDigest[] = md.digest(message.getBytes());
					
					BigInteger bigInteger = new BigInteger(1,messageDigest);
					
					String  hashtext = bigInteger.toString(16);
					
					while(hashtext.length() < 32)
					{
						hashtext = "0" + hashtext;
					}
					
					System.out.print("Hashtext=" + hashtext);
				} catch (NoSuchAlgorithmException e) {
				 
					e.printStackTrace();
				}
			}
			break;
			case 4:
			{
				try 
				{
					MessageDigest md = MessageDigest.getInstance("SHA-384");
					
					byte messageDigest[] = md.digest(message.getBytes());
					
					BigInteger bigInteger = new BigInteger(1,messageDigest);
					
					String  hashtext = bigInteger.toString(16);
					
					while(hashtext.length() < 64)
					{
						hashtext = "0" + hashtext;
					}
					
					System.out.print("Hashtext=" + hashtext);
				} 
				catch (NoSuchAlgorithmException e) {
				 
					e.printStackTrace();
				}
			}
			break;
			case 5:
			{
				try 
				{
					MessageDigest md = MessageDigest.getInstance("SHA-512");
					
					byte messageDigest[] = md.digest(message.getBytes());
					
					BigInteger bigInteger = new BigInteger(1,messageDigest);
					
					String  hashtext = bigInteger.toString(16);
					
					while(hashtext.length() < 64)
					{
						hashtext = "0" + hashtext;
					}
					
					System.out.print("Hashtext=" + hashtext);
				} 
				catch (NoSuchAlgorithmException e) {
				 
					e.printStackTrace();
				}
			}
			break;
			default:
			{
				System.out.println("Wrong choice");
			}
			
		}
		
		
		
		

	}

}
