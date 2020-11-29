import java.util.*;
import com.google.common.math.*;
public class diffiehellman {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the value of q(should be a prime number)");
		int q = sc.nextInt();
		
		System.out.println("Enter the value of p(should be primitive root of prime number)");
		int p = sc.nextInt();
		
		System.out.println("Enter the value of private key of A");
		int Xa = sc.nextInt();
		
		System.out.println("Enter the value of private key of B");
		int Xb = sc.nextInt();

		int  Ya =  IntMath.mod(IntMath.pow(p, Xa), q);
		int  Yb =  IntMath.mod(IntMath.pow(p, Xb), q);
		
		System.out.println("public key of A = " + Ya);

		System.out.println("public key of B = " + Yb);
		
		int k1=  IntMath.mod(IntMath.pow(Yb, Xa), q);
		int k2=  IntMath.mod(IntMath.pow(Ya, Xb), q);
		
		System.out.println("public key of network = " + k1);

		System.out.println("public key of network = " + k2);
		
	}

}
