package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EnLineaGUI extends JFrame{

	// Ventana principal
	private static EnLineaGUI ventana;
	//Elementos del submenu
	private JMenuItem nuevo;
	private JMenuItem abrir;
	private JMenuItem salvar;	
	private JMenuItem salvar_como;
	private JMenuItem salir;
	//Elemantos del menu
	private JMenu menu;
	//Barra del menu
	private JMenuBar menuBar;
	//Archivo
	private JFileChooser juego;
	//
	private JButton[][] tablero = new JButton[10][10];
	
	// Constructor
	private EnLineaGUI(){
		prepareElementos();
		prepareAcciones();
	}

	public static void main(String[] args){
		ventana = new EnLineaGUI();
		ventana.setVisible(true);
		ventana.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent evt){ exitAccion();}});
	}

	private void prepareElementos(){
		//
		setTitle("EnLinea");
		setSize(500, 500);
		centre();
		//
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		menu = new JMenu("Menu");
		nuevo = new JMenuItem("Nuevo");
		abrir = new JMenuItem("Abrir");
		salvar = new JMenuItem("Salvar");
		salvar_como = new JMenuItem("Salvar como");
		salir = new JMenuItem("Salir");
		juego = new JFileChooser();
		//
		menu.add(nuevo);
		menu.add(abrir);		
		menu.add(salvar);
		menu.add(salvar_como);
		menu.add(salir);
		menuBar.add(menu);
		//
		abrir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				juego.showOpenDialog(null);
			}});
		salvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				juego.showSaveDialog(null);
			}});
		//
		for (int i = 0; i < tablero.length; i++){
			for (int j = 0; j < tablero[0].length ; j++) {
				tablero[i][j] = new JButton();
				tablero[i][j].setPreferredSize(new Dimension(1,1));
				tablero[i][j].setLocation(i, j);
				this.add(tablero[i][j]);
			}
		}
	}

	private void prepareAcciones(){
		setDefaultCloseOperation(0);
		salir.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){ exitAccion();}});
	}

	private void centre(){
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-getSize().width)/2;
		int y = (screen.height-getSize().height)/2;
		setLocation(x,y);
	}

	private static void exitAccion(){
		if (JOptionPane.showConfirmDialog(null,"Esta seguro que desea salir? ", "Salir del sistema",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
			System.exit(0);
	}
}