package Interfaz;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.util.ArrayList;
import Control.Controladora;
import Logica.Categoria;
import Logica.Item;
import Logica.Tipo;
import javax.swing.JList;


public class AgregarItem extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombreItem;
	private JTextField textFieldDescripcionItem;
	private JCheckBox chckbxDisponibleItem;
	private JButton btnAgregarI;
	private JComboBox comboBoxTipo;
	private JList<Categoria> listaCategorias;
	private JButton btnCancelarI;
	private boolean guardado;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public AgregarItem(JFrame frame) {
		setBounds(100, 100, 617, 323);
		setModal(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Agregar Item");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNewLabel.setBounds(262, 11, 86, 28);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre: ");
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(116, 60, 59, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Descripcion: ");
			lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(116, 88, 80, 14);
			contentPanel.add(lblNewLabel_2);
		}
		
		chckbxDisponibleItem = new JCheckBox("Disponible");
		chckbxDisponibleItem.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxDisponibleItem.setBounds(373, 161, 97, 23);
		contentPanel.add(chckbxDisponibleItem);
		
		JLabel lblNewLabel_3 = new JLabel("Categoria: ");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(116, 130, 67, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo: ");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(371, 130, 46, 14);
		contentPanel.add(lblNewLabel_4);
		
		textFieldNombreItem = new JTextField();
		textFieldNombreItem.setBounds(171, 57, 327, 20);
		contentPanel.add(textFieldNombreItem);
		textFieldNombreItem.setColumns(10);
		
		textFieldDescripcionItem = new JTextField();
		textFieldDescripcionItem.setBounds(193, 85, 305, 20);
		contentPanel.add(textFieldDescripcionItem);
		textFieldDescripcionItem.setColumns(10);
		
		listaCategorias = new JList<>();
		JScrollPane scrollCategorias = new JScrollPane(listaCategorias);
		scrollCategorias.setBounds(193, 126, 150, 80);
		contentPanel.add(scrollCategorias);
		
		listaCategorias.setSelectionMode(
			    ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
			);
		
		comboBoxTipo = new JComboBox();
		comboBoxTipo.setBounds(412, 126, 71, 22);
		contentPanel.add(comboBoxTipo);
		
		btnAgregarI = new JButton("Agregar");
		btnAgregarI.addActionListener(e -> GuardarItem());
		btnAgregarI.setFont(new Font("Arial", Font.PLAIN, 11));
		btnAgregarI.setBounds(175, 250, 89, 23);
		contentPanel.add(btnAgregarI);
		
		btnCancelarI = new JButton("Cancelar");
		btnCancelarI.addActionListener(e -> dispose());
		btnCancelarI.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCancelarI.setBounds(361, 250, 89, 23);
		contentPanel.add(btnCancelarI);
		
		cargarTipos();
		cargarCategorias();
	}
	
	private void GuardarItem()
	{
		try
		{
			String nombre = textFieldNombreItem.getText().trim();
			String descripcion = textFieldDescripcionItem.getText().trim();
			Tipo tipo = (Tipo) comboBoxTipo.getSelectedItem();
			java.util.List<Categoria> categoriasSeleccionadas = listaCategorias.getSelectedValuesList();
			boolean disponible = chckbxDisponibleItem.isSelected();
			
			
			if(nombre.isEmpty() || descripcion.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Todos los espacios deben estar llenos");
				return;
			}
			
			if(categoriasSeleccionadas.isEmpty())
	        {
	            JOptionPane.showMessageDialog(this, "Debe seleccionar una categoría");
	            
	            return;
	        }
			
			
			Controladora controladora = Controladora.getInstance();
			
			Item item = new Item(nombre, descripcion, disponible, 0, tipo, new ArrayList<>(), null);
			
			
			for(Categoria categoria : categoriasSeleccionadas)
			{
				item.agregarCategoria(categoria);
			}
			

	        Controladora.getInstance().crearItem(item);
			
			guardado = true;
			
			
			JOptionPane.showMessageDialog(this, "Item agregado correctamente");

	        dispose();
		}
		
		catch(Exception e)
	    {
	        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
	    }
	}
	
	
	public boolean isGuardado()
	{
		return guardado;
	}
	
	
	
	private void cargarTipos()
	{
		
	    comboBoxTipo.removeAllItems();

	    if(Controladora.getInstance().mostrarListaTipos().isEmpty())
	    {
	    	comboBoxTipo.addItem(new Tipo("Ninguno"));
	    }
	    else
	    {
		    for(Tipo tipo : Controladora.getInstance().mostrarListaTipos())
		    {
		        comboBoxTipo.addItem(tipo);
		    }
	    }
	}
	
	
	private void cargarCategorias()
	{
		
	    DefaultListModel<Categoria> modelo = new DefaultListModel<>();

	    
	    for(Categoria categoria : Controladora.getInstance().mostrarListaCategorias())
	    {
	        modelo.addElement(categoria);
	    }
	    

	    listaCategorias.setModel(modelo);
	}
}
