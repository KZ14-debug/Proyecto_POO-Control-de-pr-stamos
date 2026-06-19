package Interfaz;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

import Control.Controladora;
import Logica.Prestamo;
import Logica.Tipo;
import Logica.Usuario;

public class VerUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombreUsuario;
	private JTextField textFieldCorreoUsuario;
	private JTextField textFieldTelefonoUsuario;
	private JTable tablePrestamosUsuario;
	private JButton btnRegresar;
	private String nombreOriginal;
	private String telefonoOriginal;
	private String correoOriginal;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public VerUsuario(JFrame frame, String nombre, String telefono, String correo) {
		setBounds(100, 100, 638, 463);
		setModal(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 28, 61, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Correo:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 67, 46, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 104, 61, 14);
		contentPanel.add(lblNewLabel_2);
		
		textFieldNombreUsuario = new JTextField();
		textFieldNombreUsuario.setEditable(false);
		textFieldNombreUsuario.setBounds(66, 25, 197, 20);
		contentPanel.add(textFieldNombreUsuario);
		textFieldNombreUsuario.setColumns(10);
		
		textFieldCorreoUsuario = new JTextField();
		textFieldCorreoUsuario.setEditable(false);
		textFieldCorreoUsuario.setBounds(66, 64, 197, 20);
		contentPanel.add(textFieldCorreoUsuario);
		textFieldCorreoUsuario.setColumns(10);
		
		textFieldTelefonoUsuario = new JTextField();
		textFieldTelefonoUsuario.setEditable(false);
		textFieldTelefonoUsuario.setBounds(66, 101, 197, 20);
		contentPanel.add(textFieldTelefonoUsuario);
		textFieldTelefonoUsuario.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 173, 578, 165);
		contentPanel.add(scrollPane);
		
		tablePrestamosUsuario = new JTable();
		tablePrestamosUsuario.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Prestamos"
			}
		));
		scrollPane.setViewportView(tablePrestamosUsuario);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(e -> dispose());
		btnRegresar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRegresar.setBounds(487, 366, 89, 23);
		contentPanel.add(btnRegresar);
		
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
	    
	    
	    DefaultTableModel modelo = (DefaultTableModel) tablePrestamosUsuario.getModel();
	    modelo.setRowCount(0);


	    Usuario usuario = Controladora.getInstance().buscarUsuario(correo);

	    
	    for(Prestamo prestamo : usuario.getPrestamos().values())
        {
            modelo.addRow(new Object[]
            {
                "P[" + prestamo.getIdPrestamo() + "]: " + prestamo.getNombresItems()
            });
        }
	}
	
}
