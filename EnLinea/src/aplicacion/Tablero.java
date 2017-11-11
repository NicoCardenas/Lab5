package aplicacion;

import java.awt.*;

public class Tablero{

	Fichas[][] fichas;
	
	public Tablero(int filas, int columnas){
		fichas = new Fichas[filas][columnas];
		for (int i = 0; i < fichas.length; i++) {
			for (int j = 0; j < fichas[0].length; j++) {
				fichas[i][j] = new Fichas();
			}
		}
	}

	public void setMovimiento(int x, int y, Color color){
		fichas[x][y].setColor(color);
	}

	public int ganador(int n){
		int res = 0;
		for (int i = 0; i < fichas.length; i++) {
			for (int j = 0; j < fichas[0].length; j++) {
				if (LineaR( i, j, 0) >= n)
					res = LineaR( i, j, 0);
				else if (LineaD( i, j, 0) >= n)
					res = LineaD( i, j, 0);
				else if (LineaL( i, j, 0) >= n)
					res = LineaL( i, j, 0);
				else if (LineaU( i, j, 0) >= n)
					res = LineaU( i, j, 0);
			}
		}

		return res;
	}

	private int LineaR(int x, int y, int count){
		int res = count;
		if (y+1 < fichas[0].length && fichas[x][y].getNumJugador() == fichas[x][y+1].getNumJugador())
			LineaR(x, y+1, count+1);
		return res;
	}

	private int LineaD(int x, int y, int count){
		int res = count;
		if (x+1 < fichas.length && fichas[x][y].getNumJugador() == fichas[x+1][y].getNumJugador())
			LineaD(x+1, y, count+1);
		return res;
	}

	private int LineaL(int x, int y, int count){
		int res = count;
		if (0 < y-1 && fichas[x][y].getNumJugador() == fichas[x][y-1].getNumJugador())
			LineaL(x, y-1, count+1);
		return res;
	}

	private int LineaU(int x, int y, int count){
		int res = count;
		if (0 < x-1 && fichas[x][y].getNumJugador() == fichas[x-1][y].getNumJugador())
			LineaU(x-1, y, count+1);
		return res;
	}
}