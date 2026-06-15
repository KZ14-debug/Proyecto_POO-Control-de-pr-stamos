package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.Controladora;
import Logica.Tipo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarTipo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombreTipo;
	private JButton btnAgregarT;
	private JButton btnCancelarT;
	private boolean guardado;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public AgregarTipo(JFrame frame) {
		setBounds(100, 100, 626, 222);
		setModal(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agregar Tipo");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(254, 11, 99, 20);
		contentPanel.add(lblNewLabel);
		
		textFieldNombreTipo = new JTextField();
		textFieldNombreTipo.setBounds(232, 68, 225, 20);
		contentPanel.add(textFieldNombreTipo);
		textFieldNombreTipo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del tipo:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(123, 71, 99, 14);
		contentPanel.add(lblNewLabel_1);
		
		btnCancelarT = new JButton("Cancelar");
		btnCancelarT.addActionListener(e -> dispose());
		btnCancelarT.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelarT.setBounds(327, 150, 89, 23);
		contentPanel.add(btnCancelarT);
		
		btnAgregarT = new JButton("Agregar");
		btnAgregarT.addActionListener(e -> GuardarTipo());
		btnAgregarT.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgregarT.setBounds(176, 150, 89, 23);
		contentPanel.add(btnAgregarT);
	}
	
	public JTextField getTextFieldNombreTipo() {
		return textFieldNombreTipo;
	}

	public JButton getBtnAgregarT() {
		return btnAgregarT;
	}

	public JButton getBtnCancelarT() {
		return btnCancelarT;
	}
	
	
	private void GuardarTipo()
	{
		try
		{
			String nombreTipo = textFieldNombreTipo.getText().trim();
			
			if(nombreTipo.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Todos los espacios deben estar llenos");
				return;
			}
			
			Controladora controladora = Controladora.getInstance();
			
			
			Tipo tipo = new Tipo(nombreTipo);
			
			controladora.crearTipo(tipo);
			
			guardado = true;
			
			JOptionPane.showMessageDialog(this, "Tipo agregado correctamente");

	        dispose();
		}
		catch(Exception e)
	    {
	        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
	    }
	}
	
	public boolean isGuardado()
	{
		return guardado;
	}
	
}
