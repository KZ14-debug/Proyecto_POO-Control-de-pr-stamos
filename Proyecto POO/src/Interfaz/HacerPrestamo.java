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
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Control.Controladora;

import java.util.ArrayList;
import java.util.List;

import Logica.Alerta;
import Logica.Item;
import Logica.Prestamo;
import Logica.Usuario;
import javax.swing.JCheckBox;

public class HacerPrestamo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tableListaDeItemsAPrestar;
	private JButton btnAgregarIaP;
	private JButton btnAgregarUaP;
	private JButton btnAgregarP;
	private JButton btnCancelarP;
	private JTextField textFieldNombreUsuarioParaPrestamo;
	private JTextField textFieldCorreoParaPrestamo;
	private JButton btnEliminarItemDePrestamo;
	private List<Item> itemsPrestamo = new ArrayList<>();
	private Usuario usuarioSeleccionado;
	private JButton btnAgregarAlertaAPrestamo;
	private JCheckBox chckbxActivarAlerta;
	private Alerta alertaPrestamo;
	private boolean guardado;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public HacerPrestamo(JFrame frame) {
		setBounds(100, 100, 630, 454);
		setModal(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hacer Prestamo");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(251, 11, 107, 23);
		contentPanel.add(lblNewLabel);
		
		btnAgregarIaP = new JButton("Agregar Item");
		btnAgregarIaP.addActionListener(e -> agregarItemAPrestamo());
		btnAgregarIaP.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgregarIaP.setBounds(10, 381, 130, 23);
		contentPanel.add(btnAgregarIaP);
		
		btnAgregarUaP = new JButton("Agregar Usuario");
		btnAgregarUaP.addActionListener(e -> agregarUsuarioAPrestamo());
		btnAgregarUaP.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgregarUaP.setBounds(10, 347, 130, 23);
		contentPanel.add(btnAgregarUaP);
		
		btnAgregarP = new JButton("Agregar");
		btnAgregarP.addActionListener(e -> guardarPrestamo());
		btnAgregarP.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgregarP.setBounds(416, 381, 89, 23);
		contentPanel.add(btnAgregarP);
		
		btnCancelarP = new JButton("Cancelar");
		btnCancelarP.addActionListener(e -> dispose());
		btnCancelarP.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelarP.setBounds(515, 381, 89, 23);
		contentPanel.add(btnCancelarP);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 123, 594, 204);
		contentPanel.add(scrollPane);
		
		tableListaDeItemsAPrestar = new JTable();
		tableListaDeItemsAPrestar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Codigo", "Descripcion", "Tipo", "Categoria"
			}
		) {
			
			@Override
		    public boolean isCellEditable(int row, int column)
		    {
		        return false;
		    }
			
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tableListaDeItemsAPrestar);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre usuario:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 61, 107, 14);
		contentPanel.add(lblNewLabel_1);
		
		textFieldNombreUsuarioParaPrestamo = new JTextField();
		textFieldNombreUsuarioParaPrestamo.setBounds(113, 59, 321, 17);
		contentPanel.add(textFieldNombreUsuarioParaPrestamo);
		textFieldNombreUsuarioParaPrestamo.setColumns(10);
		textFieldNombreUsuarioParaPrestamo.setEditable(false);
		
		JLabel lblNewLabel_2 = new JLabel("Correo:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 86, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		textFieldCorreoParaPrestamo = new JTextField();
		textFieldCorreoParaPrestamo.setBounds(66, 83, 368, 20);
		contentPanel.add(textFieldCorreoParaPrestamo);
		textFieldCorreoParaPrestamo.setColumns(10);
		textFieldCorreoParaPrestamo.setEditable(false);
		
		btnEliminarItemDePrestamo = new JButton("Eliminar item");
		btnEliminarItemDePrestamo.addActionListener(e -> eliminarItemDelPrestamo());
		btnEliminarItemDePrestamo.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminarItemDePrestamo.setBounds(150, 381, 105, 23);
		contentPanel.add(btnEliminarItemDePrestamo);
		
		btnAgregarAlertaAPrestamo = new JButton("Agregar Alerta");
		btnAgregarAlertaAPrestamo.addActionListener(e -> agregarAlerta());
		btnAgregarAlertaAPrestamo.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgregarAlertaAPrestamo.setBounds(150, 347, 117, 23);
		contentPanel.add(btnAgregarAlertaAPrestamo);
		
		chckbxActivarAlerta = new JCheckBox("Alerta");
		chckbxActivarAlerta.setEnabled(false);
		chckbxActivarAlerta.setBounds(507, 61, 97, 23);
		contentPanel.add(chckbxActivarAlerta);
	}
	
	
	
	private void agregarItemAPrestamo()
	{
		
		AgregarItemAPrestamo dialogo = new AgregarItemAPrestamo();
		
		dialogo.setModal(true);
		dialogo.setLocationRelativeTo(this);
		dialogo.setVisible(true);
		Item item = dialogo.getItemSeleccionado();
		
		
		if(item != null)
		{
			
			if(itemsPrestamo.contains(item))
			{
			    JOptionPane.showMessageDialog(this,"Este item ya esta agregado al préstamo");
			    return;
			}
			
			else
			{
				itemsPrestamo.add(item);
			}
	
			
			cargarTablaItemsParaPrestamo();
			
		}
	}
	
	
	private void cargarTablaItemsParaPrestamo()
	{
		
		DefaultTableModel model = (DefaultTableModel) tableListaDeItemsAPrestar.getModel();
		
		model.setRowCount(0);
		
		
		for(Item item : itemsPrestamo)
		{
			
			model.addRow(new Object[]
					{
			            item.getNombre(), item.getCodigoI(), item.getDescripcion(), item.getTipo(), item.getCategorias()
			        });
			
		}
		
	}
	
	
	private void eliminarItemDelPrestamo()
	{
		
		int fila = tableListaDeItemsAPrestar.getSelectedRow();
		
		
		if(fila == -1)
		{
			JOptionPane.showMessageDialog(this,"Debe selccionar un item para hacer el prestamo");
			return;
		}
		
		
		Item item = itemsPrestamo.get(fila);
		int respuesta = JOptionPane.showConfirmDialog(this, "El item \"" + item.getNombre() + "\" será eliminado.", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
		
		
		if(respuesta == JOptionPane.YES_OPTION)
		{
		
			itemsPrestamo.remove(fila);
			cargarTablaItemsParaPrestamo();
			
			JOptionPane.showMessageDialog(this, "El item se elimino correctamente");
		}
	}
	
	
	
	
	private void agregarUsuarioAPrestamo()
	{
		
		AgregarUsuarioAPrestamo dialogo = new AgregarUsuarioAPrestamo();
		
		dialogo.setModal(true);
		dialogo.setLocationRelativeTo(this);
		dialogo.setVisible(true);
		Usuario usuario = dialogo.getUsuarioSeleccionado();
		
		
		if(usuario != null)
		{
			
			usuarioSeleccionado = usuario;

	        textFieldNombreUsuarioParaPrestamo.setText(usuario.getNombre());
	        textFieldCorreoParaPrestamo.setText(usuario.getCorreo());
			
		}
	}
	
	
	private void agregarAlerta()
	{
		AgregarAlertaAPrestamo dialogo = new AgregarAlertaAPrestamo();
		dialogo.setModal(true);
		dialogo.setLocationRelativeTo(this);
		dialogo.setVisible(true);
		Alerta alerta = dialogo.getAlerta();
		
		if(alerta != null)
		{
			alertaPrestamo = alerta;
			chckbxActivarAlerta.setSelected(true);
			
			JOptionPane.showMessageDialog(this, "Alerta agregada correctamente");
		}
		
	}
	
	
	private void guardarPrestamo()
	{
		try
		{
			if(usuarioSeleccionado == null)
			{
				JOptionPane.showMessageDialog(this,"Debe seleccionar un usuario par realizar el prestamo");
	            return;
			}
			
			
			if(itemsPrestamo.isEmpty())
	        {
	            JOptionPane.showMessageDialog(this,"Debe agregar un item al prestamo");
	            return;
	        }
			
			
			
			Prestamo prestamo = Controladora.getInstance().hacerPrestamo(usuarioSeleccionado.getCorreo());
			
			
			
			for(Item item : itemsPrestamo)
	        {
	            prestamo.agregarItem(item);
	        }

			
	        if(alertaPrestamo != null)
	        {
	            prestamo.setAlerta(alertaPrestamo);
	        }
	        
	        guardado = true;
	        
	        JOptionPane.showMessageDialog(this, "Prestamo creado exitosamente");
	        
	        dispose();
		}
		catch(Exception e)
	    {
	        JOptionPane.showMessageDialog(this, e.getMessage());
	    }
	}
	
	
	public boolean isGuardado()
	{
		return guardado;
	}
	
}


