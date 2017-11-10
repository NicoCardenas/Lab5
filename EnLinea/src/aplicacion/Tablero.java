package aplicacion;

public class Tablero{

	Fichas[][] fichas;
	
	public Tablero(){
		fichas = new Fichas[10][10];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				fichas[i][j] = new Fichas();
			}
		}
	}

	public void refrescar(){
		
	}
}