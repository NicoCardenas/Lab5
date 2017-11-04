package presentacion;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;

public class EnLineaGUI extends JFrame{
	
	// Constructor
	private EnLineaGUI(){
		prepareElementos();
		prepareAcciones();
	}

	public static void main(String[] args){
		EnLineaGUI ventana = new EnLineaGUI();
		ventana.setVisible(true);
		ventana.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent evt){ exitAccion();}});
	}

	private void prepareElementos(){
		setTitle("EnLinea");
		setSize(500, 500);
		centre();
	}

	private void prepareAcciones(){
		setDefaultCloseOperation(0);
	}

	private void centre(){
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-getSize().width)/2;
		int y = (screen.height-getSize().height)/2;
		setLocation(x,y);
	}

	private static  void exitAccion(){
		if (JOptionPane.showConfirmDialog(null,"Esta seguro que desea salir? ", "Salir del sistema",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			System.exit(0);
	}
}