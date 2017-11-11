package aplicacion;

import java.awt.*;

public class EnLinea{

	Tablero tablero;
	Jugador jugador1;
	Jugador jugador2;
	int movimientos;
	int n_lineas;
	
	public EnLinea(){
		tablero = new Tablero(10, 10);
		jugador1 = new Jugador("jugador 1",1,Color.green);
		jugador2 = new Jugador("jugador 2",2,Color.blue);
		movimientos = 0;
	}

	public int ganador(){
		int res = 0;
		if (getTurno()/2 > n_lineas)
			res = tablero.ganador(n_lineas);
		return res;
	}

	public int getTurno(){
		int res = 0;
		if (movimientos%2 == 0)
			res = jugador2.getNumero();
		else if (movimientos%2 != 0)
			res = jugador1.getNumero();
		return res;
	}

	private void turno(){
		movimientos+=1;
	}

	public void setMovimiento(int x, int y, int jugador){
		Color color;
		turno();
		if (jugador == 1)
			color = jugador1.getColorFicha();
		else
			color = jugador2.getColorFicha();
		tablero.setMovimiento(x,y,color);
	}
}