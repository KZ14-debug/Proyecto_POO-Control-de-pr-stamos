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

import Control.Controladora;
import Logica.Categoria;
import Logica.Tipo;

public class EditarCategoria extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombreCategoria;
	private JButton btnEditarC;
	private boolean guardado;
	private String categoriaOriginal;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the dialog.
	 */
	public EditarCategoria(JFrame frame, String nombreCategoria) {
		setBounds(100, 100, 450, 222);
		setModal(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre categoria: ");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel.setBounds(24, 77, 112, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			textFieldNombreCategoria = new JTextField();
			textFieldNombreCategoria.setBounds(136, 74, 288, 20);
			contentPanel.add(textFieldNombreCategoria);
			textFieldNombreCategoria.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Editar Categoria");
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNewLabel_1.setBounds(159, 21, 103, 20);
			contentPanel.add(lblNewLabel_1);
		}
		{
			btnEditarC = new JButton("Editar");
			btnEditarC.addActionListener(e -> editarCategoria());
			btnEditarC.setFont(new Font("Arial", Font.PLAIN, 12));
			btnEditarC.setBounds(91, 141, 89, 23);
			contentPanel.add(btnEditarC);
		}
		{
			JButton btnCancelarC = new JButton("Cancelar");
			btnCancelarC.addActionListener(e -> dispose());
			btnCancelarC.setFont(new Font("Arial", Font.PLAIN, 12));
			btnCancelarC.setBounds(254, 141, 89, 23);
			contentPanel.add(btnCancelarC);
		}
		
		cargarDatosCategoria(nombreCategoria);
	}
	
	
	private void cargarDatosCategoria(String nombreCategoria)
	{
	    categoriaOriginal = nombreCategoria;

	    textFieldNombreCategoria.setText(nombreCategoria);
	}
	
	
	
	private void editarCategoria()
	{
		try
		{
			String nombreCategoria = textFieldNombreCategoria.getText().trim();

			if(nombreCategoria.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Todos los espacios deben estar llenos");

				return;
			}
			
			Categoria nuevaCategoria = new Categoria(nombreCategoria);

			Controladora.getInstance().editarCategoria(categoriaOriginal, nuevaCategoria);

			guardado = true;

			JOptionPane.showMessageDialog(this,"La categoria ha sido editada correctamente");

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
