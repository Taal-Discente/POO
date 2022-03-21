import java.util.Scanner;

public class Questao5Lista1 {
	
	public static void main(String[] args) {
		
		float number;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Informe o número: ");
		number = input.nextFloat();
		
		if (number%2 == 0) {
			System.out.println("Ele é Par!");
		}else {
			System.out.println("Ele é Ímpar");
		}
		
		input.close();
	} //Main

} //Class
