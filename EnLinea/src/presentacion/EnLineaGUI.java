package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import aplicacion.*;

public class EnLineaGUI extends JFrame{

	// Ventanas
	private static EnLineaGUI ventana;
	private static Configuracion ventanaConfiguracion;
	//Layout
	JPanel tituloLayout = new JPanel(new FlowLayout());
	JPanel centroLayout = new JPanel(new GridLayout(10,10));
	JPanel botones = new JPanel(new BorderLayout());
	//Elementos del submenu
	private JMenuItem nuevo = new JMenuItem("Nuevo");
	private JMenuItem abrir = new JMenuItem("Abrir");
	private JMenuItem configuracion = new JMenuItem("configuracion");
	private JMenuItem salvar = new JMenuItem("Salvar");	
	private JMenuItem salvar_como = new JMenuItem("Salvar como");
	private JMenuItem salir = new JMenuItem("Salir");
	//Elemantos del menu
	private JMenu menu = new JMenu("Menu");
	//Barra del menu
	private JMenuBar menuBar = new JMenuBar();
	//Archivo
	private JFileChooser juego = new JFileChooser();
	//Elementos del tablero
	private JButton[][] tablero = new JButton[10][10];
	private JLabel titulo = new JLabel();
	private Random random = new Random();
	//Elementos para seleccionar los Colores
	private JButton colorJugador1 = new JButton("Color jugador 1");
	private JButton colorJugador2 = new JButton("Color jugador 2");
	private JColorChooser ventanaColor = new JColorChooser();
	private Color color1 = Color.green;
	private Color color2 = Color.blue;
	//Elemento logico
	private EnLinea logica = new EnLinea();

	// Constructor
	private EnLineaGUI(){
		super();
		prepareElementos();
		prepareAcciones();
	}

	public static void main(String[] args){
		ventana = new EnLineaGUI();
		ventana.setVisible(true);
		ventana.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent evt){ exitAccion();}});
	}

	private void prepareElementos(){
		//Configuracion del la ventana
		setTitle("EnLinea");
		setSize(500, 500);
		setResizable(false);
		setLayout(new BorderLayout());
		add(tituloLayout,BorderLayout.NORTH);
		add(centroLayout,BorderLayout.CENTER);
		add(botones,BorderLayout.SOUTH);
		centre();
		setJMenuBar(menuBar);
		//inicializacion de la ventana de configuracion
		ventanaConfiguracion = new Configuracion(this);
		menu.add(nuevo);
		menu.add(abrir);
		menu.add(configuracion);
		menu.add(salvar);
		menu.add(salvar_como);
		menu.add(salir);
		menuBar.add(menu); // Adicion del JMenu al JMenuBar
		//Oyntes de los botones del menuBar
		nuevo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				reiniciar();
			}});
		abrir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				juego.showOpenDialog(null);
			}});
		configuracion.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ventanaConfiguracion.setVisible(true);
			}});
		salvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				juego.showSaveDialog(null);
			}});
		//Elementos del tablero
		prepareElementosTablero();
		//Demo
		demo();
	}

	private void prepareElementosTablero(){
		titulo.setText("4 En Linea");
		titulo.setFont(new Font("Bradley Hand ITC",Font.BOLD,32));
		tituloLayout.add(titulo);
		for (int i = 0; i < tablero.length; i++){
			for (int j = 0; j < tablero[0].length; j++) {
				tablero[i][j] = new JButton();
				tablero[i][j].addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						//logica.setMovimiento( 0, 0,logica.getTurno());
						logica.ganador();
						setEnabled(false);
					}});
				centroLayout.add(tablero[i][j]);
			}
		}
	}

	public void refresque(){
		for (int i = 0; i < tablero.length; i++){
			for (int j = 0; j < tablero[0].length; j++) {
				color1 = ventanaConfiguracion.getColor1();
				color2 = ventanaConfiguracion.getColor2();
				demo();
				tablero[i][j].setVisible(false);
				tablero[i][j].setVisible(true);
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

	private void demo(){
		for (int i = 3; i < tablero.length; i++){
			for (int j = 0; j < tablero[0].length; j++) {
				if (random.nextInt()%2 == 0)
					tablero[i][j].setBackground(color1);
				else
					tablero[i][j].setBackground(color2);
				tablero[i][j].setEnabled(false);
			}
		}
	}

	private void reiniciar(){
		for (int i = 0; i < tablero.length; i++){
			for (int j = 0; j < tablero[0].length; j++){
				tablero[i][j].setVisible(false);
				centroLayout.remove(tablero[i][j]);
			}
		}
		prepareElementosTablero();
	}
}
