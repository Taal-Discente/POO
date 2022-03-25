
public class Question1Bonus {

	public static void main(String[] args) {
		
		int[][] a = {{3,5,7},{4,6,8}};
		int[][] b = {{10,3,0},{1,5,21}};
		int[][] c = new int[a.length][a[0].length];
		
		//EXIBIÇÃO A
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.printf("| %02d |", a[i][j]);
			}
			System.out.println("");
		}
		System.out.printf("\n");
		
		//EXIBIÇÃO B
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				System.out.printf("| %02d |", b[i][j]);
			}
			System.out.println("");
		}
		System.out.printf("\n\n");
		
		//VERIFICAÇÃO/SOMA
		if(a.length == b.length || a[0].length == b[0].length) {
			System.out.printf("As matrizes possuem tamanho compatível para efetuar soma! \n\n");
			for (int i = 0; i < b.length; i++) {
				for (int j = 0; j < b[0].length; j++) {
					c[i][j] = a[i][j] + b[i][j];
					System.out.printf("| %02d |", c[i][j]);
				}
				System.out.println("");
			}
		}else {
			System.out.println("As matrizes possuem tamanho incompatível para soma!");
			System.exit(0);
		}
		
		
		
	}//MAIN
	
}//CLASS
