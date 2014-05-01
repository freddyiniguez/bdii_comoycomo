package comoycomo;

import java.awt.BorderLayout;
import javax.swing.*;

public class ComoyComo extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTabbedPane pestañas;
	private JMenuBar menuBar;
	private JMenu file, edit, help;
	private JMenuItem documentation;
	
	public ComoyComo(){
		super("COMO&COMO: Bienvenido");
		
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
		// Definición de pestaña de Clientes
		JPanel pClientes = new JPanel(null);	
		JLabel lbClientes = new JLabel("Altas, bajas y Cambios");
		lbClientes.setBounds(100,100,200,70);
		pClientes.add(lbClientes);
		pestañas.addTab("Clientes",null,pClientes);
		
		// Definición de pestaña de Platillos
		JPanel pPlatillos = new JPanel(null);
		JLabel lbPlatillos = new JLabel("Altas, bajas y Cambios");
		pPlatillos.setLayout(new BorderLayout());
		pPlatillos.add(lbPlatillos, BorderLayout.CENTER);
		pestañas.addTab("Platillos", null, pPlatillos);
		
		// Definición de pestaña de Población
		JPanel pPoblacion = new JPanel(null);
		JLabel lbPoblacion = new JLabel("Altas, bajas y Cambios");
		pPoblacion.setLayout(new BorderLayout());
		pPoblacion.add(lbPoblacion,BorderLayout.CENTER);
		pestañas.addTab("Población", null, pPoblacion);
		
		// Definición de pestaña de Centro
		JPanel pCentro = new JPanel(null);
		JLabel lbCentro = new JLabel("Altas, bajas y Cambios");
		pCentro.setLayout(new BorderLayout());
		pCentro.add(lbCentro,BorderLayout.CENTER);
		pestañas.addTab("Centros", null, pCentro);
		
		// Definición de pestaña de Empleado
		JPanel pEmpleado = new JPanel(null);
		JLabel lbEmpleado = new JLabel("Altas, bajas y Cambios");
		pEmpleado.setLayout(new BorderLayout());
		pEmpleado.add(lbEmpleado,BorderLayout.CENTER);
		pestañas.addTab("Empleados", null, pEmpleado);
		
		// Definición de pestaña de Factura
		JPanel pFactura = new JPanel(null);
		JLabel lbFactura= new JLabel("Altas, bajas y Cambios");
		pFactura.setLayout(new BorderLayout());
		pFactura.add(lbFactura,BorderLayout.CENTER);
		pestañas.addTab("Facturas", null, pFactura);
	}
	
	private void defineMenus(){
		menuBar = new JMenuBar();
		file = new JMenu("Archivo");
		edit =  new JMenu("Editar");
		help = new JMenu("Ayuda");
		documentation = new JMenuItem("Ver documentación");
		help.add(documentation);
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);
	}
}