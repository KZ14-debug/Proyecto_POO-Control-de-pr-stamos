package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Control.Controladora;
import Logica.Item;
import Logica.Prestamo;
import Logica.Usuario;

public class ReporteItems extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tableListaDeItems;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public ReporteItems(JFrame frame) {
		setBounds(100, 100, 641, 458);
		setModal(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 605, 366);
		contentPanel.add(scrollPane);
		
		tableListaDeItems = new JTable();
		tableListaDeItems.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item", "Codigo", "Descripcion", "Categoria", "Tipo", "Prestamo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tableListaDeItems);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(e -> dispose());
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSalir.setBounds(526, 388, 89, 23);
		contentPanel.add(btnSalir);
		
		cargarTablaItemsReportados();
	}
	
	
	
	private void cargarTablaItemsReportados()
	{
			
		DefaultTableModel modelo = (DefaultTableModel) tableListaDeItems.getModel();

		modelo.setRowCount(0);

		ArrayList<Item> items = new ArrayList<>(Controladora.getInstance().mostrarListaItems().values());

	    Collections.sort(items, (item1, item2) -> item1.getNombre().compareToIgnoreCase(item2.getNombre()));
	    
	    
	    for(Item item : items)
		{
			
			String prestamosHechos = "";
			
			
			if(item.getPrestamo() == null)
			{
				prestamosHechos = "No hay prestamos asignados";
			}
			
			else
			{
				prestamosHechos = prestamosHechos + "P[" + item.getPrestamo().getIdPrestamo() + "]";
			}
			
			
			String nombreT;
			String categoriaI;

			if(item.getTipo() == null)
			{
			    nombreT = "Ninguno";
			}
			else
			{
			    nombreT = item.getTipo().getTipo();
			}
			
			
			if(item.getCategorias().isEmpty())
			{
			    categoriaI = "No agregada";
			}
			else
			{
			    categoriaI = item.getCategorias().toString();
			}
			
			modelo.addRow(new Object[]
					{
						item.getNombre(), item.getCodigoI(), item.getDescripcion(), categoriaI, nombreT, prestamosHechos
					});
		}
	    
	}
}
