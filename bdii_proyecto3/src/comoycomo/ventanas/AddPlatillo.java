package comoycomo.ventanas;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import comoycomo.ComoyComo;

public class AddPlatillo extends JFrame{
	private static final long serialVersionUID = 1L;
	private ComoyComo gui;
	private JLabel lbNombre, lbDescripcion, lbPrecio, lbCantidad;
	private JTextField txtNombre, txtDescripcion, txtPrecio, txtCantidad;
	private JButton btnGuardar;
	
	public AddPlatillo(ComoyComo gui){
		super("Agregar Platillo");
		this.gui = gui;
		this.setSize(300, 190);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		lbNombre = new JLabel("Nombre");
		lbDescripcion = new JLabel("Descripcion");
		lbPrecio = new JLabel("Precio");
		lbCantidad = new JLabel("Cantidad");
		txtNombre = new JTextField(15);
		txtDescripcion = new JTextField(15);
		txtPrecio = new JTextField(15);
		txtCantidad = new JTextField(15);
		this.add(lbNombre);
		this.add(txtNombre);
		this.add(lbDescripcion);
		this.add(txtDescripcion);
		this.add(lbPrecio);
		this.add(txtPrecio);
		this.add(lbCantidad);
		this.add(txtCantidad);
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(gui);
		this.add(btnGuardar);
	}
	
	public void limpiaPlatillo(){
		txtNombre.setText("");
		txtDescripcion.setText("");
		txtPrecio.setText("");
		txtCantidad.setText("");
	}

	public ComoyComo getGui() {
		return gui;
	}

	public JLabel getLbNombre() {
		return lbNombre;
	}

	public JLabel getLbDescripcion() {
		return lbDescripcion;
	}

	public JLabel getLbPrecio() {
		return lbPrecio;
	}

	public JLabel getLbCantidad() {
		return lbCantidad;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtDescripcion() {
		return txtDescripcion;
	}

	public JTextField getTxtPrecio() {
		return txtPrecio;
	}

	public JTextField getTxtCantidad() {
		return txtCantidad;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}
}
