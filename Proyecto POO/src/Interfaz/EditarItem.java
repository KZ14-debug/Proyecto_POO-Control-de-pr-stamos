package Interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Control.Controladora;
import Logica.Categoria;
import Logica.Item;
import Logica.Tipo;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.util.List;

public class EditarItem extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombreItem;
	private JTextField textFieldDescripcionItem;
	private JList<Categoria> listListaCategorias;
	private JComboBox comboBoxListaTipos;
	private JCheckBox chckbxNewCheckBoxDisponibilidadItem;
	private int codigoOriginal;
	private boolean guardado;
	private JButton btnEditarI;
	private JButton btnCancelarI;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public EditarItem(JFrame frame, int codigo, String nombre, String descripcion, boolean disponible,String tipo) {
		setBounds(100, 100, 632, 324);
		setModal(true);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Editar Item");
			lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
			lblNewLabel.setBounds(283, 11, 74, 20);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Nombre: ");
			lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(111, 62, 58, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			textFieldNombreItem = new JTextField();
			textFieldNombreItem.setBounds(167, 59, 343, 20);
			contentPanel.add(textFieldNombreItem);
			textFieldNombreItem.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Descripcion: ");
			lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(111, 100, 72, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			textFieldDescripcionItem = new JTextField();
			textFieldDescripcionItem.setBounds(187, 97, 323, 20);
			contentPanel.add(textFieldDescripcionItem);
			textFieldDescripcionItem.setColumns(10);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Categoria: ");
			lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(111, 145, 72, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Tipo: ");
			lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 12));
			lblNewLabel_4.setBounds(370, 157, 46, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			comboBoxListaTipos = new JComboBox();
			comboBoxListaTipos.setBounds(404, 153, 97, 22);
			contentPanel.add(comboBoxListaTipos);
		}
		{
			chckbxNewCheckBoxDisponibilidadItem = new JCheckBox("Disponible");
			chckbxNewCheckBoxDisponibilidadItem.setFont(new Font("Arial", Font.PLAIN, 12));
			chckbxNewCheckBoxDisponibilidadItem.setBounds(370, 189, 97, 23);
			contentPanel.add(chckbxNewCheckBoxDisponibilidadItem);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(179, 144, 143, 69);
			contentPanel.add(scrollPane);
			{
				listListaCategorias = new JList<>();
				listListaCategorias.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				scrollPane.setViewportView(listListaCategorias);
			}
		}
		{
			btnEditarI = new JButton("Editar");
			btnEditarI.addActionListener(e -> editarItem());
			btnEditarI.setFont(new Font("Arial", Font.PLAIN, 12));
			btnEditarI.setBounds(158, 251, 89, 23);
			contentPanel.add(btnEditarI);
		}
		{
			btnCancelarI = new JButton("Cancelar");
			btnCancelarI.addActionListener(e -> dispose());
			btnCancelarI.setFont(new Font("Arial", Font.PLAIN, 12));
			btnCancelarI.setBounds(378, 251, 89, 23);
			contentPanel.add(btnCancelarI);
		}
	
		cargarTipos();
		cargarCategorias();
		cargarDatosItem(codigo, nombre, descripcion, disponible, tipo);
	
	}
	
	
	
	private void cargarDatosItem(int codigo, String nombre, String descripcion, boolean disponible,String tipo)
	{
		
	    codigoOriginal = codigo;

	    textFieldNombreItem.setText(nombre);
	    textFieldDescripcionItem.setText(descripcion);

	    comboBoxListaTipos.setSelectedItem(tipo);

	    chckbxNewCheckBoxDisponibilidadItem.setSelected(disponible);
	    
	    
	    for(int i = 0; i < comboBoxListaTipos.getItemCount(); i++)
	    {
	        Tipo t = (Tipo) comboBoxListaTipos.getItemAt(i);

	        
	        if(t.toString().equals(tipo))
	        {
	            comboBoxListaTipos.setSelectedIndex(i);
	            break;
	        }
	        
	    }
	}
	
	
	
	private void editarItem()
	{
		try
		{
			
			String nombre = textFieldNombreItem.getText().trim();
	        String descripcion = textFieldDescripcionItem.getText().trim();
	        Tipo tipo = (Tipo) comboBoxListaTipos.getSelectedItem();
	        boolean disponible = chckbxNewCheckBoxDisponibilidadItem.isSelected();
	        List<Categoria> categoriasSeleccionadas = listListaCategorias.getSelectedValuesList();

			if(nombre.isEmpty() || descripcion.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "Todos los espacios deben estar llenos");

				return;
			}
			
			Item itemOriginal = Controladora.getInstance().buscarItem(codigoOriginal);
			
			Item nuevoItem = new Item(nombre, descripcion, disponible, codigoOriginal, tipo, categoriasSeleccionadas, itemOriginal.getPrestamo());

			Controladora.getInstance().editarItem(codigoOriginal, nuevoItem);

			guardado = true;

			JOptionPane.showMessageDialog(this,"El item ha sido editado correctamente");

			dispose();
		}

		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, "Error: " + e.toString());
		}
	}
	
	
	public boolean isGuardado()
	{
		return guardado;
	}


	
	
	private void cargarTipos()
	{
		
	    comboBoxListaTipos.removeAllItems();

	    
	    for(Tipo tipo : Controladora.getInstance().mostrarListaTipos())
	    {
	        comboBoxListaTipos.addItem(tipo);
	    }
	    
	}
	
	private void cargarCategorias()
	{
		
	    DefaultListModel<Categoria> modelo = new DefaultListModel<>();

	    
	    for(Categoria categoria : Controladora.getInstance().mostrarListaCategorias())
	    {
	        modelo.addElement(categoria);
	    }
	    

	    listListaCategorias.setModel(modelo);
	}
}
