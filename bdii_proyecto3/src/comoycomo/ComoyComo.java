package comoycomo;

import java.awt.BorderLayout;

import javax.swing.*;

public class ComoyComo extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTabbedPane pesta�as;
	private JMenuBar menuBar;
	private JMenu file, edit, help;
	private JMenuItem documentation;
	
	public ComoyComo(){
		super("COMO&COMO: Bienvenido");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,500);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		pesta�as = new JTabbedPane();
		
		definePesta�as();
		defineMenus();
		
		this.add(pesta�as);
		this.setJMenuBar(menuBar);
	}
	
	private void definePesta�as(){
		// Definici�n de pesta�a de Clientes
		JPanel pClientes = new JPanel(null);	
		JLabel lbClientes = new JLabel("Altas, bajas y Cambios");
		lbClientes.setBounds(100,100,200,70);
		pClientes.add(lbClientes);
		pesta�as.addTab("Clientes",null,pClientes);
		
		// Definici�n de la pesta�a de Platillos
		JPanel pPlatillos = new JPanel(null);
		JLabel lbPlatillos = new JLabel("Altas, bajas y Cambios");
		pPlatillos.setLayout(new BorderLayout());
		pPlatillos.add(lbPlatillos, BorderLayout.CENTER);
		pesta�as.addTab("Platillos", null, pPlatillos);
		
		// Definici�n de la pesta�a de Poblaci�n
		JPanel pPoblacion = new JPanel(null);
		JLabel lbPoblacion = new JLabel("Altas, bajas y Cambios");
		pPoblacion.setLayout(new BorderLayout());
		pPoblacion.add(lbPoblacion,BorderLayout.CENTER);
		pesta�as.addTab("Poblaci�n", null, pPoblacion);
		
		// Definici�n de la pesta�a de Centro
		JPanel pCentro = new JPanel(null);
		JLabel lbCentro = new JLabel("Altas, bajas y Cambios");
		pCentro.setLayout(new BorderLayout());
		pCentro.add(lbCentro,BorderLayout.CENTER);
		pesta�as.addTab("Centros", null, pCentro);
		
		// Definici�n de la pesta�a de Empleado
		JPanel pEmpleado = new JPanel(null);
		JLabel lbEmpleado = new JLabel("Altas, bajas y Cambios");
		pEmpleado.setLayout(new BorderLayout());
		pEmpleado.add(lbEmpleado,BorderLayout.CENTER);
		pesta�as.addTab("Empleados", null, pEmpleado);
		
		// Definici�n de la pesta�a de Factura
		JPanel pFactura = new JPanel(null);
		JLabel lbFactura= new JLabel("Altas, bajas y Cambios");
		pFactura.setLayout(new BorderLayout());
		pFactura.add(lbFactura,BorderLayout.CENTER);
		pesta�as.addTab("Facturas", null, pFactura);
	}
	
	private void defineMenus(){
		menuBar = new JMenuBar();
		file = new JMenu("Archivo");
		edit =  new JMenu("Editar");
		help = new JMenu("Ayuda");
		documentation = new JMenuItem("Ver documentaci�n");
		help.add(documentation);
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);
	}
}