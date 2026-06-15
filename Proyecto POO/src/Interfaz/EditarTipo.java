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

public class EditarTipo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombreTipo;
	private JButton btnCancelarT;
	private JButton btnEditarT;
	private boolean guardado;
	private String tipoOriginal;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public EditarTipo(JFrame frame, String nombreTipo) {
		setBounds(100, 100, 450, 212);
		setModal(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Editar Tipo");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNewLabel.setBounds(172, 11, 124, 20);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre tipo: ");
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(47, 67, 86, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textFieldNombreTipo = new JTextField();
			textFieldNombreTipo.setBounds(134, 64, 272, 20);
			contentPanel.add(textFieldNombreTipo);
			textFieldNombreTipo.setColumns(10);
		}
		{
			btnEditarT = new JButton("Editar");
			btnEditarT.addActionListener(e -> editarTipo());
			btnEditarT.setFont(new Font("Arial", Font.PLAIN, 12));
			btnEditarT.setBounds(92, 130, 89, 23);
			contentPanel.add(btnEditarT);
		}
		{
			btnCancelarT = new JButton("Cancelar");
			btnCancelarT.addActionListener(e -> dispose());
			btnCancelarT.setBounds(261, 130, 89, 23);
			contentPanel.add(btnCancelarT);
		}

	    cargarDatosTipo(nombreTipo);
	}
	
	private void cargarDatosTipo(String nombreTipo)
	{
	    tipoOriginal = nombreTipo;

	    textFieldNombreTipo.setText(nombreTipo);
	}
	
	
	private void editarTipo()
	{
		try
		{
			String nombreTipo = textFieldNombreTipo.getText().trim();

			if(nombreTipo.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Todos los espacios deben estar llenos");

				return;
			}
			
			Tipo nuevoTipo = new Tipo(nombreTipo);

			Controladora.getInstance().editarTipo(tipoOriginal, nuevoTipo);

			guardado = true;

			JOptionPane.showMessageDialog(this,"El tipo ha sido editado correctamente");

			dispose();
		}

		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, "Error: " + e.toString());
		}
	}
	
	
	public boolean isGuardado()
	{
		return guardado;
	}
	

}
