import java.util.Random;
import java.util.Scanner;

public class MatrizPractice {
	
	public static void main(String[] args) {
		
		char input;
		
		Random rdm = new Random();
		Scanner scnr = new Scanner(System.in);
		
		int m1linha = (rdm.nextInt(3))+1;
		int m2linha = (rdm.nextInt(3))+1;
		int m1coluna = (rdm.nextInt(3))+1;
		int m2coluna = (rdm.nextInt(3))+1;
		
		System.out.printf("As matrizes possuem tamanho: %dx%d & %dx%d",m1linha, m1coluna, m2linha, m2coluna);
		
		if(m1linha != m2linha || m1coluna != m2coluna) {
			
			System.out.printf("\nImpossível somar matrizes de dimensões diferentes! Deseja inserir as dimensões manualmente? [Y/N]:");
input = scnr.next().charAt(0);
			
			if(input == 'Y' || input == 'y') {
				int newml1, newmc1, newml2, newmc2;
				
				System.out.println("Primeira Matriz - Linhas: ");
				newml1 = scnr.nextInt();
				System.out.println("Primeira Matriz - Colunas: ");
				newmc1 = scnr.nextInt();
				System.out.println("Segunda Matriz - Linhas: ");
				newml2 = scnr.nextInt();
				System.out.println("Segunda Matriz - Colunas: ");
				newmc2 = scnr.nextInt();
				
				if(newml1 != newmc1 || newml1 != newmc2) {
					System.out.printf("Dimensões ainda distintas, Encerrando o processo.. \n (Processo encerrado)");
					System.exit(0);
				}
				
				int[][] m1 = new int[newml1][newmc1];
				int[][] m2 = new int[newml2][newmc2];
				
				System.out.println("Somando matrizes.. ");
				
				for (int i = 0; i < m1.length; i++) {
					for (int j = 0; j < m2[0].length; j++) {
						m1[i][j] = rdm.nextInt(100);
						m2[i][j] = rdm.nextInt(100);
						System.out.printf("| %03d | ",m1[i][j]+m2[i][j]);
						
						
					}//J
					System.out.println("");
					
				}//I
				
				
			} else if(input == 'N' || input == 'n') {
				System.out.println("Processo encerrado!");
			} else {
				System.out.println("Entrada Inválida, Processo encerrado!");
			}
			
			
			
		}else {
			
			int[][] m1 = new int[m1linha][m1coluna];
			int[][] m2 = new int[m2linha][m2coluna];
			
			System.out.println("Dimensões compatíveis! Somando matrizes...");
			
			for (int i = 0; i < m1.length; i++) {
				for (int j = 0; j < m2[0].length; j++) {
					m1[i][j] = rdm.nextInt(100);
					m2[i][j] = rdm.nextInt(100);
					
					System.out.printf("| %03d | ",m1[i][j]+m2[i][j]);
					
					
				}//J
				System.out.println("");
				
			}//I
			
		}
		
		
		
		
		
		
		
	scnr.close();	
		
	}//MAIN
}//CLASS

