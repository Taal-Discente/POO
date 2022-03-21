import java.util.Random;

public class Questao8Lista2 {
	public static void main(String[] args) {
		
		int somatoria = 0;
		
		Random rdm = new Random();
		
		int[] lista = new int[100];
		
		for(int i = 0; i < 100; i++) {
			lista[i] = rdm.nextInt(100);
		}
		
		for(int j = 0; j < 100; j++) {
			somatoria += lista[j];
		}
		
		System.out.printf("A média aritmética de todos os valores: %d", somatoria/100);
		
	} //Main

} //Class
