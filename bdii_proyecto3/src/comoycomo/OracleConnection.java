package comoycomo;

// Imports necesarios para lograr la conexi�n.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class OracleConnection {
	private Connection con = null;
	private Statement sta = null;
	private final static String drv = "oracle.jdbc.driver.OracleDriver";
	private final static String strCon = "jdbc:oracle:thin:FREDDY/123456@localhost";
	
	public OracleConnection(){
		try {
			Class.forName(drv);
			con = DriverManager.getConnection(strCon);
			sta = con.createStatement();
			System.out.println("Conexi�n con Oracle establecida.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No ha sido posible conectarse con la Base de Datos.\nVerifique su Nombre de Usuario y/o Contrase�a.", 
												"COMO&COMO: Error de conexi�n", 
												JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
	}
	
	public Statement getStament(){
		return this.sta;
	}
	
	public void cierraConexion(){
		try{
			con.close();
			sta.close();
			System.out.println("Conexi�n con Oracle finalizada.");
		}catch(SQLException e){
			// No se pudo cerrar la conexi�n
			e.printStackTrace();
		}
	}
}