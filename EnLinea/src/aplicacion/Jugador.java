package aplicacion;

import java.awt.*;

public class Jugador{

	String nombre;
	int numero;
	Color colorFicha;

	public Jugador(String nombre, int numero, Color colorFicha){
		this.nombre = nombre;
		this.numero = numero;
		this.colorFicha = colorFicha;
	}

	public int getNumero(){
		return numero;
	}

	public String getNombre(){
		return nombre;
	}

	public Color getColorFicha(){
		return colorFicha;
	}

	public void setColorFicha(Color color){
		this.colorFicha = color;
	}
}