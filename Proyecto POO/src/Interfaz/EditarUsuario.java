package Interfaz;

import java.awt.BorderLayout;


import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Control.Controladora;
import Logica.Tipo;
import Logica.Usuario;

public class EditarUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombreUsuario;
	private JTextField textFieldTelefonoUsuario;
	private JTextField textFieldCorreoUsuario;
	private JButton btnCancelarU;
	private JButton btnEditarU;
	private boolean guardado;
	private String nombreOriginal;
	private String telefonoOriginal;
	private String correoOriginal;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public EditarUsuario(JFrame frame, String nombre, String telefono, String correo) {
		setBounds(100, 100, 626, 268);
		setModal(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Editar Usuario");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNewLabel.setBounds(258, 21, 94, 20);
			contentPanel.add(lblNewLabel);
		}
		{
			textFieldNombreUsuario = new JTextField();
			textFieldNombreUsuario.setBounds(149, 69, 307, 20);
			contentPanel.add(textFieldNombreUsuario);
			textFieldNombreUsuario.setColumns(10);
		}
		{
			textFieldTelefonoUsuario = new JTextField();
			textFieldTelefonoUsuario.setBounds(149, 100, 307, 20);
			contentPanel.add(textFieldTelefonoUsuario);
			textFieldTelefonoUsuario.setColumns(10);
		}
		{
			textFieldCorreoUsuario = new JTextField();
			textFieldCorreoUsuario.setBounds(149, 134, 307, 20);
			contentPanel.add(textFieldCorreoUsuario);
			textFieldCorreoUsuario.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre: ");
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(83, 72, 56, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Telefono: ");
			lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(83, 103, 56, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Correo: ");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(83, 136, 46, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			btnEditarU = new JButton("Editar");
			btnEditarU.addActionListener(e -> editarUsuario());
			btnEditarU.setFont(new Font("Arial", Font.PLAIN, 12));
			btnEditarU.setBounds(149, 189, 89, 23);
			contentPanel.add(btnEditarU);
		}
		{
			btnCancelarU = new JButton("Cancelar");
			btnCancelarU.addActionListener(e -> dispose());
			btnCancelarU.setFont(new Font("Arial", Font.PLAIN, 12));
			btnCancelarU.setBounds(356, 189, 89, 23);
			contentPanel.add(btnCancelarU);
		}
		
		cargarDatosUsuario(nombre, telefono, correo);
	}
	
	
	private void cargarDatosUsuario(String nombre, String telefono, String correo)
	{
		nombreOriginal = nombre;
	    telefonoOriginal = telefono;
	    correoOriginal = correo;

	    textFieldNombreUsuario.setText(nombre);
	    textFieldTelefonoUsuario.setText(telefono);
	    textFieldCorreoUsuario.setText(correo);
	}
	
	
	private void editarUsuario()
	{
		try
		{
			String nombre = textFieldNombreUsuario.getText().trim();
			String telefono = textFieldTelefonoUsuario.getText().trim();
			String correo = textFieldCorreoUsuario.getText().trim();

			if(nombre.isEmpty() || telefono.isEmpty() || correo.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Todos los espacios deben estar llenos");

				return;
			}
			
			
			
			Usuario usuarioOriginal = Controladora.getInstance().buscarUsuario(correoOriginal);
			
			Usuario nuevoUsuario = new Usuario(nombre,correo,telefono,usuarioOriginal.getPrestamos());

			Controladora.getInstance().editarUsuario(correoOriginal, nuevoUsuario);

			guardado = true;

			JOptionPane.showMessageDialog(this,"El usuario ha sido editado correctamente");

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
