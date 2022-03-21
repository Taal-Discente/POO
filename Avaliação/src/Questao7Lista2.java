import java.util.Random;

public class Questao7Lista2 {
	public static void main(String[] args) {
		
		int maior = 0, menor = 101;
		
		Random rdm = new Random();
		
		int[] lista = new int[100];
		
		for(int i = 0; i < 100; i++) {
			lista[i] = rdm.nextInt(100);
		}
		
		for(int j = 0; j < 100; j++) {
			if(lista[j]>maior)
				maior = lista[j];
			if(lista[j]<menor)
				menor = lista[j];
		}
		
		System.out.printf("O maior número: %d \nO menor número: %d", maior,menor);
		
	} //Main

} //Class
