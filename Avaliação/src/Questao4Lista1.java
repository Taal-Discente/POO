import java.util.Scanner;

public class Questao4Lista1 {
	
	public static void main(String[] args) {
		
		float n1, n2, maior;
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Informe o primeiro número: ");
		n1 = scnr.nextFloat();
		
		System.out.println("Informe o segundo número: ");
		n2 = scnr.nextFloat();
		
		if(n1>n2) {
			maior = n1;
		}else if(n2>n1) {
			maior = n2;
		}else {
			maior = 0;
		}
		
		if(maior!=0) {
			System.out.printf("Dentre esses o maior é: %.2f", maior);
		}else {
			System.out.println("Ambos são iguais!");
		}
		
		scnr.close();
	} //Main

} //Class
