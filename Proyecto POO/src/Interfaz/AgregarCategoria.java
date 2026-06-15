package Interfaz;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.Controladora;
import Logica.Categoria;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

public class AgregarCategoria extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombreCategoria;
	private JButton btnCancelarC;
	private JButton btnAgregarC;
	private boolean guardado;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public AgregarCategoria(JFrame frame) {
		setBounds(100, 100, 450, 224);
		setModal(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Agregar Categoria");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNewLabel.setBounds(153, 22, 117, 23);
			contentPanel.add(lblNewLabel);
		}
		
		textFieldNombreCategoria = new JTextField();
		textFieldNombreCategoria.setBounds(141, 78, 283, 20);
		contentPanel.add(textFieldNombreCategoria);
		textFieldNombreCategoria.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre categoria: ");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(29, 81, 126, 14);
		contentPanel.add(lblNewLabel_1);
		
		btnAgregarC = new JButton("Agregar");
		btnAgregarC.addActionListener(e -> GuardarCategoria());
		btnAgregarC.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgregarC.setBounds(84, 145, 89, 23);
		contentPanel.add(btnAgregarC);
		
		btnCancelarC = new JButton("Cancelar");
		btnCancelarC.addActionListener(e -> dispose());
		btnCancelarC.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelarC.setBounds(270, 145, 89, 23);
		contentPanel.add(btnCancelarC);
	}
	
	public JTextField getTextFieldNombreCategoria() {
		return textFieldNombreCategoria;
	}

	public JButton getBtnAgregarC() {
		return btnAgregarC;
	}

	public JButton getBtnCancelarC() {
		return btnCancelarC;
	}
	
	
	private void GuardarCategoria()
	{
		try
		{
			String nombreCategoria = textFieldNombreCategoria.getText().trim();
			
			if(nombreCategoria.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Todos los espacios deben estar llenos");
				return;
			}
			
			Controladora controladora = Controladora.getInstance();
			
			
			Categoria categoria = new Categoria(nombreCategoria);
			
			controladora.crearCategoria(categoria);
			
			guardado = true;
			
			JOptionPane.showMessageDialog(this, "Categoria agregada correctamente");

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
