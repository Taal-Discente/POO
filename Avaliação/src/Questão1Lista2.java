import java.util.Scanner;

public class Questão1Lista2 {
	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);
		
		
		float nota, somatoria = 0; 	
		for(int i = 1; i < 6; i++) {
			System.out.printf("(%d) Informe a nota: ", i); 
			nota = scnr.nextFloat();
			somatoria += nota;
		}
		
		System.out.printf("A média aritmética das notas informadas corresponde a: %.2f", somatoria/5);
		scnr.close();
	} //Main
} //Class
