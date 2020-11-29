import org.apache.commons.math3.linear.*;
import java.math.*;
import java.util.*;
public class Hill {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		
		System.out.print("enter the size of square matrix(2 or 3 or 4 or 5)");
		int size=sc.nextInt();
		if(size==2||size==3||size==4||size==5)
		{

			String A="ZABCDEFGHIJKLMNOPQRSTUVWXY";
		
			System.out.print("enter plain text");
			String pass = sc.nextLine();
			String pt=sc.nextLine();
			
			System.out.println(pt);
			pt=pt.toUpperCase();
		    int ptlen=pt.length();
			String ct="";
			System.out.println("press 1 for int key \n press 2 for char key");
			System.out.println("enter your choice");
			int choice = sc.nextInt();
			int choice1;
			int pos[] = new int[ptlen];
			double key[][]=new double[size][size];
			double plaintext[][] =  new double[size][ptlen];
			double ciphertext[][] =  new double[size][ptlen];
			
			int p=0;
			for(int i=0;i<ptlen;i++)
			{
				for(int j=0;j<size;j++)
				 {
					
					if(p>=ptlen)
					{
						
						i=p;
						break;
					}
					else
					{
					 if(Character.isLetter(pt.charAt(p)))
					 {
						plaintext[j][i] = A.indexOf(pt.charAt(p));
					
					 }
					 else
					 { 
						if(pt.charAt(p)==' ')
						{
							pos[p]=p;
						}
						
						plaintext[j][i] = A.indexOf(pt.charAt(p+1));
					 }
					 p++;
					
					}
					
				
				 }
				i=p;
			}
			
			if(choice==1)
			{
				System.out.print("enter the key");
				
				for(int i=0;i<size;i++)
				{
					for(int j=0;j<size;j++)
					{
						key[i][j]=sc.nextDouble();
					}
				}
			}
			else if(choice==2)
			{
				int k=0;
				System.out.print("enter the key of " + size*size + " characters");
				String pass2=sc.nextLine();
				String tempKey=sc.nextLine();
				
				tempKey=tempKey.toUpperCase();
				for(int i=0;i<size;i++)
				{
					for(int j=0;j<size;j++)
					{
						key[i][j]=A.indexOf(tempKey.charAt(k));
						k++;
					}
				}
			
			}
			else
			{
				System.out.print("Wrong input");
			    System.exit(0);
			}
			
			RealMatrix keyMatrix = new Array2DRowRealMatrix(key);
			RealMatrix ptMatrix = new Array2DRowRealMatrix(plaintext);
			RealMatrix ctMatrix = new Array2DRowRealMatrix();
			
			
			System.out.println("press 1 for encryption\n press 2 for decryption");
			System.out.println("enter your choice");
			choice1 = sc.nextInt();
			
			
			System.out.println(ptMatrix.toString());
			System.out.println(keyMatrix.toString());
			
			
			for(int i=0;i<ptlen;i++)
			{
				for(int j=0;j<size;j++)
				{
					
					System.out.println(plaintext[j][i]);
				
				}
			}
			
			
			
		 if(choice1==1)
		 {
			ctMatrix = keyMatrix.multiply(ptMatrix);
			System.out.println(ctMatrix.toString());
			
		
			for(int i=0;i<ptlen;i++)
			{
				for(int j=0;j<size;j++)
				{
					
					if(ctMatrix.getColumnVector(i).getL1Norm()!=0)
					{
						
							ct=ct + A.charAt((int)(ctMatrix.getEntry(j,i)% 26));
						
						
					}
					
					
				}
			}
			
			System.out.print(ct);
			
		 }
		 else if(choice1==2)
		 {
			 RealMatrix keyMatrixinv  = MatrixUtils.inverse(keyMatrix);
			
			 
				
			 System.out.println(keyMatrixinv.toString());
				double determinant = (new LUDecomposition(keyMatrix)).getDeterminant();
				System.out.println(determinant);
				BigInteger bigint1 = new BigInteger(String.valueOf(Math.round(determinant)));
				BigInteger bigint2 = new BigInteger("26");
				BigInteger modinv = bigint1.modInverse(bigint2);
				double modinverse = modinv.doubleValue();
	
				for(int i=0;i<size;i++)
				{
					for(int j=0;j<size;j++)
					{
						
						double temp=keyMatrixinv.getEntry(i, j);
						temp = temp* determinant;
						
						temp= temp % 26;
							if(temp<0)
							{
								temp=temp+26;
							}
							temp= temp * modinverse;
							
							keyMatrixinv.setEntry(i, j, temp);
						
						
					}
				}
				
				
				ctMatrix = keyMatrixinv.multiply(ptMatrix);
				System.out.println(ctMatrix.toString());
				System.out.println(keyMatrixinv.toString());
				for(int i=0;i<ptlen;i++)
				{
					for(int j=0;j<size;j++)
					{
						if(ctMatrix.getColumnVector(i).getL1Norm()!=0)
						{
							int t=(int)Math.round(ctMatrix.getEntry(j,i)%26);
							System.out.println(t);
							
							if(t<26)
							{
							ct=ct + A.charAt(t);
							}
						}
						
					}
				}
				
				
				
				System.out.print(ct);
				
			 
		 }
		 else
			{
				System.out.print("Wrong input");
			    System.exit(0);
			}
		}
		else
		{
			System.out.print("Wrong input");
		    System.exit(0);
		}
		
		
		

	}

}
