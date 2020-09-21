import java.util.Random;
import java.util.Scanner;
import java.rmi.activation.*;

/* creates the Matrix ;-) Have Fun!
	please adapt the variable zilelength to the width of your screen
	made by MisterM13 */

class Matrixwriter {
	static boolean ex = true;
	public static Random rand = new Random();
	public static Scanner inp = new Scanner(System.in);
	
	static int  zilelenght = 238;//238 für laptop, 272 für ext.Bildschirm, ca ges.Pixel durch ~12
	static int spl = 1+ 50;
	static int[] matrix = new int[zilelenght];
	static int n = 0;
	static int x = 20;
		/** generiert willkürlich Buchstaben*/
		static char RChar(){
		char ret;
		/* für DNA Text -> rand.nextInt(4) */
		int randChar = rand.nextInt(37);	
		switch (randChar) {
			case 0:
				ret = 'A';
				break;
			case 1:
				ret = 'T';
				break;
			case 2:
				ret = 'C';
				break;
			case 3:
				ret = 'G';
				break;
			case 5:
				ret = 'B';
				break;
			case 6:
				ret = 'E';
				break;
			case 7:
				ret = 'F';
				break;
			case 8:
				ret = 'D';
				break;
			case 9:
				ret = 'H';
				break;
			case 10:
				ret = 'I';
				break;
			case 11:
				ret = 'J';
				break;
			case 12:
				ret = 'K';
				break;
			case 13:
				ret = 'L';
				break;
			case 14:
				ret = 'M';
				break;
			case 15:
				ret = 'N';
				break;
			case 16:
				ret = 'O';
				break;
			case 17:
				ret = 'P';
				break;
			case 18:
				ret = 'Q';
				break;
			case 19:
				ret = 'R';
				break;
			case 20:
				ret = 'S';
				break;
			case 21:
				ret = 'U';
				break;
			case 22:
				ret = 'V';
				break;
			case 23:
				ret = 'W';
				break;
			case 24:
				ret = 'X';
				break;
			case 25:
				ret = 'Y';
				break;
			case 4:
				ret = 'Z';
				break;
			/*case 26:
				ret = ' ';
				break;*/
			case 27:
				ret = '0';
				break;
			case 28:
				ret = '1';
				break;
			case 29:
				ret = '2';
				break;
			case 30:
				ret = '3';
				break;
			case 31:
				ret = '4';
				break;
			case 32:
				ret = '5';
				break;
			case 33:
				ret = '6';
				break;
			case 34:
				ret = '7';
				break;
			case 35:
				ret = '8';
				break;
			case 36:
				ret = '9';
				break;
			default:
			ret = 'e';
				break;
		}
		return ret;
		}
		
/*static void activator(){
	int randact = rand.nextInt(21);
	for (int i = 0; i < zilelenght; i++) {
		if (matrix[i] > 0) {}
		else{switch (randact) {
			case 0:case 1:case 2:case 3:case 4:case 5:case 6:case 7:case 8:case 9:case 10:
				matrix[i] = spaltlength;
				break;
			case 11:case 12:case 13:case 14:case 15:case 16:case 17:case 18:case 19:case 20:
				matrix[i] = 0;
				break;			
			default:
				break;
		}}
	}
}*/
public static void activator(){
	
	int z = rand.nextInt(zilelenght);
	int y = rand.nextInt(5);
	
	if(n%x==0){
		if(matrix[z]==0) {
		matrix[z] =-1;
		}
	if (x>1) {
		x--;
	}
		/*else {
			matrix[z]=y;
		}*/
	if (matrix[z]==-1) {
		matrix[z] =spl;
	}
	}
	
	/*for (int i = 1; i <zilelenght-1; i++) {
		
		
		if (i%2==0) {
			matrix[i] = 11;
		}
		else {
			matrix[i] = 0;
		}
	
}*/
spl = rand.nextInt(20) + 50;
n++;
}

public static void matPrint(){
	StringBuilder bob = new StringBuilder();
	for (int i = 0; i < zilelenght; i++) {
		if(matrix[i] > 0){
			bob.append(RChar());
			matrix[i]= matrix[i]-1;
		}
		else {
			bob.append(" ");
		}
	}
	String end = bob.toString();
	try{
	Thread.sleep(100);
	System.out.println(end);
	}catch (InterruptedException e){};
}

		
	public static void main(String[] args) {
		try{
		Matrixwriter.zilelenght =Integer.parseInt(args[0]);
		}catch(ArrayIndexOutOfBoundsException e){}
		
		while(ex){
			for (int i =0; i<3;i++) {
			//System.out.print(RChar());
			activator();
			matPrint();
			}
			//ex = false;
		}
	}
}