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
import Logica.Item;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;

public class VerCategoria extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombreCategoria;
	private JTable tableItemsLigados;
	private JButton btnRegresar;
	private String categoriaOriginal;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the dialog.
	 */
	public VerCategoria(JFrame frame, String nombreCategoria) {
		setBounds(100, 100, 497, 337);
		setModal(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Categoria: ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setBounds(22, 27, 64, 14);
		contentPanel.add(lblNewLabel);
		
		textFieldNombreCategoria = new JTextField();
		textFieldNombreCategoria.setBounds(96, 24, 86, 20);
		contentPanel.add(textFieldNombreCategoria);
		textFieldNombreCategoria.setColumns(10);
		
		btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(e -> dispose());
		btnRegresar.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRegresar.setBounds(382, 264, 89, 23);
		contentPanel.add(btnRegresar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 362, 234);
		contentPanel.add(scrollPane);
		
		tableItemsLigados = new JTable();
		tableItemsLigados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Items Asociados"
			}
		));
		scrollPane.setViewportView(tableItemsLigados);

		
		cargarDatosCategoria(nombreCategoria);
	}
	
	
	private void cargarDatosCategoria(String nombreCategoria)
	{
	    categoriaOriginal = nombreCategoria;

	    textFieldNombreCategoria.setText(nombreCategoria);
	    
	    DefaultTableModel modelo = (DefaultTableModel) tableItemsLigados.getModel();

		modelo.setRowCount(0);
		
		String itemVinculado;

		 
		for(Item item : Controladora.getInstance().mostrarListaItems().values())
		{
			if(item.getTipo() != null && item.getTipo().getTipo().equals(nombreCategoria))
			{
		    
				modelo.addRow(new Object[]
		            {
		                "Codigo[" + item.getCodigoI() + "], " + item.getNombre()
		            });    
			}    
		}
	}	
}
