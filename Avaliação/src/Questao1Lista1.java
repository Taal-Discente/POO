import java.util.Scanner;

public class Questao1Lista1 {
	public static void main(String[] args) {
		
	
		int inteiro;
		long longo;
		float flutuante;
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Informar um inteiro: ");
		inteiro = scnr.nextInt();
		
		System.out.println("Informar um long: ");
		longo = scnr.nextLong();
		
		System.out.println("Informar um flutuante: ");
		flutuante = scnr.nextFloat();
		
		
		System.out.printf("O número inteiro, long e float obtidos foram, respectivamente %d , %d e %.2f", inteiro, longo, flutuante);
			
		scnr.close();
	} //Main

} //Class
