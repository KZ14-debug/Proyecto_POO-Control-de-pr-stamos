package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Control.Controladora;
import Logica.Item;
import Logica.Usuario;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;

public class AgregarUsuarioAPrestamo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tableUsuariosParaAgregarAPrestamo;
	private JButton btnAgregarUaP;
	private JButton btnCancelarUaP;
	private Usuario usuarioSeleccionado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarUsuarioAPrestamo dialog = new AgregarUsuarioAPrestamo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarUsuarioAPrestamo() {
		setBounds(100, 100, 637, 372);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(25, 21, 571, 242);
			contentPanel.add(scrollPane);
			{
				tableUsuariosParaAgregarAPrestamo = new JTable();
				tableUsuariosParaAgregarAPrestamo.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Nombre", "Correo", "Telefono"
					}
				) {
					
					@Override
					
					public boolean isCellEditable(int row, int column)
					{
						return false;	
					}
					 
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				scrollPane.setViewportView(tableUsuariosParaAgregarAPrestamo);
			}
		}
		{
			btnAgregarUaP = new JButton("Agregar");
			btnAgregarUaP.addActionListener(e -> agregarUsuarioAPrestamo());
			btnAgregarUaP.setFont(new Font("Arial", Font.PLAIN, 12));
			btnAgregarUaP.setBounds(128, 293, 104, 29);
			contentPanel.add(btnAgregarUaP);
		}
		{
			btnCancelarUaP = new JButton("Cancelar");
			btnCancelarUaP.addActionListener(e -> dispose());
			btnCancelarUaP.setFont(new Font("Arial", Font.PLAIN, 12));
			btnCancelarUaP.setBounds(364, 293, 104, 29);
			contentPanel.add(btnCancelarUaP);
		}
		
		cargarUsuariosDisponibles();
	}
	
	public Usuario getUsuarioSeleccionado()
	{
	    return usuarioSeleccionado;
	}
	
	
	
	private void cargarUsuariosDisponibles()
	{
		DefaultTableModel model = (DefaultTableModel) tableUsuariosParaAgregarAPrestamo.getModel();
		
		model.setRowCount(0);
		
		
		for(Usuario usuario : Controladora.getInstance().mostrarListaUsuarios().values())
		{
			
			model.addRow(new Object[]
					{
						
						usuario.getNombre(), usuario.getCorreo(), usuario.getTelefono()
					});
		}
	}
	
	
	private void agregarUsuarioAPrestamo()
	{
		
		int fila = tableUsuariosParaAgregarAPrestamo.getSelectedRow();
		
		if(fila == -1)
	    {
	        JOptionPane.showMessageDialog(this,"Debe seleccionar un usuario para hacer el prestamo");
	        
	        return;
	    }
		
		
		 DefaultTableModel model = (DefaultTableModel) tableUsuariosParaAgregarAPrestamo.getModel();
		 
		 String correo= (String) model.getValueAt(fila, 1);
		 
		 Usuario usuario = Controladora.getInstance().buscarUsuario(correo);
		 
		 usuarioSeleccionado = usuario;
		 
		 dispose();
	}

}
