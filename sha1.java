import java.security.*;
import java.math.*;
import java.util.*;
public class sha1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the string for which you want to perform SHA-1");
		String message = sc.nextLine();
		
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

}
