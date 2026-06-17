package Interfaz;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import Control.Controladora;
import Logica.Item;

public class AgregarItemAPrestamo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tableItemsParaPrestar;
	private JButton btnAgregarItemAPrestamo;
	private JButton btnCancelar;
	private Item itemSeleccionado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarItemAPrestamo dialog = new AgregarItemAPrestamo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarItemAPrestamo() {
		setBounds(100, 100, 617, 312);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 11, 436, 251);
		contentPanel.add(scrollPane);
		
		tableItemsParaPrestar = new JTable();
		tableItemsParaPrestar.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Codigo", "Descripcion", "Categoria", "Tipo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableItemsParaPrestar.setFont(new Font("Arial", Font.PLAIN, 12));
		scrollPane.setViewportView(tableItemsParaPrestar);
		
		btnAgregarItemAPrestamo = new JButton("Agregar");
		btnAgregarItemAPrestamo.addActionListener(e -> agregarItemAPrestamo());
		btnAgregarItemAPrestamo.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgregarItemAPrestamo.setBounds(485, 83, 106, 33);
		contentPanel.add(btnAgregarItemAPrestamo);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(e -> dispose());
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelar.setBounds(485, 148, 106, 33);
		contentPanel.add(btnCancelar);
		
		cargarItemsDisponibles();
	}
	
	public Item getItemSeleccionado()
	{
	    return itemSeleccionado;
	}
	
	
	private void cargarItemsDisponibles()
	{
		DefaultTableModel model = (DefaultTableModel) tableItemsParaPrestar.getModel();
		
		model.setRowCount(0);
		
		
		for(Item item : Controladora.getInstance().mostrarListaItems().values())
		{
			
			if(item.getPrestamo() == null)
			{
				
				model.addRow(new Object[]
				{
					
					item.getNombre(), item.getCodigoI(), item.getDescripcion(), item.getCategorias(), item.getTipo()
				});
			}
			
		}
	}
	
	
	private void agregarItemAPrestamo()
	{
		
		int fila = tableItemsParaPrestar.getSelectedRow();
		
		if(fila == -1)
	    {
	        JOptionPane.showMessageDialog(this,"Debe seleccionar un item para hacer el prestamo");
	        
	        return;
	    }
		
		
		 DefaultTableModel model = (DefaultTableModel) tableItemsParaPrestar.getModel();
		 
		 int codigoI = (int) model.getValueAt(fila, 1);
		 
		 Item item = Controladora.getInstance().buscarItem(codigoI);
		 
		 itemSeleccionado = item;
		 
		 dispose();
	}
}
