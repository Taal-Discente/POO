
public class Question3Bonus {

	public static void main(String[] args) {
		
		int linha, cl, cc;
		int[][] a = {{3,5},{4,6},{5,1}};
		int[][] b = {{10,3,0},{1,5,21}};
		
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
		
		//VERIFICAÇÃO/MULTIPLICAÇÃO
		if(a[0].length == b.length) {
			System.out.printf("As matrizes possuem tamanho compatível para multiplicar! \n\n");
			
			linha = a[0].length;
			cl = a.length;
			cc = b[0].length;
			
			//MATRIZ RESULTADO
			int[][] c = new int[cl][cc];
			int result = 0;
			
			for (int i = 0; i < cl; i++) {
				for (int j = 0; j < cc; j++) {	
					
					for (int r = 0; r < linha; r++) { 
						result += a[i][r] * b[r][j];
					}
					
					c[i][j] = result;
					result = 0;
					
					System.out.printf("| %03d |", c[i][j]);
				}
				
				System.out.println("");
			}//MULTIPLICAÇÃO
			
		}else {
			System.out.println("As matrizes possuem tamanho incompatível para soma!");
			System.exit(0);
			
		}//TAMANHO
		
	}//MAIN
	
}//CLASS

/*

c[0][0] = a[0][0]* b[0][0] + a[0][1]* b[1][0];        
c[0][1] = a[0][0]* b[0][1] + a[0][1]* b[1][1];   	 
c[0][2] = a[0][0]* b[0][2] + a[0][1]* b[1][2];       

c[1][0] = a[1][0]* b[0][0] + a[1][1]* b[1][0];		 
c[1][1] = a[1][0]* b[0][1] + a[1][1]* b[1][1];        
c[1][2] = a[1][0]* b[0][2] + a[1][1]* b[1][2];        

c[2][0] = a[2][0]* b[0][0] + a[2][1]* b[1][0];       
c[2][1] = a[2][0]* b[0][1] + a[2][1]* b[1][1];        
c[2][2] = a[2][0]* b[0][2] + a[2][1]* b[1][2];      

*/
