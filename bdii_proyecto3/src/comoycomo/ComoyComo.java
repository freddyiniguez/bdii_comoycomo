package comoycomo;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import comoycomo.objects.*;
import comoycomo.ventanas.*;

/**
 * 
 * @author freddy
 * @see java.awt.event.ActionListener
 */
public class ComoyComo extends JFrame implements ActionListener, ChangeListener, ListSelectionListener{
	private static final long serialVersionUID = 1L;
	private JTabbedPane pesta�as;
	private JMenuBar menuBar;
	private JMenu file, edit, help;
	private JMenuItem documentation, exit;
	private JButton btnClientes, btnPlatillos, btnPoblacion, btnCentros, btnEmpleados, btnFacturas,
					btnClientesE, btnPlatillosE, btnPoblacionE, btnCentrosE, btnEmpleadosE, btnFacturasE;
	private JScrollPane jspClientes, jspPlatillos, jspPoblacion, jspCentros, jspEmpleados, jspFacturas;
	private List<Integer> idsCliente, idsPlatillos, idsPoblacion, idsCentros, idsEmpleados, idsFacturas;
	private String[] titClientesAux, titPlatillosAux, titPoblacionAux, titCentrosAux, titEmpleadosAux, titFacturasAux;
	private AddCliente vCliente = new AddCliente(this);
	private AddPlatillo vPlatillo = new AddPlatillo(this);
	private AddPoblacion vPoblacion = new AddPoblacion(this);
	private AddCentro vCentro = new AddCentro(this);
	private AddEmpleado vEmpleado = new AddEmpleado(this);
	private AddFactura vFactura = new AddFactura(this);
	private DefaultTableModel dtmClientes, dtmPlatillos, dtmPoblacion, dtmCentros, dtmEmpleados, dtmFacturas;
	private JTable tClientes, tPlatillos, tPoblacion, tCentros, tEmpleados, tFacturas;
	private OracleConnection bdConnection;
	
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
		
		// Crea la conexi�n con Oracle
		bdConnection = new OracleConnection();
		
		pesta�as = new JTabbedPane();
		pesta�as.addChangeListener(this);
		
		definePesta�as();
		defineMenus();

