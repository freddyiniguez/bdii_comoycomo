package comoycomo.ventanas;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import comoycomo.ComoyComo;

public class AddPoblacion extends JFrame{
	private static final long serialVersionUID = 1L;
	private ComoyComo gui;
	private JLabel lbNombre, lbHabitantes;
	private JTextField txtNombre, txtHabitantes;
	private JButton btnGuardar;
	
	public AddPoblacion(ComoyComo gui){
		super("Agregar Población");
		this.gui = gui;
		this.setSize(300, 190);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		lbNombre = new JLabel("Nombre");
		lbHabitantes = new JLabel("Habitantes");
		txtNombre = new JTextField(15);
		txtHabitantes = new JTextField(15);
		this.add(lbNombre);
		this.add(txtNombre);
		this.add(lbHabitantes);
		this.add(txtHabitantes);
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(gui);
		this.add(btnGuardar);
	}
	
	public void limpiaPoblacion(){
		txtNombre.setText("");
		txtHabitantes.setText("");
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

	public JLabel getLbHabitantes() {
		return lbHabitantes;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public JTextField getTxtHabitantes() {
		return txtHabitantes;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}
}
