package JuegoHundirLaFlota;

public class Juego {
	char [][] tablero = new char[12][12];
	
	public Juego() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j]=' ';
			}
		}
	}
	public void verTablero() {
		for (int i = 1; i < 11; i++) {
			
			for (int j = 1; j < 11; j++) {
				System.out.print(tablero[i][j]+" ");
				
			}
			System.out.print("|"+i);
			System.out.print("\n");
		}
		System.out.print("- - - - - - - - - -\n");
		System.out.print("1 2 3 4 5 6 7 8 9 10\n");
	}
	public boolean colocarBarco(int xI, int yI, int xF, int yF) {
		if((dentroDeLimites(xI, yI, xF, yF)==true) && (pisaBarco(xI, yI, xF, yF)==false)&&(barcoCercano(xI, yI, xF, yF)==false)) {
			if(xI == xF) {
				for(int i = yI; i <= yF; i++) {
					tablero[i][xI] = 'B';
				}
				return true;
			}
			if(yI==yF) {
				for(int i = xI; i <= xF; i++) {
					tablero[yI][i] = 'B';
				}
				return true;
			}
		}
		return false;
	}
	public boolean dentroDeLimites(int xI, int yI, int xF, int yF) {
		if((xI >10) || (yI >10) || (xF >10) || (yF >10)) {
			return false;
		}else {
			return true;
		}
	}
	public boolean pisaBarco(int xI, int yI, int xF, int yF) {

		if((tablero[yI][xI] == 'B')||(tablero[yF][xF] == 'B')) {
					return true;
				}
		
		if(xI == xF) {
			for(int i = yI; i <= yF; i++) {
				if(tablero[i][xI] == 'B') {
					return true;
				}
			}
		}
		if(yI==yF) {
			for(int i = xI; i <= xF; i++) {
				if(tablero[yI][i] == 'B') {
					return true;
				}
			}
		}
		return false;
	}
	public boolean barcoCercano(int xI, int yI, int xF, int yF) {
		
		if(xI == xF) {
			for(int i = yI; i <= yF; i++) {
				if((tablero[i][xI+1] == 'B')||(tablero[i][xI-1] == 'B')||(tablero[yI-1][xI] == 'B')||(tablero[yF+1][xI] == 'B')) {
					return true;
				}
			}
		}
		if(yI==yF) {
			for(int i = xI; i <= xF; i++) {
				if((tablero[yI-1][i] == 'B')||(tablero[yI+1][i] == 'B')||(tablero[yI][xI-1] == 'B')||(tablero[yI][xF+1] == 'B')) {
					return true;
				}
			}
		}
		return false;
	}
}
