import java.util.Scanner;

public class Questao2Lista1 {
	public static void main(String[] args) {
	
		float altura;
		float peso;
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Informe a altura: ");
		altura = scnr.nextFloat();
		
		System.out.println("Informe o peso: ");
		peso = scnr.nextFloat();
		
		float imc = peso / (altura * altura);
		
		System.out.printf("O IMC do individuo corresponde à: %.2f",imc);
		
		scnr.close();
	} //Main
	
} //Class
