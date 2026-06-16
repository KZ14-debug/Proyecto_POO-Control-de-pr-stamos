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
import javax.swing.JTextField;
import java.awt.Font;

import java.util.TreeMap;

import Control.Controladora;
import Logica.Usuario;


public class AgregarUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombreUsuario;
	private JTextField textFieldTelefonoUsuario;
	private JTextField textFieldCorreoUsuario;
	private JButton btnAgregarU;
	private JButton btnCancelarU;
	private boolean guardado;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public AgregarUsuario(JFrame frame) {
		setBounds(100, 100, 627, 286);
		setModal(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Agregar Usuario");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNewLabel.setBounds(235, 21, 110, 23);
			contentPanel.add(lblNewLabel);
		}
		{
			btnAgregarU = new JButton("Agregar");
			btnAgregarU.addActionListener(e -> GuardarUsuario());
			btnAgregarU.setFont(new Font("Arial", Font.PLAIN, 12));
			btnAgregarU.setBounds(141, 212, 89, 23);
			contentPanel.add(btnAgregarU);
		}
		{
			btnCancelarU = new JButton("Cancelar");
			btnCancelarU.addActionListener(e -> dispose());
			btnCancelarU.setFont(new Font("Arial", Font.PLAIN, 12));
			btnCancelarU.setBounds(396, 212, 89, 23);
			contentPanel.add(btnCancelarU);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre:  ");
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(87, 82, 63, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Telefono: ");
			lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(87, 120, 63, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Correo: ");
			lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(87, 155, 46, 14);
			contentPanel.add(lblNewLabel_3);
		}
		
		textFieldNombreUsuario = new JTextField();
		textFieldNombreUsuario.setBounds(146, 79, 353, 20);
		contentPanel.add(textFieldNombreUsuario);
		textFieldNombreUsuario.setColumns(10);
		
		textFieldTelefonoUsuario = new JTextField();
		textFieldTelefonoUsuario.setBounds(156, 117, 343, 20);
		contentPanel.add(textFieldTelefonoUsuario);
		textFieldTelefonoUsuario.setColumns(10);
		
		textFieldCorreoUsuario = new JTextField();
		textFieldCorreoUsuario.setBounds(143, 152, 356, 20);
		contentPanel.add(textFieldCorreoUsuario);
		textFieldCorreoUsuario.setColumns(10);
	}
	
	
	private void GuardarUsuario()
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
			
			Controladora controladora = Controladora.getInstance();
			
			Usuario usuario = new Usuario(nombre, correo, telefono, new TreeMap<>());
			
			controladora.crearUsuario(usuario);
			
			
			guardado = true;
			
			JOptionPane.showMessageDialog(this, "Usuario agregado correctamente");

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
