package Interfaz;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Control.Controladora;
import Logica.Prestamo;
import Logica.Usuario;

import javax.swing.JList;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ReporteUsuarios extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton btnCerrar;
	private JTable tableListaDeUsuarios;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public ReporteUsuarios(JFrame frame) {
		setBounds(100, 100, 606, 394);
		setModal(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(e -> dispose());
		btnCerrar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCerrar.setBounds(491, 321, 89, 23);
		contentPanel.add(btnCerrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 570, 290);
		contentPanel.add(scrollPane);
		
		tableListaDeUsuarios = new JTable();
		scrollPane.setViewportView(tableListaDeUsuarios);
		tableListaDeUsuarios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Telefono", "Correo", "Prestamos"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		cargarTablaUsuariosReportados();
	}
	
	private void cargarTablaUsuariosReportados()
	{
		
		DefaultTableModel modelo = (DefaultTableModel) tableListaDeUsuarios.getModel();

		modelo.setRowCount(0);

		for(Usuario usuario : Controladora.getInstance().mostrarListaUsuarios().values())
		{
			
			String prestamosHechos = "";
			
			
			if(usuario.getPrestamos().isEmpty())
			{
				prestamosHechos = "No hay prestamos registrados";
			}
			
			else
			{
				
				for(Prestamo prestamo : usuario.getPrestamos().values())
				{
					prestamosHechos = prestamosHechos + "P[" + prestamo.getIdPrestamo() + "]" + ", ";
				}
				
			}
			
			
			modelo.addRow(new Object[]
					{
						usuario.getNombre(), usuario.getCorreo(), usuario.getTelefono(), prestamosHechos
					});
		}
	}
}
