import java.util.Random;

public class Questao6Lista2 {
	public static void main(String[] args) {
		
		Random rdm = new Random();
		
		int[] lista = new int[100];
		
		for(int i = 0; i < 100; i++) {
			lista[i] = rdm.nextInt(100);
		}
		
		for(int j = 0; j < 100; j++) {
			if(lista[j]%2 == 0) {
				System.out.println(lista[j]);
			}
		}
		
	} //Main

} //Class
