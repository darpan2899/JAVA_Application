
import java.util.Scanner;
import com.google.common.primitives.Chars;
public class PlaayFairCipher {

	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		
		String A="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String B=A;
		System.out.print("enter plain text");
		String pt=sc.nextLine();
		pt=pt.toUpperCase();
		String ct="";
		int choice;
		char  mat[][]=new char[5][5];
        
		
		
			System.out.print("enter the key");
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
		    key=key.replace("J","");
		    System.out.println(key);
		    
		    int k1=0;
		    for(int i=0;i<5;i++)
		    {
		          key.getChars(k1, k1+5, mat[i], 0);
		          k1=k1+5;
		    }
		    
		    for(int i=0;i<5;i++)
		    {
		    	System.out.println();
		    	 for(int j=0;j<5;j++)
				    {
				        System.out.print(mat[i][j]);  
				    } 
		    }
		    
		    
		    System.out.println("press 1 for encryption\n press 2 for decryption");
			System.out.println("enter your choice");
			choice = sc.nextInt();
			pt=pt.replace(" ", "");
			pt=pt.replace("J", "I");
			
			
			if(choice==1)
			{
				
				for(int i=0;i<pt.length();i++)
				{
					

					if(Character.isDigit(pt.charAt(i))||!Character.isLetter(pt.charAt(i)))
					{
						pt=pt.replace(pt.charAt(i),' ');
						pt=pt.replace(" ","");
					}
				
				}
				System.out.println(pt);
			for(int i=0;i<pt.length();i++)
			{
			
					if(i==pt.length()-1 && pt.length()%2!=0)
					{
						pt=pt+"X";
						break;
					}
					else
					{
					  if(pt.charAt(i)==pt.charAt(i+1))
					   {
						pt=pt.substring(0,i+1) + "X" + pt.substring(i+1,pt.length());
					
						}
					
					  i++;
					}
			
			}
			
			
			
			System.out.println(pt);
			
			int noofequalparts=pt.length()/2;
			
			String ptp[]=new String[noofequalparts];
			
			for(int i=0,j=0;i<noofequalparts;i++,j=j+2)
			{
				ptp[i]=pt.substring(j,j+2);
				System.out.println(ptp[i]);
			}
			for(int i=0;i<noofequalparts;i++)
			{
				int r1=0,c1=0,r2=0,c2=0;
				for(int j=0;j<5;j++)
				{
					r1=j;
					c1=Chars.indexOf(mat[j],ptp[i].charAt(0));
					
					if(c1!=-1)
					{
						break;
					}
				}
				
				for(int j=0;j<5;j++)
				{
					r2=j;
					c2=Chars.indexOf(mat[j],ptp[i].charAt(1));
					
					if(c2!=-1)
					{
						break;
					}
				}
				
				
				
				if(r1==r2)
				{
					ct=ct+mat[r1][(c1+1)%5] + mat[r1][(c2+1)%5] + " ";
				}
				else if(c1==c2)
				{
					ct=ct+mat[(r1+1)%5][c1] + mat[(r2+1)%5][c2] + " ";
				}
				else
				{
					ct=ct + mat[r1][c2] + mat[r2][c1] + " ";
				}
			}
			
			System.out.print(ct);
			
			
			
		}
		else if(choice==2)	
		{
			for(int i=0;i<pt.length();i++)
			{
				if(Character.isDigit(pt.charAt(i))||!Character.isLetter(pt.charAt(i)))
				{
					pt=pt.replace(pt.charAt(i),' ');
					pt=pt.replace(" ","");
				}
				
				System.out.println(pt);
			
			}
            int noofequalparts=pt.length()/2;
			
			String ptp[]=new String[noofequalparts];
			
			for(int i=0,j=0;i<noofequalparts;i++,j=j+2)
			{
				ptp[i]=pt.substring(j,j+2);
				System.out.println(ptp[i]);
			}
			for(int i=0;i<noofequalparts;i++)
			{
				int r1=0,c1=0,r2=0,c2=0;
				for(int j=0;j<5;j++)
				{
					r1=j;
					c1=Chars.indexOf(mat[j],ptp[i].charAt(0));
					
					if(c1!=-1)
					{
						break;
					}
				}
				
				for(int j=0;j<5;j++)
				{
					r2=j;
					c2=Chars.indexOf(mat[j],ptp[i].charAt(1));
					
					if(c2!=-1)
					{
						break;
					}
				}
				
				
				
				if(r1==r2)
				{
					ct=ct+mat[r1][(c1-1)%5] + mat[r1][(c2-1)%5] + " ";
				}
				else if(c1==c2)
				{
					ct=ct+mat[(r1-1)%5][c1] + mat[(r2-1)%5][c2] + " ";
				}
				else
				{
					ct=ct + mat[r1][c2] + mat[r2][c1] + " ";
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

}
