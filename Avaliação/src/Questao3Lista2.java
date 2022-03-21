import java.util.Random;

public class Questao3Lista2 {
	public static void main(String[] args) {
		
		Random rdm = new Random();
		
		int[] lista = new int[100];
		
		for(int i = 0; i < 100; i++) {
			lista[i] = rdm.nextInt(1000);
		}
		
		for(int j = 99; j >= 0; j--) {
			System.out.println(lista[j]);
		}
		
	} //Main

} //Class
