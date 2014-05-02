package comoycomo.ventanas;

import java.awt.FlowLayout;

import javax.swing.*;

import comoycomo.ComoyComo;

public class AddFactura extends JFrame{
	private static final long serialVersionUID = 1L;
	private ComoyComo gui;
	private JLabel lbDia, lbMes, lbAño;
	private JTextField txtDia, txtMes, txtAño;
	private JButton btnGuardar;
	
	public AddFactura(ComoyComo gui){
		super("Agregar Factura");
		this.gui = gui;
		this.setSize(300, 190);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		lbDia = new JLabel("Dia");
		lbMes = new JLabel("Mes");
		lbAño = new JLabel("Año");
		txtDia = new JTextField(15);
		txtMes = new JTextField(15);
		txtAño = new JTextField(15);
		this.add(lbDia);
		this.add(txtDia);
		this.add(lbMes);
		this.add(txtMes);
		this.add(lbAño);
		this.add(txtAño);
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(gui);
		this.add(btnGuardar);
	}
	
	public void limpiaFactura(){
		txtDia.setText("");
		txtMes.setText("");
		txtAño.setText("");
	}

	public ComoyComo getGui() {
		return gui;
	}

	public JLabel getLbDia() {
		return lbDia;
	}

	public JLabel getLbMes() {
		return lbMes;
	}

	public JLabel getLbAño() {
		return lbAño;
	}

	public JTextField getTxtDia() {
		return txtDia;
	}

	public JTextField getTxtMes() {
		return txtMes;
	}

	public JTextField getTxtAño() {
		return txtAño;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}
}
