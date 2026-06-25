package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.table.DefaultTableModel;

import Control.Controladora;
import Logica.Categoria;
import Logica.Item;

public class ReporteCategorias extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tableListaCategorias;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public ReporteCategorias(JFrame frame) {
		setBounds(100, 100, 631, 387);
		setModal(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 595, 277);
			contentPanel.add(scrollPane);
			{
				tableListaCategorias = new JTable();
				tableListaCategorias.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Categoria", "Item asociado"
					}
				));
				scrollPane.setViewportView(tableListaCategorias);
			}
		}
		{
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(e -> dispose());
			btnSalir.setFont(new Font("Arial", Font.PLAIN, 12));
			btnSalir.setBounds(516, 314, 89, 23);
			contentPanel.add(btnSalir);
		}
		
		cargarTablaDeCategorias();
	}
	
	
	private void cargarTablaDeCategorias()
	{
		DefaultTableModel modelo = (DefaultTableModel) tableListaCategorias.getModel();

		modelo.setRowCount(0);
		
		
		ArrayList<Categoria> categorias = new ArrayList<>(Controladora.getInstance().mostrarListaCategorias());

	    Collections.sort(categorias,(categ1, categ2) -> categ1.getCategoria().compareToIgnoreCase(categ2.getCategoria()));
	    
	    

		for(Categoria categoria : categorias)
		{
			
			String nombreI = " ";

			for(Item item: Controladora.getInstance().mostrarListaItems().values())
			{
			    if(item.getCategorias().contains(categoria))
			    {
			        nombreI = nombreI + item.getNombre() + ", ";
			    }
			}
			
			
			modelo.addRow(new Object[]
			{
				categoria.getCategoria(), nombreI
			});
		}
	}

}
