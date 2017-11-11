package aplicacion;

import java.awt.*;

public class Fichas{

	int numJugador;
	Color color;

	public Fichas(){
		this.numJugador = 0;
		this.color = Color.gray;
	}
	
	public Fichas(int numJugador, Color color){
		this.numJugador = numJugador;
		this.color = color;
	}

	public int getNumJugador(){
		return numJugador;
	}

	public Color getColor(){
		return color;
	}

	public void setColor(Color color){
		this.color = color;
	}
}