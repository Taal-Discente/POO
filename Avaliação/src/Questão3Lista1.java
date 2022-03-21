import java.util.Scanner;

public class Questão3Lista1 {
	public static void main(String[] args) {
		
		float baseMaior;
		float baseMenor;
		float altura;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Informe a medida da base maior do trapézio em cm: ");
		baseMaior = input.nextFloat();
		
		System.out.println("Informe a medida da base menor do trapézio em cm: ");
		baseMenor = input.nextFloat();
		
		System.out.println("Informe a altura do trapézio em cm; ");
		altura = input.nextFloat();
		
		
		float area = ((baseMaior + baseMenor) * altura) / 2;
		
		System.out.printf("A área do trapézio mede %.2f cm²", area);
		
		
		input.close();
	} //Main

} //Class
