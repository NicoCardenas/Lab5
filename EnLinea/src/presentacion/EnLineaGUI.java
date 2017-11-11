package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class EnLineaGUI extends JFrame{

	// Ventana principal
	private static EnLineaGUI ventana;
	//Layout
	JPanel tituloLayout = new JPanel(new FlowLayout());
	JPanel centroLayout = new JPanel(new GridLayout(10,10));
	JPanel botones = new JPanel(new BorderLayout());
	//Elementos del submenu
	private JMenuItem nuevo = new JMenuItem("Nuevo");
	private JMenuItem abrir = new JMenuItem("Abrir");
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
		this.add(tituloLayout,BorderLayout.NORTH);
		this.add(centroLayout,BorderLayout.CENTER);
		this.add(botones,BorderLayout.SOUTH);
		centre();
		this.setJMenuBar(menuBar);
		//Agregar botones a la ventana
		colorJugador1.setBounds(90,400,120,30);
		colorJugador2.setBounds(270,400,120,30);
		colorJugador1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color1 = ventanaColor.showDialog(null, "Seleccione un Color", Color.gray);
				refresque();
			}
		});
		colorJugador2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color2 = ventanaColor.showDialog(null, "Seleccione un Color", Color.gray);
				refresque();
			}
		});
		botones.add(colorJugador1,BorderLayout.WEST);
		botones.add(colorJugador2,BorderLayout.EAST);
		//Adicion de los JMenuItem a JMenu
		menu.add(nuevo);
		menu.add(abrir);		
		menu.add(salvar);
		menu.add(salvar_como);
		menu.add(salir);
		menuBar.add(menu); // Adicion del JMenu al JMenuBar
		//Oyntes de los botones del menuBar
		abrir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				juego.showOpenDialog(null);
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
		//titulo.setBounds(155,30,180,32);
		tituloLayout.add(titulo);
		for (int i = 0; i < tablero.length; i++){
			for (int j = 0; j < tablero[0].length; j++) {
				tablero[i][j] = new JButton();
				//tablero[i][j].setBounds(30*(i+3), 30*(j+3), 30, 30);
				tablero[i][j].setEnabled(false);
				centroLayout.add(tablero[i][j]);
			}
		}
	}

	private void refresque(){
		for (int i = 0; i < tablero.length; i++){
			for (int j = 0; j < tablero[0].length; j++) {
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
			}
		}
	}
}
