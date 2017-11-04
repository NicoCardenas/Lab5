package presentacion;

import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;

public class EnLineaGUI extends JFrame{
	
	// Constructor
	private EnLineaGUI(){
		prepareElementos();
		prepareAcciones();
		setDefaultCloseOperation(3);

		//inicie();
	}

	public static void main(String[] args){
		EnLineaGUI ventana = new EnLineaGUI();
		ventana.setVisible(true);
	}
	
	private void prepareElementos(){
		setTitle("EnLinea");
		setSize(500, 500);
		centre();
	}

	private void prepareAcciones(){

	}

	private void centre(){
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-getSize().width)/2;
		int y = (screen.height-getSize().height)/2;
		setLocation(x,y);
	}
}