package niktutos.examples;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import niktutos.others.FrameAddPerson;
import niktutos.others.Personas;

public class N44_45_46_47_48_JDBC {
	
	public static class GUI extends JFrame implements ActionListener{
		private static final long serialVersionUID = 1L;

		private final String[] titulos = {"Nombre","Dirección","Teléfono","Localidad"};
		
		private DefaultTableModel dtm = new DefaultTableModel();
		private JTable personTable = new JTable(dtm);
		private BDManagement bdm = new BDManagement();
		private JMenuBar menuBar;
		private JMenu actionMenu;
		private JMenuItem addMenuItem, removeMenuItem, readMenuItem, salir;
		private JScrollPane scroll;
		private List<Integer> ids = new ArrayList<Integer>();
		private FrameAddPerson fap;
		
		public GUI(){
			super("Titulo de la ventana");
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLayout(null);
			this.setSize(810,460);
			this.setLocationRelativeTo(null);
			
			menuBar = new JMenuBar();
			this.setJMenuBar(menuBar);
			actionMenu = new JMenu("Acciones");
			menuBar.add(actionMenu);
			addMenuItem  = new JMenuItem("Agregar Registro");
			removeMenuItem = new JMenuItem("Eliminar Registro");
			readMenuItem = new JMenuItem("Leer Registro");
			salir = new JMenuItem("Salir");
			actionMenu.add(addMenuItem);
			actionMenu.add(removeMenuItem);
			actionMenu.add(readMenuItem);
			actionMenu.add(salir);
			addMenuItem.addActionListener(this);
			removeMenuItem.addActionListener(this);
			readMenuItem.addActionListener(this);
			salir.addActionListener(this);
			
			// Se establecen los títulos para el DefaultTableModel
			// que llevará la tabla.
			//dtm.setColumnIdentifiers(titulos);
			// Así no se pueden editar los campos de la tabla.
			//personTable.setEnabled(false);
			
			scroll = new JScrollPane(personTable);
			scroll.setBounds(0, 0, 800, 400);
			this.add(scroll);
		}
		
		public JTable getPersonTable(){
			return this.personTable;
		}
		
		public void fillTable(){
			dtm.setRowCount(0);
			dtm.setColumnCount(0);
			dtm.setColumnIdentifiers(titulos);
			ids.clear();
			try{
				ResultSet aux = bdm.getStament().executeQuery("SELECT * FROM RealDelOro");
				while(aux.next()){
					Object[] fila = {aux.getObject(2),aux.getObject(3),aux.getObject(4),aux.getObject(5)};
					ids.add((Integer)aux.getObject(1));
					dtm.addRow(fila);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		public void deleteRows(int[] rowsSelected){
			for(int i=0; i<rowsSelected.length;i++){
				String query = "DELETE FROM RealDelOro WHERE idLocalidad="+ids.get(rowsSelected[i])+";";
				try {
					bdm.getStament().executeUpdate(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			this.fillTable();
		}
		
		public void addRow(Personas p){
			// En este ejemplo, el id de la tabla no estaba funcionando el AUTO_INCREMENT, por tanto
			// se debe de escribir un index que para probarlo es 3.
			String query = "INSERT INTO RealDelOro (Nombre, Direccion, Telefono, Localidad) VALUES ('"+p.getNya()+"','"+p.getDir()+"','"+p.getTel()+"','"+p.getLoc()+"');";
			try{
				bdm.getStament().executeUpdate(query);
			}catch(Exception ex){
				ex.printStackTrace();
			}
			this.fillTable();
		}
		
		@Override
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource()==addMenuItem){
				fap = new FrameAddPerson(this);
			}else if(ae.getSource()==removeMenuItem){
				this.deleteRows(personTable.getSelectedRows());
			}else if(ae.getSource()==readMenuItem){
				this.fillTable();
			}else if(ae.getSource()==fap.getBtnAgregar()){
				Personas p = new Personas(fap.getTxtNombreApellido().getText(),
						fap.getTxtTel().getText(),
						fap.getTxtLoc().getText(),
						fap.getTxtDir().getText());
				this.addRow(p);
				fap.dispose();
			}else if(ae.getSource()==salir){
				JOptionPane.showMessageDialog(null,"Usted está saliendo del programa","¡Adiós!",JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			}
		}
	} // Clase GUI
	
	public static class BDManagement{
		private final static String drv = "com.mysql.jdbc.Driver";
		private final static String db = "jdbc:mysql://localhost:3306/NikSchema";
		private final static String user = "root";
		private final static String pass = "123456";
		private Connection ct;
		private Statement st;
		
		public BDManagement(){
			try{
			Class.forName(drv);
			ct = DriverManager.getConnection(db, user, pass);
			st = ct.createStatement();
			System.out.println("Conexion exitosa.");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("No se ha podido realizar la conexión.");
			}
		}
		
		public Statement getStament(){
			return this.st;
		}
	} // Clase BDManagement

	public static void main(String[] args){
		GUI x = new GUI();
		x.setVisible(true);
	}
}

/*
	TUTORIAL 45 - JDBC
	
	
	package niktutos.examples;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;
	
	public static class BDManagement{
		// Se definen las variables para poder crear la conexión.
		// El driver (drv) es el de la biblioteca que se importó del
		// conector de MySQL para Java.
		private final static String drv = "com.mysql.jdbc.Driver";
		// El nombre de la base de datos
		private final static String db = "jdbc:mysql://localhost:3306/NikSchema";
		// Usuario y contraseña
		private final static String user = "root";
		private final static String pass = "123456";
		// Importar la Connection del paquete java.sql, no del de com.
		private Connection ct;
		// Para hacer consultas.
		private Statement st;
		
		public BDManagement(){
			try{
			// Se define el driver.
			Class.forName(drv);
			// Se define la conexión.
			ct = DriverManager.getConnection(db, user, pass);
			// Se define el stament para hacer consultas.
			st = ct.createStatement();
			System.out.println("Conexion exitosa.");
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("No se ha podido realizar la conexión.");
			}
		}
		
		public void showAll(){
			try{
				// Clase que maneja las consultas del Stament
				ResultSet rs = st.executeQuery("SELECT * FROM Personas");
				// Se recorren los registros de la consulta.
				while(rs.next()){
					System.out.println(rs.getString(1)+"\t|\t"+rs.getString(2)+"\t|\t"+rs.getString(3));
				}
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Error al realizar la consulta.");
			}
		}
	}
	
	public static void main(String[] args) {
		BDManagement bdm = new BDManagement();
		bdm.showAll();
	}
*/