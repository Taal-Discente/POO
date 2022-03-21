import java.util.Scanner;

public class Questão2Lista2 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		int[] lista = new int[10];
		
		for(int i=1; i<11; i++) {
			System.out.printf("(%d) Entrada de inteiros: ",i);
			lista[i-1] = scnr.nextInt();
			
		}
		for(int j = 9; j >= 0; j--) {
			System.out.println(lista[j]);
		}
		scnr.close();
	} //Main
} //Class
