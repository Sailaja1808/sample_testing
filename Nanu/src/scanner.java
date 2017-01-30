import java.util.Scanner;

class scanner{
	public static void main (String args[]){
		Scanner d = new Scanner(System.in);
		System.out.println("Enter number of inputs= \n");
		int n=d.nextInt();
		System.out.println("Enter number of inputs=" +n);		
		
		System.out.println("Enter input2=");
		int x=d.nextInt();	
		
		System.out.println( "input2=" +x);
		
		
		
		if (y<=12){
			System.out.println("Water");			
		} else if ( y>12 && n+x<19 ){
				System.out.println("Badam milk");
		}else{
				System.out.println( "Coke");
			}
		 d.close();
		}
	
	}

