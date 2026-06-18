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

import javax.swing.table.DefaultTableModel;

import Control.Controladora;
import Logica.Categoria;
import Logica.Item;
import Logica.Tipo;

import javax.swing.JScrollPane;

public class ReporteTipo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tableListaTipos;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public ReporteTipo(JFrame frame) {
		setBounds(100, 100, 632, 386);
		setModal(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 596, 280);
			contentPanel.add(scrollPane);
			{
				tableListaTipos = new JTable();
				scrollPane.setViewportView(tableListaTipos);
				tableListaTipos.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Tipo", "Items Asociados"
					}
				));
			}
		}
		{
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(e -> dispose());
			btnSalir.setFont(new Font("Arial", Font.PLAIN, 12));
			btnSalir.setBounds(517, 313, 89, 23);
			contentPanel.add(btnSalir);
		}
		
		cargarTablaTipos();
	}
	
	
	
	
	private void cargarTablaTipos()
	{
		DefaultTableModel modelo = (DefaultTableModel) tableListaTipos.getModel();

		modelo.setRowCount(0);
		
		
		ArrayList<Tipo> tipos = new ArrayList<>(Controladora.getInstance().mostrarListaTipos());

	    Collections.sort(tipos,(tipo1, tipo2) -> tipo1.getTipo().compareToIgnoreCase(tipo2.getTipo()));
	    
	    

		for(Tipo tipo: tipos)
		{
			
			String nombreI = " ";

			for(Item item : tipo.getItems())
			{
			    nombreI = nombreI + item.getNombre() + ", ";
			}
			
			
			modelo.addRow(new Object[]
			{
				tipo.getTipo(), nombreI
			});
		}
	}
}
