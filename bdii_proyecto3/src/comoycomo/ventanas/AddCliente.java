package comoycomo.ventanas;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import comoycomo.ComoyComo;

public class AddCliente extends JFrame{
	private static final long serialVersionUID = 1L;
	private ComoyComo gui;
	private JLabel lbNombre, lbPaterno, lbMaterno, lbCalle, lbColonia;
	private JTextField txtNombre, txtPaterno, txtMaterno, txtCalle, txtColonia;
	private JButton btnGuardar;
	
	public AddCliente(ComoyComo gui){
		super("Agregar Cliente");
		this.gui=gui;
		this.setSize(300, 190);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		lbNombre = new JLabel("Nombre                  ");
		lbPaterno = new JLabel("Apellido paterno   ");
		lbMaterno = new JLabel("Apellido materno  ");
		lbCalle = new JLabel("Dirección                ");
		lbColonia = new JLabel("Colonia                    ");
		txtNombre = new JTextField(15);
		txtPaterno = new JTextField(15);
		txtMaterno = new JTextField(15);
		txtCalle = new JTextField(15);
		txtColonia = new JTextField(15);
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
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(gui);
		this.add(btnGuardar);
	}
	
	public void limpiaCliente(){
		txtNombre.setText("");
		txtPaterno.setText("");
		txtMaterno.setText("");
		txtCalle.setText("");
		txtColonia.setText("");
	}

	public ComoyComo getGui() {
		return gui;
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

	public JButton getBtnGuardar() {
		return btnGuardar;
	}
}
