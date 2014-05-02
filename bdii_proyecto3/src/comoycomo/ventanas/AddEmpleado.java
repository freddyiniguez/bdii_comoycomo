package comoycomo.ventanas;

import java.awt.FlowLayout;

import javax.swing.*;

import comoycomo.ComoyComo;

public class AddEmpleado extends JFrame{
	private static final long serialVersionUID = 1L;
	private ComoyComo gui;
	private JLabel lbRFC, lbNombre, lbPaterno, lbMaterno, lbCalle, lbColonia, lbTelefono;
	private JTextField txtRFC, txtNombre, txtPaterno, txtMaterno, txtCalle, txtColonia, txtTelefono;
	private JButton btnGuardar;
	
	public AddEmpleado(ComoyComo gui){
		super("Agregar Empleado");
		this.gui = gui;
		this.setSize(300, 190);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		lbRFC = new JLabel("RFC");
		lbNombre = new JLabel("Nombre");
		lbPaterno = new JLabel("Paterno");
		lbMaterno = new JLabel("Materno");
		lbCalle = new JLabel("Direccion");
		lbColonia = new JLabel("Colonia");
		lbTelefono = new JLabel("Telefono");
		txtRFC = new JTextField(15);
		txtNombre = new JTextField(15);
		txtPaterno = new JTextField(15);
		txtMaterno = new JTextField(15);
		txtCalle = new JTextField(15);
		txtColonia = new JTextField(15);
		txtTelefono = new JTextField(15);
		this.add(lbRFC);
		this.add(txtRFC);
		this.add(lbNombre);
		this.add(txtNombre);
		this.add(lbPaterno);
		this.add(txtPaterno);
		this.add(lbMaterno);
		this.add(txtMaterno);
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
	
	public void limpiaEmpleado(){
		txtRFC.setText("");
		txtNombre.setText("");
		txtPaterno.setText("");
		txtMaterno.setText("");
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

	public JLabel getLbRFC() {
		return lbRFC;
	}

	public JLabel getLbNombre() {
		return lbNombre;
	}

	public JLabel getLbPaterno() {
		return lbPaterno;
	}

	public JLabel getLbMaterno() {
		return lbMaterno;
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

	public JTextField getTxtRFC() {
		return txtRFC;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtPaterno() {
		return txtPaterno;
	}

	public JTextField getTxtMaterno() {
		return txtMaterno;
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
