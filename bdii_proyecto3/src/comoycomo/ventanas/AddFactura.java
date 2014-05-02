package comoycomo.ventanas;

import java.awt.FlowLayout;

import javax.swing.*;

import comoycomo.ComoyComo;

public class AddFactura extends JFrame{
	private static final long serialVersionUID = 1L;
	private ComoyComo gui;
	private JLabel lbDia, lbMes, lbA�o;
	private JTextField txtDia, txtMes, txtA�o;
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
		lbA�o = new JLabel("A�o");
		txtDia = new JTextField(15);
		txtMes = new JTextField(15);
		txtA�o = new JTextField(15);
		this.add(lbDia);
		this.add(txtDia);
		this.add(lbMes);
		this.add(txtMes);
		this.add(lbA�o);
		this.add(txtA�o);
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(gui);
		this.add(btnGuardar);
	}
	
	public void limpiaFactura(){
		txtDia.setText("");
		txtMes.setText("");
		txtA�o.setText("");
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

	public JLabel getLbA�o() {
		return lbA�o;
	}

	public JTextField getTxtDia() {
		return txtDia;
	}

	public JTextField getTxtMes() {
		return txtMes;
	}

	public JTextField getTxtA�o() {
		return txtA�o;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}
}
