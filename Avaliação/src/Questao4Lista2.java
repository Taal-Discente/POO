
import java.util.Random;

public class Questao4Lista2 {
	public static void main(String[] args) {
		
		Random rdm = new Random();
		int verify = 1;
		int[] lista = new int[100];
		
		for(int i = 0; i < 100; i++) {
			lista[i] = rdm.nextInt(100);
		}
		
		for(int i = 0; i < 100; i++) {
			
			for(int j = 2; j < lista[i]; j++) {
				if(lista[i]%j == 0) {
					verify = 0;
					break;
				}//IF
				
			}//FOR2
			
			if(verify == 1) {
				System.out.println(lista[i]);
			}
			verify = 1;
			
		}//FOR1
		
	} //Main

} //Class
