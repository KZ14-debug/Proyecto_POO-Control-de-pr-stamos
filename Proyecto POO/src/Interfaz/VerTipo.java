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
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Control.Controladora;
import Logica.Item;

public class VerTipo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private String tipoOriginal;
	private JTextField textFieldNombreTipo;
	private JTable tableItemsLigados;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public VerTipo(JFrame frame, String nombreTipo) {
		setBounds(100, 100, 450, 300);
		setModal(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(20, 27, 46, 14);
		contentPanel.add(lblNewLabel);
		
		textFieldNombreTipo = new JTextField();
		textFieldNombreTipo.setBounds(55, 24, 270, 20);
		contentPanel.add(textFieldNombreTipo);
		textFieldNombreTipo.setColumns(10);
		
		JButton btnSalir = new JButton("Regresar");
		btnSalir.addActionListener(e -> dispose());
		btnSalir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnSalir.setBounds(335, 227, 89, 23);
		contentPanel.add(btnSalir);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 77, 305, 173);
		contentPanel.add(scrollPane);
		
		tableItemsLigados = new JTable();
		tableItemsLigados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Items asociados"
			}
		));
		scrollPane.setViewportView(tableItemsLigados);
		
		cargarDatosTipo(nombreTipo);
	}
	
	private void cargarDatosTipo(String nombreTipo)
	{
	    tipoOriginal = nombreTipo;

	    textFieldNombreTipo.setText(nombreTipo);
	    
	    DefaultTableModel modelo = (DefaultTableModel) tableItemsLigados.getModel();

		modelo.setRowCount(0);
		
		String itemVinculado;

		 
		for(Item item : Controladora.getInstance().mostrarListaItems().values())
		{
			if(item.getTipo() != null && item.getTipo().getTipo().equals(nombreTipo))
			{
		    
				modelo.addRow(new Object[]
		            {
		                "Codigo[" + item.getCodigoI() + "], " + item.getNombre()
		            });    
			}    
		}
	}	
}
