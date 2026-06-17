package Interfaz;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Alerta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarAlertaAPrestamo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldTiempoDeAparicionAlerta;
	private JComboBox comboBoxTipoDeAlerta;
	private JButton btnAgregarAlerta;
	private JButton btnCancelar;
	private Alerta alertaCreada;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public AgregarAlertaAPrestamo() {
		setBounds(100, 100, 348, 220);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Tipo de alerta:");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel.setBounds(24, 38, 86, 14);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblNewLabel_1 = new JLabel("Tiempo de aparicion:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(24, 71, 131, 14);
		contentPanel.add(lblNewLabel_1);
		
		textFieldTiempoDeAparicionAlerta = new JTextField();
		textFieldTiempoDeAparicionAlerta.setBounds(143, 68, 131, 20);
		contentPanel.add(textFieldTiempoDeAparicionAlerta);
		textFieldTiempoDeAparicionAlerta.setColumns(10);
		
		btnAgregarAlerta = new JButton("Agregar");
		btnAgregarAlerta.addActionListener(e -> agregarAlerta());
		btnAgregarAlerta.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgregarAlerta.setBounds(39, 151, 89, 23);
		contentPanel.add(btnAgregarAlerta);
		
		comboBoxTipoDeAlerta = new JComboBox();
		comboBoxTipoDeAlerta.setModel(new DefaultComboBoxModel(new String[] {"Unica", "Frecuente"}));
		comboBoxTipoDeAlerta.setBounds(109, 34, 86, 22);
		contentPanel.add(comboBoxTipoDeAlerta);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(e -> dispose());
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar.setBounds(184, 151, 89, 23);
		contentPanel.add(btnCancelar);
	}
	
	public Alerta getAlerta()
	{
	    return alertaCreada;
	}
	
	
	private void agregarAlerta()
	{
		try
		{
			String mensaje = textFieldTiempoDeAparicionAlerta.getText().trim();
			
			if(mensaje.isEmpty())
			 {
				 JOptionPane.showMessageDialog(this,"El espacio debe estar lleno");
		         return;    
			 }
			
			int frecuencia = Integer.decode(mensaje);
			 
			alertaCreada = new Alerta("Tiene que devolver el item", frecuencia);
			
			dispose();
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(this,"El valor ingresado no es un tiempo valdio");
		}
	}
}
