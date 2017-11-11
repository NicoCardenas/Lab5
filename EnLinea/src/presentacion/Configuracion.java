package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import aplicacion.*;

public class Configuracion extends JFrame{

	// Ventana principal
	private static EnLineaGUI ventanaPrincipal;
	private static Configuracion ventana;
	//Layout
	JPanel tituloLayout = new JPanel(new FlowLayout());
	JPanel centroLayout = new JPanel(new BorderLayout());
	JPanel centrar = new JPanel(new GridLayout(4,3));
	//Elementos para seleccionar los Colores
	private JButton colorJugador1 = new JButton("Color");
	private JButton colorJugador2 = new JButton("Color");
	private JButton finalizar = new JButton("Finalizar");
	private JColorChooser ventanaColor = new JColorChooser();
	private Color color1 = Color.green;
	private Color color2 = Color.blue;
	//Texto
	private JLabel texto_1 = new JLabel("Color del jugador 1");
	private JLabel texto_2 = new JLabel("Color del jugador 2");
	private JLabel titulo = new JLabel("Configuracion");

	public Configuracion(EnLineaGUI ventanaPadre){
		super();
		prepareElementos();
		this.ventanaPrincipal = ventanaPadre;
	}

	public static void main(String[] args){
		ventana = new Configuracion(null);
	}

	private void prepareElementos(){
		//Configuracion del la ventana
		setTitle("EnLinea");
		setSize(500, 500);
		setResizable(false);
		setLayout(new BorderLayout());
		centre();
		add(tituloLayout,BorderLayout.NORTH);
		add(centroLayout,BorderLayout.CENTER);

		//Agregar botones a la ventana
		colorJugador1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color1 = ventanaColor.showDialog(null, "Seleccione un Color", Color.gray);
			}
		});
		colorJugador2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				color2 = ventanaColor.showDialog(null, "Seleccione un Color", Color.gray);
			}
		});
		finalizar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				refresque(ventanaPrincipal);
			}
		});

		tituloLayout.add(titulo);

		centrar.add(texto_1);
		centrar.add(new JPanel());
		centrar.add(texto_2);

		centrar.add(colorJugador1);
		centrar.add(new JPanel());
		centrar.add(colorJugador2);

		centrar.add(new JPanel());
		centrar.add(new JPanel());
		centrar.add(new JPanel());

		centrar.add(new JPanel());
		centrar.add(finalizar);
		centrar.add(new JPanel());

		centroLayout.add(new JPanel(), BorderLayout.EAST);
		centroLayout.add(centrar, BorderLayout.CENTER);
		centroLayout.add(new JPanel(), BorderLayout.WEST);

	}

	private void centre(){
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-getSize().width)/2;
		int y = (screen.height-getSize().height)/2;
		setLocation(x,y);
	}

	public Color getColor1(){
		return color1;
	}

	public Color getColor2(){
		return color2;
	}

	private void refresque(EnLineaGUI ventanaPadre){
		ventanaPadre.refresque();
	}
}