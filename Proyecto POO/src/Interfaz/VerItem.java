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
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;

import Control.Controladora;
import Logica.Item;
import Logica.Prestamo;
import Logica.Tipo;
import Logica.Usuario;

public class VerItem extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable tableDatosItem;
	private JTextField textFieldNombreI;
	private JTextField textFieldDescripcionI;
	private JButton btnRegresar;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public VerItem(JFrame frame, int codigo) {
		setBounds(100, 100, 638, 327);
		setModal(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 114, 602, 96);
			contentPanel.add(scrollPane);
			{
				tableDatosItem = new JTable();
				tableDatosItem.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Codigo", "Tipo", "Categoria", "Prestamo", "Disponible"
					}
				) {
					@Override
					public boolean isCellEditable(int row, int column) {
						return false;
					}
					
					Class[] columnTypes = new Class[] {
						Integer.class, Object.class, Object.class, Object.class, Boolean.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				scrollPane.setViewportView(tableDatosItem);
			}
		}
		{
			btnRegresar = new JButton("Regresar");
			btnRegresar.addActionListener(e -> dispose());
			btnRegresar.setFont(new Font("Arial", Font.PLAIN, 12));
			btnRegresar.setBounds(523, 259, 89, 23);
			contentPanel.add(btnRegresar);
		}
		{
			JLabel lblNewLabel = new JLabel("Item:");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel.setBounds(10, 29, 46, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Descripcion: ");
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(10, 74, 72, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textFieldNombreI = new JTextField();
			textFieldNombreI.setEditable(false);
			textFieldNombreI.setBounds(51, 26, 289, 20);
			contentPanel.add(textFieldNombreI);
			textFieldNombreI.setColumns(10);
		}
		{
			textFieldDescripcionI = new JTextField();
			textFieldDescripcionI.setEditable(false);
			textFieldDescripcionI.setBounds(92, 71, 289, 20);
			contentPanel.add(textFieldDescripcionI);
			textFieldDescripcionI.setColumns(10);
		}
		
		cargarDatosItem(codigo);
	}
	
	
	
	private void cargarDatosItem(int codigo)
	{

		Item item = Controladora.getInstance().buscarItem(codigo);
		
	    textFieldNombreI.setText(item.getNombre());
	    textFieldDescripcionI.setText(item.getDescripcion());


	    DefaultTableModel modelo = (DefaultTableModel) tableDatosItem.getModel();

		modelo.setRowCount(0);
		
		String prestamoHecho;
         

        if(item.getPrestamo() == null)
        {
        	prestamoHecho = "Sin prestar";
        }
        
        else
        {
        	prestamoHecho = "P[" + item.getPrestamo().getIdPrestamo() + "]"; 
        }

         
        String nombreT;

		if(item.getTipo() == null)
		{
		    nombreT = "Ninguno";
		}
		else
		{
		    nombreT = item.getTipo().getTipo();
		}
		
		
        modelo.addRow(new Object[]
        		{
        				item.getCodigoI(), nombreT, item.getCategorias(),prestamoHecho,item.isDisponible()
         		});
	}
}
