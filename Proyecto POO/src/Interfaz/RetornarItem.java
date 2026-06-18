package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Control.Controladora;
import Logica.Item;
import Logica.Prestamo;
import Logica.Usuario;

public class RetornarItem extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tableItemsDelPrestamo;
	private JButton btnRetornarItems;
	private JButton btnCancelarR;
	private List<Item> itemsPrestamo = new ArrayList<>();
	private Prestamo prestamo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public RetornarItem(JFrame frame, Prestamo prestamo) {
		setBounds(100, 100, 620, 378);
		setModal(true);
		setLocationRelativeTo(frame);
		this.prestamo = prestamo;
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 584, 253);
		contentPanel.add(scrollPane);
		
		tableItemsDelPrestamo = new JTable();
		tableItemsDelPrestamo.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre item", "Categoria", "Tipo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tableItemsDelPrestamo);
		
		btnRetornarItems = new JButton("Retornar");
		btnRetornarItems.addActionListener(e -> RetornarItemDelPrestamo());
		btnRetornarItems.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRetornarItems.setBounds(124, 296, 121, 32);
		contentPanel.add(btnRetornarItems);
		
		btnCancelarR = new JButton("Cancelar");
		btnCancelarR.addActionListener(e -> dispose());
		btnCancelarR.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelarR.setBounds(353, 296, 121, 32);
		contentPanel.add(btnCancelarR);
		
		
		cargarTablaItemsPrestados();
	}
	
	
	private void cargarTablaItemsPrestados()
	{
		
		DefaultTableModel model = (DefaultTableModel) tableItemsDelPrestamo.getModel();
		
		model.setRowCount(0);
		
		
		for(Item item : prestamo.getItems().values())
		{
			
			model.addRow(new Object[]
					{
						item.getCodigoI(), item.getNombre(), item.getCategorias(), item.getTipo()
			        });
		}
		
	}
	
	private void RetornarItemDelPrestamo()
	{
		
		int fila = tableItemsDelPrestamo.getSelectedRow();
		
		
		if(fila == -1)
		{
			JOptionPane.showMessageDialog(this,"Debe selccionar un item para hacer el retorno");
			return;
		}
		
		DefaultTableModel model = (DefaultTableModel) tableItemsDelPrestamo.getModel();

	    int codigo = (int) model.getValueAt(fila, 0);
		Item item = itemsPrestamo.get(fila);
		int respuesta = JOptionPane.showConfirmDialog(this, "El item \"" + item.getNombre() + "\" será devuelto.", "Confirmar devolucion", JOptionPane.YES_NO_OPTION);
		
		
		if(respuesta == JOptionPane.YES_OPTION)
		{
		
			prestamo.borrarItem(codigo);
			
			
	        item.setPrestamo(null);
			cargarTablaItemsPrestados();
			
			JOptionPane.showMessageDialog(this, "El item se ha retornado correctamente");
		}
	}
}
