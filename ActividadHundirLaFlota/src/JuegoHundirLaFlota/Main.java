package JuegoHundirLaFlota;
import java.util.Scanner;
public class Main {
	public static void main(String[] arg) {
		Juego NuevoJuego = new Juego();
		Scanner sc = new Scanner(System.in);
		System.out.println("Coloque sus barcos:");
		int nBarcos = 0;
		do {
			System.out.println("Coordenadas del Barco:");
			System.out.println("x Inicial:");
			int xi = sc.nextInt();
			System.out.println("y Inicial:");
			int yi = sc.nextInt();
			System.out.println("x Final:");
			int xf = sc.nextInt();
			System.out.println("y Final:");
			int yf = sc.nextInt();
			if(NuevoJuego.colocarBarco(xi, yi, xf, yf)) {
				nBarcos++;
				System.out.println("Barco colocado correctamente.");
			}else {
				System.out.println("Error: No se puede colocar el barco.");
			}
			NuevoJuego.verTablero();
		}while(nBarcos < 5);
	}
}
