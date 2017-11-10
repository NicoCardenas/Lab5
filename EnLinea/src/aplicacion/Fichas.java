package aplicacion;

public class Fichas{

	int numJugador;
	Color color;
	int tamaño;

	public Fichas(){
		this.numJugador = 0;
		this.color = Color.gray;
		this.tamaño = 30;
	}
	
	public Fichas(int numJugador, Color color, int tamaño){
		this.numJugador = numJugador;
		this.color = color;
		this.tamaño = tamaño;
	}
}