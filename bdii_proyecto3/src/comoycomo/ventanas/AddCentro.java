package comoycomo.ventanas;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import comoycomo.ComoyComo;

public class AddCentro extends JFrame{
	private static final long serialVersionUID = 1L;
	private ComoyComo gui;
	private JLabel lbNombre, lbCalle, lbColonia, lbTelefono;
	private JTextField txtNombre, txtCalle, txtColonia, txtTelefono;
	private JButton btnGuardar;

	public AddCentro(ComoyComo gui){
		super("Agregar Centro");
		this.gui = gui;
		this.setSize(300, 190);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		lbNombre = new JLabel("Nombre");
		lbCalle = new JLabel("Calle");
		lbColonia = new JLabel("Colonia");
		lbTelefono = new JLabel("Telefono");
		txtNombre = new JTextField(15);
		txtCalle = new JTextField(15);
		txtColonia = new JTextField(15);
		txtTelefono = new JTextField(15);
		this.add(lbNombre);
		this.add(txtNombre);
		this.add(lbCalle);
		this.add(txtCalle);
		this.add(lbColonia);
		this.add(txtColonia);
		this.add(lbTelefono);
		this.add(txtTelefono);
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(gui);
		this.add(btnGuardar);
	}
	
	public void limpiaCentro(){
		txtNombre.setText("");
		txtCalle.setText("");
		txtColonia.setText("");
		txtTelefono.setText("");
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ComoyComo getGui() {
		return gui;
	}

	public JLabel getLbNombre() {
		return lbNombre;
	}

	public JLabel getLbCalle() {
		return lbCalle;
	}

	public JLabel getLbColonia() {
		return lbColonia;
	}

	public JLabel getLbTelefono() {
		return lbTelefono;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtCalle() {
		return txtCalle;
	}

	public JTextField getTxtColonia() {
		return txtColonia;
	}

	public JTextField getTxtTelefono() {
		return txtTelefono;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}
}