		this.add(pesta�as);
		this.setJMenuBar(menuBar);
	}
	
	/**
	 * Metodo que forma parte del constructor. <br> Define los elementos que contendran
	 * las pestanias, como las etiquetas, separadores, tablas y botones.
	 */
	private void definePesta�as(){
		// ---------------- Pesta�a CLIENTES ------------------- //
		JPanel pClientes = new JPanel(null);
		// Se define un label para indicar un mensaje antes de la tabla.
		JLabel lbClientes = new JLabel("Clientes registrados en COMO&COMO");
		lbClientes.setBounds(10,10,300,20);
		pClientes.add(lbClientes);
		// Se define un elemento JSeparator para separar el mensaje anterior de la tabla de Clientes.
		JSeparator spClientes = new JSeparator();
		spClientes.setBounds(10,30,300,20);
		pClientes.add(spClientes);
		// Se crea el bot�n que se usar� para registrar un nuevo cliente.
		btnClientes = new JButton("A�adir");
		btnClientes.setBounds(670,380,100,30);
		btnClientes.addActionListener(this);
		pClientes.add(btnClientes);
		// Se crea el bot�n que se usar� para eliminar clientes.
		btnClientesE = new JButton("Eliminar");
		btnClientesE.setBounds(20, 380, 100, 30);
		btnClientesE.addActionListener(this);
		btnClientesE.setEnabled(false);
		pClientes.add(btnClientesE);
		// Se define la lista de t�tulos que contendr� la tabla de clientes.
		String[] titClientes = {"Nombre(s)",
								"Apellido Paterno",
								"Apellido Materno",
								"Direcci�n", 
								"Colonia"};
		titClientesAux = titClientes;
		// Se define la tabla, el scroll pane que esta contendr�
		dtmClientes = new DefaultTableModel();
		tClientes = new JTable(dtmClientes);
		tClientes.getSelectionModel().addListSelectionListener(this);
		idsCliente = new ArrayList<Integer>();
		jspClientes = new JScrollPane(tClientes);
		jspClientes.setBounds(10,35,770,335);
		pClientes.add(jspClientes);
		fillTableClientes(titClientesAux);
		// Se asigna un color al panel y se agrega a la pesta�a que lo va a contener.
		pClientes.setBackground(Color.LIGHT_GRAY);
		pesta�as.addTab("Clientes",null,pClientes);
		
		// ---------------- Pesta�a PLATILLOS ------------------- //
		JPanel pPlatillos = new JPanel(null);
		JLabel lbPlatillos = new JLabel("Platillos registrados en COMO&COMO");
		lbPlatillos.setBounds(10,10,300,20);
		pPlatillos.add(lbPlatillos);
		JSeparator spPlatillos = new JSeparator();
		spPlatillos.setBounds(10,30,300,20);
		pPlatillos.add(spPlatillos);
		btnPlatillos = new JButton("A�adir");
		btnPlatillos.setBounds(670,380,100,30);
		btnPlatillos.addActionListener(this);
		pPlatillos.add(btnPlatillos);
		btnPlatillosE = new JButton("Eliminar");
		btnPlatillosE.setBounds(20,380,100,30);
		btnPlatillosE.addActionListener(this);
		btnPlatillosE.setEnabled(false);
		pPlatillos.add(btnPlatillosE);
		String[] titPlatillos = {"Nombre", 
								"Descripci�n", 
								"Precio",
								"Cantidad"};
		titPlatillosAux = titPlatillos;
		dtmPlatillos = new DefaultTableModel();
		tPlatillos = new JTable(dtmPlatillos);
		tPlatillos.getSelectionModel().addListSelectionListener(this);
		idsPlatillos = new ArrayList<Integer>();
		jspPlatillos = new JScrollPane(tPlatillos);
		jspPlatillos.setBounds(10,35,770,335);
		pPlatillos.add(jspPlatillos);
		fillTablePlatillos(titPlatillosAux);
		pPlatillos.setBackground(Color.LIGHT_GRAY);
		pesta�as.addTab("Platillos", null, pPlatillos);
		
		// ---------------- Pesta�a POBLACI�N ------------------- //
		JPanel pPoblacion = new JPanel(null);
		JLabel lbPoblacion = new JLabel("Poblaciones registradas en COMO&COMO");
		lbPoblacion.setBounds(10,10,300,20);
		pPoblacion.add(lbPoblacion);
		JSeparator spPoblacion = new JSeparator();
		spPoblacion.setBounds(10,30,300,20);
		pPoblacion.add(spPoblacion);
		btnPoblacion = new JButton("A�adir");
		btnPoblacion.setBounds(670,380,100,30);
		btnPoblacion.addActionListener(this);
		pPoblacion.add(btnPoblacion);
		btnPoblacionE = new JButton("Eliminar");
		btnPoblacionE.setBounds(20,380,100,30);
		btnPoblacionE.addActionListener(this);
		btnPoblacionE.setEnabled(false);
		pPoblacion.add(btnPoblacionE);
		String[] titPoblacion = {"Nombre", 
								"Habitantes"};
		titPoblacionAux = titPoblacion;
		dtmPoblacion = new DefaultTableModel();
		tPoblacion = new JTable(dtmPoblacion);
		tPoblacion.getSelectionModel().addListSelectionListener(this);
		idsPoblacion = new ArrayList<Integer>();
		jspPoblacion = new JScrollPane();
		jspPoblacion.setBounds(10,35,770,335);
		pPoblacion.add(jspPoblacion);
		fillTablePoblacion(titPoblacionAux);
		pPoblacion.setBackground(Color.LIGHT_GRAY);
		pesta�as.addTab("Poblaci�n", null, pPoblacion);
		
		// ---------------- Pesta�a CENTROS ------------------- //
		JPanel pCentro = new JPanel(null);
		JLabel lbCentro = new JLabel("Centros registrados en COMO&COMO");
		lbCentro.setBounds(10,10,300,20);
		pCentro.add(lbCentro);
		JSeparator spCentro = new JSeparator();
		spCentro.setBounds(10,30,300,20);
		pCentro.add(spCentro);
		btnCentros = new JButton("A�adir");
		btnCentros.setBounds(670,380,100,30);
		btnCentros.addActionListener(this);
		pCentro.add(btnCentros);
		btnCentrosE = new JButton("Eliminar");
		btnCentrosE.setBounds(20,380,100,30);
		btnCentrosE.addActionListener(this);
		btnCentrosE.setEnabled(false);
		pCentro.add(btnCentrosE);
		String[] titCentros = {"Nombre", 
								"Direccion", 
								"Colonia",
								"Tel�fono"
								};
		titCentrosAux = titCentros;
		dtmCentros = new DefaultTableModel();
		tCentros = new JTable(dtmCentros);
		tCentros.getSelectionModel().addListSelectionListener(this);
		idsCentros = new ArrayList<Integer>();
		jspCentros = new JScrollPane(tCentros);
		jspCentros.setBounds(10,35,770,335);
		pCentro.add(jspCentros);
		fillTableCentros(titCentrosAux);
		pCentro.setBackground(Color.LIGHT_GRAY);
		pesta�as.addTab("Centros", null, pCentro);
		
		// ---------------- Pesta�a EMPLEADOS ------------------- //
		JPanel pEmpleado = new JPanel(null);
		JLabel lbEmpleado = new JLabel("Empleados registrados en COMO&COMO");
		lbEmpleado.setBounds(10,10,300,20);
		pEmpleado.add(lbEmpleado);
		JSeparator spEmpleado = new JSeparator();
		spEmpleado.setBounds(10,30,300,20);
		pEmpleado.add(spEmpleado);
		btnEmpleados = new JButton("A�adir");
		btnEmpleados.setBounds(670,380,100,30);
		btnEmpleados.addActionListener(this);
		pEmpleado.add(btnEmpleados);
		btnEmpleadosE = new JButton("Eliminar");
		btnEmpleadosE.setBounds(20,380,100,30);
		btnEmpleadosE.addActionListener(this);
		btnEmpleadosE.setEnabled(false);
		pEmpleado.add(btnEmpleadosE);
		String[] titEmpleados = {"RFC", 
								"Nombre(s)", 
								"Apellido Paterno", 
								"Apellido Materno", 
								"Direcci�n",
								"Colonia",
								"Tel�fono" 
								};
		titEmpleadosAux = titEmpleados;
		dtmEmpleados = new DefaultTableModel();
		tEmpleados = new JTable(dtmEmpleados);
		tEmpleados.getSelectionModel().addListSelectionListener(this);
		idsEmpleados = new ArrayList<Integer>();
		jspEmpleados = new JScrollPane(tEmpleados);
		jspEmpleados.setBounds(10,35,770,335);
		pEmpleado.add(jspEmpleados);
		fillTableEmpleados(titEmpleadosAux);
		pEmpleado.setBackground(Color.LIGHT_GRAY);
		pesta�as.addTab("Empleados", null, pEmpleado);
		
		// ---------------- Pesta�a FACTURAS ------------------- //
		JPanel pFactura = new JPanel(null);
		JLabel lbFactura = new JLabel("Facturas registradas en COMO&COMO");
		lbFactura.setBounds(10,10,300,20);
		pFactura.add(lbFactura);
		JSeparator spFactura = new JSeparator();
		spFactura.setBounds(10,30,300,20);
		pFactura.add(spFactura);
		btnFacturas = new JButton("A�adir");
		btnFacturas.setBounds(670,380,100,30);
		btnFacturas.addActionListener(this);
		pFactura.add(btnFacturas);
		btnFacturasE = new JButton("Eliminar");
		btnFacturasE.setBounds(20,380,100,30);
		btnFacturasE.addActionListener(this);
		btnFacturasE.setEnabled(false);
		pFactura.add(btnFacturasE);
		String[] titFacturas = {"Dia",
								"Mes",
								"A�o",
								};
		titFacturasAux = titFacturas;
		dtmFacturas = new DefaultTableModel();
		tFacturas = new JTable(dtmFacturas);
		tFacturas.getSelectionModel().addListSelectionListener(this);
		idsFacturas = new ArrayList<Integer>();
		jspFacturas = new JScrollPane(tFacturas);
		jspFacturas.setBounds(10,35,770,335);
		pFactura.add(jspFacturas);
		fillTableFacturas(titFacturasAux);
		pFactura.setBackground(Color.LIGHT_GRAY);
		pesta�as.addTab("Facturas", null, pFactura);
	}
	
	/**
	 * Metodo que forma parte del constructor. <br> Define los elementos que contendra
	 * la barra de menus y sus submenus.
	 */
	private void defineMenus(){
		menuBar = new JMenuBar();
		file = new JMenu("Archivo");
		edit =  new JMenu("Editar");
		help = new JMenu("Ayuda");
		documentation = new JMenuItem("Ver documentaci�n");
		documentation.addActionListener(this); // Se define el evento del botón de documentación.
		exit = new JMenuItem("Salir");
		exit.addActionListener(this); 	// Se define el evento del botón de salida.
		help.add(documentation);
		file.add(exit);
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(help);
	}
	
	// ----------------- M�TODOS DE CLIENTES ------------------------ //
	public void fillTableClientes(String[] titClientes){
		dtmClientes.setRowCount(0);
		dtmClientes.setColumnCount(0);
		dtmClientes.setColumnIdentifiers(titClientes);
		idsCliente.clear();
		try{
			ResultSet aux = bdConnection.getStament().executeQuery("SELECT * FROM CLIENTE2");
			while(aux.next()){
				Object[] fila = {aux.getObject(2),aux.getObject(3),aux.getObject(4),aux.getObject(5), aux.getObject(6)};
				idsCliente.add(Integer.valueOf(String.valueOf(aux.getObject(1))));
				dtmClientes.addRow(fila);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void addRowClientes(Cliente c){
		String query = "INSERT INTO CLIENTE2 (ID_CL, NOMBRE_CL, APATERNO_CL, AMATERNO_CL, CALLE_CL, COLONIA_CL) VALUES ("+Math.floor(Math.random()*1000)+",'"+c.getNombre()+"','"+c.getPaterno()+"','"+c.getMaterno()+"','"+c.getCalle()+"','"+c.getColonia()+"')";
		try {
			bdConnection.getStament().executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cliente registrado con �xito.", "COMO&COMO: Actualizaci�n", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo realizar el alta del Cliente.\nIntente de nuevo.", "COMO&COMO: Error",JOptionPane.ERROR_MESSAGE);
		}
		fillTableClientes(titClientesAux);
	}
	
	public void deleteRowsClientes(int[] rowsSelected){
		for(int i=0; i<rowsSelected.length; i++){
			String query = "DELETE FROM CLIENTE2 WHERE ID_CL = '"+idsCliente.get(rowsSelected[i])+"'";
			try{
				bdConnection.getStament().executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Cliente eliminado.","COMO&COMO: Actualizaci�n",JOptionPane.INFORMATION_MESSAGE);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		fillTableClientes(titClientesAux);
	}
	
	// ----------------- M�TODOS DE PLATILLOS ------------------------ //
	public void fillTablePlatillos(String[] titPlatillos){
		dtmPlatillos.setRowCount(0);
		dtmPlatillos.setColumnCount(0);
		dtmPlatillos.setColumnIdentifiers(titPlatillos);
		idsPlatillos.clear();
		try{
			ResultSet aux = bdConnection.getStament().executeQuery("SELECT * FROM PLATILLO2");
			while(aux.next()){
				Object[] fila = {aux.getObject(2),aux.getObject(3),aux.getObject(4),aux.getObject(5)};
				idsPlatillos.add(Integer.valueOf(String.valueOf(aux.getObject(1))));
				dtmPlatillos.addRow(fila);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void addRowPlatillos(Platillo p){
		String query = "INSERT INTO PLATILLO2 (ID_PL, NOMBRE_PL, DESCRIPCION, PRECIO, CANTIDAD) VALUES ("+Math.floor(Math.random()*1000)+",'"+p.getNombre()+"','"+p.getDescripcion()+"','"+p.getPrecio()+"','"+p.getCantidad()+"')";
		try {
			bdConnection.getStament().executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Platillo registrado con �xito.", "COMO&COMO: Actualizaci�n", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo realizar el alta del Platillo.\nIntente de nuevo.", "COMO&COMO: Error",JOptionPane.ERROR_MESSAGE);
		}
		fillTablePlatillos(titPlatillosAux);
	}
	
	public void deleteRowsPlatillos(int[] rowsSelected){
		for(int i=0; i<rowsSelected.length; i++){
			String query = "DELETE FROM PLATILLO2 WHERE ID_PL = '"+idsPlatillos.get(rowsSelected[i])+"'";
			try{
				bdConnection.getStament().executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Platillo eliminado.","COMO&COMO: Actualizaci�n",JOptionPane.INFORMATION_MESSAGE);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		fillTablePlatillos(titPlatillosAux);
	}
	// ----------------- M�TODOS DE POBLACION ------------------------ //
	public void fillTablePoblacion(String[] titPoblacion){
		dtmPoblacion.setRowCount(0);
		dtmPoblacion.setColumnCount(0);
		dtmPoblacion.setColumnIdentifiers(titPoblacion);
		idsPoblacion.clear();
		try{
			ResultSet aux = bdConnection.getStament().executeQuery("SELECT * FROM POBLACION2");
			while(aux.next()){
				Object[] fila = {aux.getObject(2),aux.getObject(3)};
				idsPoblacion.add(Integer.valueOf(String.valueOf(aux.getObject(1))));
				dtmPoblacion.addRow(fila);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void addRowPoblacion(Poblacion p){
		String query = "INSERT INTO POBLACION2 (ID_P, NOMBRE_P, NUM_HABITANTES) VALUES ("+Math.floor(Math.random()*1000)+",'"+p.getNombre()+"','"+p.getHabitantes()+"'";
		try {
			bdConnection.getStament().executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Poblacion registrada con �xito.", "COMO&COMO: Actualizaci�n", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo realizar el alta de la Poblaci�n.\nIntente de nuevo.", "COMO&COMO: Error",JOptionPane.ERROR_MESSAGE);
		}
		fillTablePoblacion(titPoblacionAux);
	}
	
	public void deleteRowsPoblacion(int[] rowsSelected){
		for(int i=0; i<rowsSelected.length; i++){
			String query = "DELETE FROM POBLACION2 WHERE ID_P = '"+idsPoblacion.get(rowsSelected[i])+"'";
			try{
				bdConnection.getStament().executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Poblaci�n eliminada.","COMO&COMO: Actualizaci�n",JOptionPane.INFORMATION_MESSAGE);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		fillTablePoblacion(titPoblacionAux);
	}
	// ----------------- M�TODOS DE CENTROS ------------------------ //
	public void fillTableCentros(String[] titCentros){
		dtmCentros.setRowCount(0);
		dtmCentros.setColumnCount(0);
		dtmCentros.setColumnIdentifiers(titCentros);
		idsCentros.clear();
		try{
			ResultSet aux = bdConnection.getStament().executeQuery("SELECT * FROM CENTRO2");
			while(aux.next()){
				Object[] fila = {aux.getObject(2),aux.getObject(3),aux.getObject(4),aux.getObject(5)};
				idsCentros.add(Integer.valueOf(String.valueOf(aux.getObject(1))));
				dtmCentros.addRow(fila);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void addRowCentros(Centro c){
		String query = "INSERT INTO CENTRO2 (ID_C, NOMBRE_C, CALLE_C, COLONIA_C, TELEFONO_C) VALUES ("+Math.floor(Math.random()*1000)+",'"+c.getNombre()+"','"+c.getCalle()+"','"+c.getColonia()+"','"+c.getTelefono()+"')";
		try {
			bdConnection.getStament().executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Centro registrado con �xito.", "COMO&COMO: Actualizaci�n", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo realizar el alta del Centro.\nIntente de nuevo.", "COMO&COMO: Error",JOptionPane.ERROR_MESSAGE);
		}
		fillTableCentros(titCentrosAux);
	}
	
	public void deleteRowsCentros(int[] rowsSelected){
		for(int i=0; i<rowsSelected.length; i++){
			String query = "DELETE FROM CENTRO2 WHERE ID_C = '"+idsCentros.get(rowsSelected[i])+"'";
			try{
				bdConnection.getStament().executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Centro eliminado.","COMO&COMO: Actualizaci�n",JOptionPane.INFORMATION_MESSAGE);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		fillTableCentros(titCentrosAux);
	}
	// ----------------- M�TODOS DE EMPLEADOS ------------------------ //
	public void fillTableEmpleados(String[] titEmpleados){
		dtmEmpleados.setRowCount(0);
		dtmEmpleados.setColumnCount(0);
		dtmEmpleados.setColumnIdentifiers(titEmpleados);
		idsEmpleados.clear();
		try{
			ResultSet aux = bdConnection.getStament().executeQuery("SELECT * FROM EMPLEADO2");
			while(aux.next()){
				Object[] fila = {aux.getObject(2),aux.getObject(3),aux.getObject(4),aux.getObject(5), aux.getObject(6), aux.getObject(7), aux.getObject(8)};
				idsEmpleados.add(Integer.valueOf(String.valueOf(aux.getObject(1))));
				dtmEmpleados.addRow(fila);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void addRowEmpleados(Empleado e){
		String query = "INSERT INTO EMPLEADO2 (ID_E, RFC, NOMBRE_E, APATERNO_E, AMATERNO_E, CALLE_E, COLONIA_E, TELEFONO) VALUES ("+Math.floor(Math.random()*1000)+",'"+e.getRFC()+"','"+e.getNombre()+"','"+e.getPaterno()+"','"+e.getMaterno()+"','"+e.getCalle()+"','"+e.getColonia()+"','"+e.getTelefono()+"')";
		try {
			bdConnection.getStament().executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Empleado registrado con �xito.", "COMO&COMO: Actualizaci�n", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, "No se pudo realizar el alta del Empleado.\nIntente de nuevo.", "COMO&COMO: Error",JOptionPane.ERROR_MESSAGE);
		}
		fillTableEmpleados(titEmpleadosAux);
	}
	
	public void deleteRowsEmpleados(int[] rowsSelected){
		for(int i=0; i<rowsSelected.length; i++){
			String query = "DELETE FROM EMPLEADO2 WHERE ID_E = '"+idsEmpleados.get(rowsSelected[i])+"'";
			try{
				bdConnection.getStament().executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Empleado eliminado.","COMO&COMO: Actualizaci�n",JOptionPane.INFORMATION_MESSAGE);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		fillTableEmpleados(titEmpleadosAux);
	}
	// ----------------- M�TODOS DE FACTURAS ------------------------ //
	public void fillTableFacturas(String[] titFacturas){
		dtmFacturas.setRowCount(0);
		dtmFacturas.setColumnCount(0);
		dtmFacturas.setColumnIdentifiers(titFacturas);
		idsFacturas.clear();
		try{
			ResultSet aux = bdConnection.getStament().executeQuery("SELECT * FROM FACTURA2");
			while(aux.next()){
				Object[] fila = {aux.getObject(2),aux.getObject(3)};
				idsFacturas.add(Integer.valueOf(String.valueOf(aux.getObject(1))));
				dtmFacturas.addRow(fila);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void addRowFacturas(Factura f){
		String query = "INSERT INTO FACTURA2 (ID_F, DIA_F, MES_F, ANO_F) VALUES ("+Math.floor(Math.random()*1000)+",'"+f.getDia()+"','"+f.getMes()+"','"+f.getA�o()+"'";
		try {
			bdConnection.getStament().executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Factura registrada con �xito.", "COMO&COMO: Actualizaci�n", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo realizar el alta de la Factura.\nIntente de nuevo.", "COMO&COMO: Error",JOptionPane.ERROR_MESSAGE);
		}
		fillTableFacturas(titFacturasAux);
	}
	
	public void deleteRowsFacturas(int[] rowsSelected){
		for(int i=0; i<rowsSelected.length; i++){
			String query = "DELETE FROM FACTURA2 WHERE ID_F = '"+idsFacturas.get(rowsSelected[i])+"'";
			try{
				bdConnection.getStament().executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Factura eliminada.","COMO&COMO: Actualizaci�n",JOptionPane.INFORMATION_MESSAGE);
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		fillTableFacturas(titFacturasAux);
	}

	/**
	 * @see java.awt.event.ActionEvent
	 * Encargado de definir los eventos de todos los botones de la interfaz.<br>
	 * Aqu� se definen los eventos para agregar y eliminar objetos, as� como
	 * los eventos de la barra de menu.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Eventos de los botones DOCUMENTACI�N
				if(e.getSource()==documentation){
					try {
						Desktop.getDesktop().open(new File("files/project2.pdf"));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				// Se presion� la tecla de Salir.
				if(e.getSource()==exit){
					bdConnection.cierraConexion();
					JOptionPane.showMessageDialog(null, "Usted est� saliendo de COMO&COMO\nClic en Aceptar para salir.",
														"COMO&COMOM: Buen d�a",JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);
				}
		// --------------------- BOTONES CLIENTES --------------------------- //
		if(e.getSource()==btnClientes){
			vCliente.setVisible(true);
		}else if(e.getSource()==btnClientesE){
			deleteRowsClientes(tClientes.getSelectedRows());
		}else if(e.getSource()==vCliente.getBtnGuardar()){
			Cliente c = new Cliente(vCliente.getTxtNombre().getText(),
									vCliente.getTxtPaterno().getText(),
									vCliente.getTxtMaterno().getText(),
									vCliente.getTxtCalle().getText(),
									vCliente.getTxtColonia().getText());
			addRowClientes(c);
			vCliente.limpiaCliente();
			vCliente.dispose();
		}
		// --------------------- BOTONES PLATILLOS --------------------------- //
		if(e.getSource()==btnPlatillos){
			vPlatillo.setVisible(true);
		}else if(e.getSource()==btnPlatillosE){
			deleteRowsPlatillos(tPlatillos.getSelectedRows());
		}else if(e.getSource()==vPlatillo.getBtnGuardar()){
			Platillo p = new Platillo(vPlatillo.getTxtNombre().getText(),
									vPlatillo.getTxtDescripcion().getText(),
									Integer.valueOf(vPlatillo.getTxtPrecio().getText()),
									Integer.valueOf(vPlatillo.getTxtCantidad().getText()));
			addRowPlatillos(p);
			vPlatillo.limpiaPlatillo();
			vPlatillo.dispose();
		}
		// --------------------- BOTONES POBLACION --------------------------- //
		if(e.getSource()==btnPoblacion){
			vPoblacion.setVisible(true);
		}else if(e.getSource()==btnPoblacionE){
			deleteRowsPoblacion(tPoblacion.getSelectedRows());
		}else if(e.getSource()==vPoblacion.getBtnGuardar()){
			Poblacion p = new Poblacion(vPoblacion.getTxtNombre().getText(),
										Integer.valueOf(vPoblacion.getTxtHabitantes().getText()));
			addRowPoblacion(p);
			vPoblacion.limpiaPoblacion();
			vPoblacion.dispose();
		}
		// --------------------- BOTONES CENTROS --------------------------- //
		if(e.getSource()==btnCentros){
			vCentro.setVisible(true);
		}else if(e.getSource()==btnCentrosE){
			deleteRowsCentros(tCentros.getSelectedRows());
		}else if(e.getSource()==vCentro.getBtnGuardar()){
			Centro c = new Centro(vCentro.getTxtNombre().getText(),
									vCentro.getTxtCalle().getText(),
									vCentro.getTxtColonia().getText(),
									Integer.valueOf(vCentro.getTxtTelefono().getText()));
			addRowCentros(c);
			vCentro.limpiaCentro();
			vCentro.dispose();
		}
		// --------------------- BOTONES EMPLEADOS --------------------------- //
		if(e.getSource()==btnEmpleados){
			vEmpleado.setVisible(true);
		}else if(e.getSource()==btnEmpleadosE){
			deleteRowsEmpleados(tEmpleados.getSelectedRows());
		}else if(e.getSource()==vEmpleado.getBtnGuardar()){
			Empleado em = new Empleado(vEmpleado.getTxtRFC().getText(),
										vEmpleado.getTxtNombre().getText(),
										vEmpleado.getTxtPaterno().getText(),
										vEmpleado.getTxtMaterno().getText(),
										vEmpleado.getTxtCalle().getText(),
										vEmpleado.getTxtColonia().getText(),
										Integer.valueOf(vEmpleado.getTxtTelefono().getText()));
			addRowEmpleados(em);
			vEmpleado.limpiaEmpleado();
			vEmpleado.dispose();
		}
		// --------------------- BOTONES FACTURAS --------------------------- //
		if(e.getSource()==btnFacturas){
			vFactura.setVisible(true);
		}else if(e.getSource()==btnFacturasE){
			deleteRowsFacturas(tFacturas.getSelectedRows());
		}else if(e.getSource()==vFactura.getBtnGuardar()){
			Factura f = new Factura(Integer.valueOf(vFactura.getTxtDia().getText()),
											Integer.valueOf(vFactura.getTxtMes().getText()),
											Integer.valueOf(vFactura.getTxtA�o().getText()));
			addRowFacturas(f);
			vFactura.limpiaFactura();
			vFactura.dispose();
		}
	}

	/**
	 * @see javax.swing.event.ChangeEvent
	 * Recibe una pesta�a activa.<br>Manda a llamar a la tabla de esa pesta�a para que refresque los datos.
	 */
	@Override
	public void stateChanged(ChangeEvent arg0) {
			int n = pesta�as.getSelectedIndex();
			switch(n){
				case 0:
					fillTableClientes(titClientesAux);
					break;
				case 1:
					fillTablePlatillos(titPlatillosAux);
					break;
				case 2:
					fillTablePoblacion(titPoblacionAux);
					break;
				case 3:
					fillTableCentros(titCentrosAux);
					break;
				case 4:
					fillTableEmpleados(titEmpleadosAux);
					break;
				case 5:
					fillTableFacturas(titFacturasAux);
					break;
			}
	}

	/**
	 * @see javax.swing.event.ListSelectionEvent
	 * Recibe una lista de registros seleccionados de una tabla.<br>Desactiva todos los botones de las dem�s ventanas.
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource()==tClientes.getSelectionModel()){
			btnClientesE.setEnabled(true);
			btnPlatillosE.setEnabled(false);
			btnEmpleadosE.setEnabled(false);
			btnPoblacionE.setEnabled(false);
			btnFacturasE.setEnabled(false);
			btnCentrosE.setEnabled(false);
		}else if(e.getSource()==tPlatillos.getSelectionModel()){
			btnClientesE.setEnabled(false);
			btnPlatillosE.setEnabled(true);
			btnEmpleadosE.setEnabled(false);
			btnPoblacionE.setEnabled(false);
			btnFacturasE.setEnabled(false);
			btnCentrosE.setEnabled(false);
		}else if(e.getSource()==tPoblacion.getSelectionModel()){
			btnPoblacionE.setEnabled(true);
			btnClientesE.setEnabled(false);
			btnPlatillosE.setEnabled(false);
			btnEmpleadosE.setEnabled(false);
			btnFacturasE.setEnabled(false);
			btnCentrosE.setEnabled(false);
		}else if(e.getSource()==tCentros.getSelectionModel()){
			btnCentrosE.setEnabled(true);
			btnClientesE.setEnabled(false);
			btnPlatillosE.setEnabled(false);
			btnEmpleadosE.setEnabled(false);
			btnPoblacionE.setEnabled(false);
			btnFacturasE.setEnabled(false);
		}else if(e.getSource()==tEmpleados.getSelectionModel()){
			btnCentrosE.setEnabled(false);
			btnClientesE.setEnabled(false);
			btnPlatillosE.setEnabled(false);
			btnEmpleadosE.setEnabled(true);
			btnPoblacionE.setEnabled(false);
			btnFacturasE.setEnabled(false);
		}else if(e.getSource()==tFacturas.getSelectionModel()){
			btnCentrosE.setEnabled(false);
			btnClientesE.setEnabled(false);
			btnPlatillosE.setEnabled(false);
			btnEmpleadosE.setEnabled(false);
			btnPoblacionE.setEnabled(false);
			btnFacturasE.setEnabled(true);
		}
	}
}