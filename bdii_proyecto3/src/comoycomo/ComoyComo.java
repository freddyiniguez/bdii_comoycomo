package comoycomo;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

/**
 * 
 * @author freddy
 * @see java.awt.event.ActionListener
 */
public class ComoyComo extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JTabbedPane pestañas;
	private JMenuBar menuBar;
	private JMenu file, edit, help;
	private JMenuItem documentation, exit;
	
	/**
	 * @author freddy
	 * @param windowName
	 * Constructor.
	 * Recibe un String que será usado para poner el nombre de la ventana.
	 */
	public ComoyComo(String windowName){
		super(windowName);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		pestañas = new JTabbedPane();
		
		definePestañas();
		defineMenus();
		
		this.add(pestañas);
		this.setJMenuBar(menuBar);
	}
	
	private void definePestañas(){
		// Definición de pestaña de CLIENTES.
		JPanel pClientes = new JPanel(null);
		// Se define un label para indicar un mensaje antes de la tabla.
		JLabel lbClientes = new JLabel("Clientes registrados en COMO&COMO");
		lbClientes.setBounds(10,10,300,20);
		pClientes.add(lbClientes);
		// Se define un elemento JSeparator para separar el mensaje anterior de la tabla de Clientes.
		JSeparator spClientes = new JSeparator();
		spClientes.setBounds(10,30,300,20);
		pClientes.add(spClientes);
		// Se asigna un color al panel y se agrega a la pestaña que lo va a contener.
		pClientes.setBackground(Color.LIGHT_GRAY);
		pestañas.addTab("Clientes",null,pClientes);
		
		// Definición de pestaña de PLATILLOS.
		JPanel pPlatillos = new JPanel(null);
		JLabel lbPlatillos = new JLabel("Platillos registrados en COMO&COMO");
		lbPlatillos.setBounds(10,10,300,20);
		pPlatillos.add(lbPlatillos);
		JSeparator spPlatillos = new JSeparator();
		spPlatillos.setBounds(10,30,300,20);
		pPlatillos.add(spPlatillos);
		pPlatillos.setBackground(Color.LIGHT_GRAY);
		pestañas.addTab("Platillos", null, pPlatillos);
		
		// Definición de pestaña de POBLACIÓN.
		JPanel pPoblacion = new JPanel(null);
		JLabel lbPoblacion = new JLabel("Poblaciones registradas en COMO&COMO");
		lbPoblacion.setBounds(10,10,300,20);
		pPoblacion.add(lbPoblacion);
		JSeparator spPoblacion = new JSeparator();
		spPoblacion.setBounds(10,30,300,20);
		pPoblacion.add(spPoblacion);
		pPoblacion.setBackground(Color.LIGHT_GRAY);
		pestañas.addTab("Población", null, pPoblacion);
		
		// Definición de pestaña de CENTRO.
		JPanel pCentro = new JPanel(null);
		JLabel lbCentro = new JLabel("Centros registrados en COMO&COMO");
		lbCentro.setBounds(10,10,300,20);
		pCentro.add(lbCentro);
		JSeparator spCentro = new JSeparator();
		spCentro.setBounds(10,30,300,20);
		pCentro.add(spCentro);
		pCentro.setBackground(Color.LIGHT_GRAY);
		pestañas.addTab("Centros", null, pCentro);
		
		// Definición de pestaña de EMPLEADO.
		JPanel pEmpleado = new JPanel(null);
		JLabel lbEmpleado = new JLabel("Empleados registrados en COMO&COMO");
		lbEmpleado.setBounds(10,10,300,20);
		pEmpleado.add(lbEmpleado);
		JSeparator spEmpleado = new JSeparator();
		spEmpleado.setBounds(10,30,300,20);
		pEmpleado.add(spEmpleado);
		pEmpleado.setBackground(Color.LIGHT_GRAY);
		pestañas.addTab("Empleados", null, pEmpleado);
		
		// Definición de pestaña de FACTURA.
		JPanel pFactura = new JPanel(null);
		JLabel lbFactura = new JLabel("Facturas registradas en COMO&COMO");
		lbFactura.setBounds(10,10,300,20);
		pFactura.add(lbFactura);
		JSeparator spFactura = new JSeparator();
		spFactura.setBounds(10,30,300,20);
		pFactura.add(spFactura);
		pFactura.setBackground(Color.LIGHT_GRAY);
		pestañas.addTab("Facturas", null, pFactura);
	}
	
	private void defineMenus(){
		menuBar = new JMenuBar();
		file = new JMenu("Archivo");
		edit =  new JMenu("Editar");
		help = new JMenu("Ayuda");
		documentation = new JMenuItem("Ver documentación");
		documentation.addActionListener(this); // Se define el evento del botón de documentación.
		exit = new JMenuItem("Salir");
		exit.addActionListener(this); 	// Se define el evento del botón de salida.
		help.add(documentation);
		file.add(exit);
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Se presionó la tecla de Documentación
		if(e.getSource()==documentation){
			try {
				Desktop.getDesktop().open(new File("files/project2.pdf"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		// Se presionó la tecla de Salir.
		if(e.getSource()==exit){
			JOptionPane.showMessageDialog(null, "Usted está saliendo de COMO&COMO\nClic en Aceptar para salir.",
												"Buen día",JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
}