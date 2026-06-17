package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Control.Controladora;
import Logica.Alerta;
import Logica.Categoria;
import Logica.Item;
import Logica.Prestamo;
import Logica.Tipo;
import Logica.Usuario;

public class PantallaPrincipal {

	private JFrame frame;
	private JButton btnPantallaUsuario;
	private JButton btnPantallaItem;
	private JButton btnPantallaPrestamo;
	private JButton btnPantallaCategoria;
	private JButton btnPantallaTipo;
	private JButton btnPantallaAlerta;
	private JTable tableListaTipos;
	private JButton btnEditarTipo;
	private JButton btnEliminarTipo;
	private JButton btnAgregarTipo;
	private JTabbedPane tabbedPane;
	private JTable tableListaCategoria;
	private JButton btnAgregarCategoria;
	private JButton btnEditarCategoria;
	private JButton btnEliminarCategoria;
	private JTable tableListaUsuarios;
	private JButton btnAgregarUsuario;
	private JButton btnEditarUsuario;
	private JButton btnEliminarUsuario;
	private JTable tableListaItems;
	private JButton btnAgregarItem;
	private JButton btnEditarItem;
	private JButton btnEliminarItem;
	private JTable tableListaPrestamosHechos;
	private JButton btnAgregarP;
	private JButton btnRetornarItemDePrestamo;
	private Alerta alertaPrestamo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal window = new PantallaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PantallaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 632, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelPantallaPrincipal = new JPanel();
		tabbedPane.addTab("Pantalla Principal", null, panelPantallaPrincipal, null);
		panelPantallaPrincipal.setLayout(null);
		
		btnPantallaUsuario = new JButton("Usuarios");
		btnPantallaUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnPantallaUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPantallaUsuario.setBounds(266, 82, 89, 23);
		panelPantallaPrincipal.add(btnPantallaUsuario);
		
		JLabel lblNewLabel = new JLabel("Pantalla Principal");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(221, 27, 171, 23);
		panelPantallaPrincipal.add(lblNewLabel);
		
		btnPantallaItem = new JButton("Item");
		btnPantallaItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnPantallaItem.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPantallaItem.setBounds(266, 130, 89, 23);
		panelPantallaPrincipal.add(btnPantallaItem);
		
		btnPantallaPrestamo = new JButton("Prestamos");
		btnPantallaPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnPantallaPrestamo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPantallaPrestamo.setBounds(254, 178, 112, 23);
		panelPantallaPrincipal.add(btnPantallaPrestamo);
		
		btnPantallaCategoria = new JButton("Categorias");
		btnPantallaCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				tabbedPane.setSelectedIndex(4);
			}
		});
		btnPantallaCategoria.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPantallaCategoria.setBounds(254, 226, 112, 23);
		panelPantallaPrincipal.add(btnPantallaCategoria);
		
		btnPantallaTipo = new JButton("Tipos");
		btnPantallaTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				tabbedPane.setSelectedIndex(5);
			}
		});
		btnPantallaTipo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPantallaTipo.setBounds(266, 274, 89, 23);
		panelPantallaPrincipal.add(btnPantallaTipo);
		
		
		btnPantallaAlerta = new JButton("Alertas");
		btnPantallaAlerta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				tabbedPane.setSelectedIndex(6);
			}
		});
		btnPantallaAlerta.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPantallaAlerta.setBounds(266, 318, 89, 23);
		panelPantallaPrincipal.add(btnPantallaAlerta);
		
		JPanel panelPantallaUsuario = new JPanel();
		tabbedPane.addTab("Usuario", null, panelPantallaUsuario, null);
		panelPantallaUsuario.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Usuario");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_3.setBounds(255, 21, 73, 14);
		panelPantallaUsuario.add(lblNewLabel_3);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(25, 57, 452, 285);
		panelPantallaUsuario.add(scrollPane_2);
		
		tableListaUsuarios = new JTable();
		tableListaUsuarios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Telefono", "Correo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_2.setViewportView(tableListaUsuarios);
		
		btnAgregarUsuario = new JButton("Agregar");
		btnAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AgregarUsuario ventana = new AgregarUsuario(frame);
				ventana.setVisible(true);
				
				if(ventana.isGuardado())
				{
					cargarTablaUsuarios();
				}
			}
		});
		btnAgregarUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgregarUsuario.setBounds(497, 96, 89, 23);
		panelPantallaUsuario.add(btnAgregarUsuario);
		
		btnEditarUsuario = new JButton("Editar");
		btnEditarUsuario.addActionListener(e -> editarUsuario());
		btnEditarUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEditarUsuario.setBounds(497, 161, 89, 23);
		panelPantallaUsuario.add(btnEditarUsuario);
		
		btnEliminarUsuario = new JButton("Eliminar");
		btnEliminarUsuario.addActionListener(e -> borrarUsuario());
		btnEliminarUsuario.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminarUsuario.setBounds(497, 230, 89, 23);
		panelPantallaUsuario.add(btnEliminarUsuario);
		
		JPanel panelPantallaItem = new JPanel();
		tabbedPane.addTab("Item", null, panelPantallaItem, null);
		panelPantallaItem.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Item");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_4.setBounds(268, 22, 46, 14);
		panelPantallaItem.add(lblNewLabel_4);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(20, 61, 441, 272);
		panelPantallaItem.add(scrollPane_3);
		
		tableListaItems = new JTable();
		tableListaItems.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre item", "Codigo", "Disponible", "Descripcion", "Categoria", "Tipo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, Boolean.class, String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		scrollPane_3.setViewportView(tableListaItems);
		
		btnAgregarItem = new JButton("Agregar");
		btnAgregarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AgregarItem ventana = new AgregarItem(frame);
				ventana.setVisible(true);
				
				if(ventana.isGuardado())
				{
					cargarTablaItems();
				}
			}
		});
		btnAgregarItem.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgregarItem.setBounds(488, 116, 89, 23);
		panelPantallaItem.add(btnAgregarItem);
		
		btnEditarItem = new JButton("Editar");
		btnEditarItem.addActionListener(e -> editarItem());
		btnEditarItem.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEditarItem.setBounds(488, 167, 89, 23);
		panelPantallaItem.add(btnEditarItem);
		
		btnEliminarItem = new JButton("Borrar");
		btnEliminarItem.addActionListener(e -> borrarItem());
		btnEliminarItem.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminarItem.setBounds(488, 217, 89, 23);
		panelPantallaItem.add(btnEliminarItem);
		
		JPanel panelPantallaPrestamo = new JPanel();
		tabbedPane.addTab("Prestamo", null, panelPantallaPrestamo, null);
		panelPantallaPrestamo.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Prestamos");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_5.setBounds(255, 21, 74, 14);
		panelPantallaPrestamo.add(lblNewLabel_5);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(21, 62, 425, 284);
		panelPantallaPrestamo.add(scrollPane_4);
		
		tableListaPrestamosHechos = new JTable();
		tableListaPrestamosHechos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Usuario", "Items", "Alerta Activa"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_4.setViewportView(tableListaPrestamosHechos);
		
		btnAgregarP = new JButton("Crear Prestamo");
		btnAgregarP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				HacerPrestamo ventana = new HacerPrestamo(frame);
				ventana.setVisible(true);
				
				if(ventana.isGuardado())
				{
					cargarTablaPrestamos();
				}
			}
		});
		btnAgregarP.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgregarP.setBounds(467, 79, 121, 23);
		panelPantallaPrestamo.add(btnAgregarP);
		
		btnRetornarItemDePrestamo = new JButton("Retornar item");
		btnRetornarItemDePrestamo.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRetornarItemDePrestamo.setBounds(467, 123, 121, 23);
		panelPantallaPrestamo.add(btnRetornarItemDePrestamo);
		
		JButton btnFinalizarP = new JButton("Finalizar Prestamo");
		btnFinalizarP.setFont(new Font("Arial", Font.PLAIN, 12));
		btnFinalizarP.setBounds(467, 164, 121, 23);
		panelPantallaPrestamo.add(btnFinalizarP);
		
		JPanel panelPantallaCategoria = new JPanel();
		tabbedPane.addTab("Categoria", null, panelPantallaCategoria, null);
		panelPantallaCategoria.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Categoria");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setBounds(237, 22, 135, 23);
		panelPantallaCategoria.add(lblNewLabel_2);
		
		btnAgregarCategoria = new JButton("Agregar");
		btnAgregarCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AgregarCategoria ventana = new AgregarCategoria(frame);
				ventana.setVisible(true);
				
				if(ventana.isGuardado())
				{
					cargarTablaCategorias();
				}
			}
		});
		btnAgregarCategoria.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgregarCategoria.setBounds(480, 112, 89, 23);
		panelPantallaCategoria.add(btnAgregarCategoria);
		
		btnEditarCategoria = new JButton("Editar");
		btnEditarCategoria.addActionListener(e -> editarCategoria());
		btnEditarCategoria.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEditarCategoria.setBounds(480, 157, 89, 23);
		panelPantallaCategoria.add(btnEditarCategoria);
		
		btnEliminarCategoria = new JButton("Eliminar");
		btnEliminarCategoria.addActionListener(e -> borrarCategoria());
		btnEliminarCategoria.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminarCategoria.setBounds(480, 207, 89, 23);
		panelPantallaCategoria.add(btnEliminarCategoria);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(75, 70, 381, 244);
		panelPantallaCategoria.add(scrollPane_1);
		
		tableListaCategoria = new JTable();
		tableListaCategoria.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Lista de Categorias"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(tableListaCategoria);
		
		JPanel panelPantallaTipo = new JPanel();
		tabbedPane.addTab("Tipo", null, panelPantallaTipo, null);
		panelPantallaTipo.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(258, 21, 83, 23);
		panelPantallaTipo.add(lblNewLabel_1);
		
		btnAgregarTipo = new JButton("Agregar");
		btnAgregarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AgregarTipo ventana = new AgregarTipo(frame);
				ventana.setVisible(true);
				
				if(ventana.isGuardado())
				{
					cargarTablaTipos();
				}
			}
		});
		
		btnAgregarTipo.setFont(new Font("Arial", Font.PLAIN, 12));
		btnAgregarTipo.setBounds(491, 131, 89, 23);
		panelPantallaTipo.add(btnAgregarTipo);
		
		btnEditarTipo = new JButton("Editar");
		btnEditarTipo.addActionListener(e -> editarTipo());
		btnEditarTipo.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEditarTipo.setBounds(491, 182, 89, 23);
		panelPantallaTipo.add(btnEditarTipo);
		
		btnEliminarTipo = new JButton("Eliminar");
		btnEliminarTipo.addActionListener(e -> borrarTipo());
		btnEliminarTipo.setFont(new Font("Arial", Font.PLAIN, 12));
		btnEliminarTipo.setBounds(491, 232, 89, 23);
		panelPantallaTipo.add(btnEliminarTipo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(103, 78, 343, 216);
		panelPantallaTipo.add(scrollPane);
		
		tableListaTipos = new JTable();
		tableListaTipos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tipos registrados"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(tableListaTipos);
		
		JPanel panelPantallaAlerta = new JPanel();
		tabbedPane.addTab("Alerta", null, panelPantallaAlerta, null);
		panelPantallaAlerta.setLayout(null);
		
		
		
		cargarTablaTipos();
		cargarTablaCategorias();
		cargarTablaUsuarios();
		cargarTablaItems();
		cargarTablaPrestamos();
	}
	
	
	
	//-*-*-*-*-*-*-*-*-*--**-*--*-**--**--*-*-**--**-*--*-**-*--*-*-*-*-*-**-*-**-*--**--*-*-*-*-*-*-*-*-*-*-*-*-*-**--*-*-*-*-*-*-*-*-*-**-*-*-*-*
	
	private void cargarTablaTipos()
	{
		DefaultTableModel modelo = (DefaultTableModel) tableListaTipos.getModel();

		modelo.setRowCount(0);

		for(Tipo tipo : Controladora.getInstance().mostrarListaTipos())
		{
			modelo.addRow(new Object[]
			{
				tipo.getTipo()
			});
		}
	}
	
	private void borrarTipo()
	{
		int numeroFila = tableListaTipos.getSelectedRow();
		
		if(numeroFila == -1)
		{
			JOptionPane.showMessageDialog(frame, "Debe seleccionar un tipo", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			DefaultTableModel modelo = (DefaultTableModel) tableListaTipos.getModel();

			String nombreTipo = (String) modelo.getValueAt(numeroFila, 0);

			int respuesta = JOptionPane.showConfirmDialog(frame, "El tipo \"" + nombreTipo + "\" será eliminado.", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
			
			
			if(respuesta == JOptionPane.YES_OPTION)
			{
				try
				{
					Tipo tipo = new Tipo(nombreTipo);
					Controladora.getInstance().borrarTipo(tipo);
					
					cargarTablaTipos();
					
					JOptionPane.showMessageDialog(frame, "Tipo eliminado correctamente");
				}
				
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(frame, "Error al eliminar tipo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		}
		
	}
	
	private void editarTipo() 
	{
	
		int fila = tableListaTipos.getSelectedRow();

		if(fila == -1)
		{
			JOptionPane.showMessageDialog(frame, "Necesita seleccionar un tipo de la tabla", "Error", JOptionPane.ERROR_MESSAGE);

			return;
		}

		DefaultTableModel model = (DefaultTableModel)tableListaCategoria.getModel();

		String nombreTipo = tableListaTipos.getValueAt(fila, 0).toString();

		EditarTipo dialogo = new EditarTipo(frame,nombreTipo);

		dialogo.setVisible(true);

		if(dialogo.isGuardado())
		{
			cargarTablaTipos();
		}
	}
	
	//-*-*-*-*-*-*-*-*-*--**-*--*-**--**--*-*-**--**-*--*-**-*--*-*-*-*-*-**-*-**-*--**--*-*-*-*-*-*-*-*-*-*-*-*-*-**--*-*-*-*-*-*-*-*-*-**-*-*-*-*
	
	private void cargarTablaCategorias()
	{
		DefaultTableModel modelo = (DefaultTableModel) tableListaCategoria.getModel();

		modelo.setRowCount(0);

		for(Categoria categoria : Controladora.getInstance().mostrarListaCategorias())
		{
			modelo.addRow(new Object[]
			{
				categoria.getCategoria()
			});
		}
	}
	
	
	
	private void borrarCategoria()
	{
		int numeroFila = tableListaCategoria.getSelectedRow();
		
		if(numeroFila == -1)
		{
			JOptionPane.showMessageDialog(frame, "Debe seleccionar una categoria", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			DefaultTableModel modelo = (DefaultTableModel) tableListaCategoria.getModel();

			String nombreCategoria = (String) modelo.getValueAt(numeroFila, 0);

			int respuesta = JOptionPane.showConfirmDialog(frame, "La categoria \"" + nombreCategoria + "\" será eliminada.", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
			
			
			if(respuesta == JOptionPane.YES_OPTION)
			{
				try
				{
					Categoria categoria = new Categoria(nombreCategoria);
					Controladora.getInstance().borrarCategoria(categoria);
					
					cargarTablaCategorias();
					
					JOptionPane.showMessageDialog(frame, "Categoria eliminada correctamente");
				}
				
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(frame, "Error al eliminar la categoria: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		}
		
	}
	
	
	
	private void editarCategoria() 
	{
	
		int fila = tableListaCategoria.getSelectedRow();

		if(fila == -1)
		{
			JOptionPane.showMessageDialog(frame, "Necesita seleccionar una categoria de la tabla", "Error", JOptionPane.ERROR_MESSAGE);

			return;
		}

		DefaultTableModel model = (DefaultTableModel)tableListaCategoria.getModel();

		String nombreCategoria = tableListaCategoria.getValueAt(fila, 0).toString();

		EditarCategoria dialogo = new EditarCategoria(frame,nombreCategoria);

		dialogo.setVisible(true);

		if(dialogo.isGuardado())
		{
			cargarTablaCategorias();
		}
	}
	
	
	//-*-*-*-*-*-*-*-*-*--**-*--*-**--**--*-*-**--**-*--*-**-*--*-*-*-*-*-**-*-**-*--**--*-*-*-*-*-*-*-*-*-*-*-*-*-**--*-*-*-*-*-*-*-*-*-**-*-*-*-*
	
	private void cargarTablaUsuarios()
	{
		
		DefaultTableModel modelo = (DefaultTableModel) tableListaUsuarios.getModel();

		modelo.setRowCount(0);

		for(Usuario usuario : Controladora.getInstance().mostrarListaUsuarios().values())
		{
			modelo.addRow(new Object[]
			{
				usuario.getNombre(), usuario.getTelefono(), usuario.getCorreo()
			});
		}
	}
	
	
	private void borrarUsuario()
	{
		int numeroFila = tableListaUsuarios.getSelectedRow();
		
		if(numeroFila == -1)
		{
			JOptionPane.showMessageDialog(frame, "Debe seleccionar un usuario", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			DefaultTableModel modelo = (DefaultTableModel) tableListaUsuarios.getModel();

			String nombre = (String) modelo.getValueAt(numeroFila, 0);
			String telefono = (String) modelo.getValueAt(numeroFila, 1);
			String correo = (String) modelo.getValueAt(numeroFila, 2);

			int respuesta = JOptionPane.showConfirmDialog(frame, "El usuario \"" + correo + "\" será eliminada.", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
			
			
			if(respuesta == JOptionPane.YES_OPTION)
			{
				try
				{
					Controladora.getInstance().borrarUsuario(correo);
					
					cargarTablaUsuarios();
					
					JOptionPane.showMessageDialog(frame, "Usuario eliminado correctamente");
				}
				
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(frame, "Error al eliminar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
		}
		
	}
	
	private void editarUsuario() 
	{
		
		int fila = tableListaUsuarios.getSelectedRow();

		if(fila == -1)
		{
			JOptionPane.showMessageDialog(frame, "Necesita seleccionar un usuario de la tabla", "Error", JOptionPane.ERROR_MESSAGE);

			return;
		}

		DefaultTableModel model = (DefaultTableModel)tableListaUsuarios.getModel();

		String correo = tableListaUsuarios.getValueAt(fila, 2).toString();
		String nombre = tableListaUsuarios.getValueAt(fila, 0).toString();
		String telefono = tableListaUsuarios.getValueAt(fila, 1).toString();
		
		EditarUsuario dialogo = new EditarUsuario(frame,correo,nombre,telefono);

		dialogo.setVisible(true);

		if(dialogo.isGuardado())
		{
			cargarTablaCategorias();
		}
	}
	
	
	
	//-*-*-*-*-*-*-*-*-*--**-*--*-**--**--*-*-**--**-*--*-**-*--*-*-*-*-*-**-*-**-*--**--*-*-*-*-*-*-*-*-*-*-*-*-*-**--*-*-*-*-*-*-*-*-*-**-*-*-*-*
	
	private void cargarTablaItems()
	{
			
		DefaultTableModel modelo = (DefaultTableModel) tableListaItems.getModel();

		modelo.setRowCount(0);

		for(Item item : Controladora.getInstance().mostrarListaItems().values())
		{
			modelo.addRow(new Object[]
					{
							item.getNombre(),item.getCodigoI(), item.isDisponible(), item.getDescripcion(), obtenerCategorias(item), item.getTipo().getTipo()
					});
		}
	}
	
	
	private String obtenerCategorias(Item item)
	{
	    String categorias = "";

	    for(Categoria categoria : item.getCategorias())
	    {
	        categorias = categorias + categoria.getCategoria() + " ";
	    }

	    
	    return categorias;
	}
	
	
	
	private void borrarItem()
	{
		int numeroFila = tableListaItems.getSelectedRow();
		
		if(numeroFila == -1)
		{
			JOptionPane.showMessageDialog(frame, "Debe seleccionar un item", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		else
		{
			DefaultTableModel modelo = (DefaultTableModel) tableListaItems.getModel();

			String nombre = (String) modelo.getValueAt(numeroFila, 0);
			int codigo = (int) modelo.getValueAt(numeroFila, 1);
			boolean disponible = (boolean) modelo.getValueAt(numeroFila, 2);
			String descripcion = (String) modelo.getValueAt(numeroFila, 3);
			String categoria = (String) modelo.getValueAt(numeroFila, 4);
			String tipo = (String) modelo.getValueAt(numeroFila, 5);

			int respuesta = JOptionPane.showConfirmDialog(frame, "El item \"" + nombre + "\" será eliminada.", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
			
			
			if(respuesta == JOptionPane.YES_OPTION)
			{
				try
				{
					Controladora.getInstance().borrarItem(codigo);
					
					cargarTablaItems();
					
					JOptionPane.showMessageDialog(frame, "Item eliminado correctamente");
				}
				
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(frame, "Error al eliminar el item: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}	
			}	
		}
	}
	
	
	
	private void editarItem() 
	{
		
		int fila = tableListaItems.getSelectedRow();

		if(fila == -1)
		{
			JOptionPane.showMessageDialog(frame, "Necesita seleccionar un item de la tabla", "Error", JOptionPane.ERROR_MESSAGE);

			return;
		}

		DefaultTableModel model = (DefaultTableModel)tableListaItems.getModel();

		String nombre = tableListaItems.getValueAt(fila, 0).toString();
		int codigo = (int) tableListaItems.getValueAt(fila, 1);
		boolean disponible = (boolean) tableListaItems.getValueAt(fila, 2);
	    String descripcion = tableListaItems.getValueAt(fila, 3).toString();
	    String tipo = tableListaItems.getValueAt(fila, 5).toString();
		
		EditarItem dialogo = new EditarItem(frame, codigo, nombre, descripcion, disponible, tipo);

		dialogo.setVisible(true);

		if(dialogo.isGuardado())
		{
			cargarTablaItems();
		}
	}
	
	//-*-*-*-*-*-*-*-*-*--**-*--*-**--**--*-*-**--**-*--*-**-*--*-*-*-*-*-**-*-**-*--**--*-*-*-*-*-*-*-*-*-*-*-*-*-**--*-*-*-*-*-*-*-*-*-**-*-*-*-*

	private void cargarTablaPrestamos()
	{
		DefaultTableModel modelo = (DefaultTableModel) tableListaPrestamosHechos.getModel();

		modelo.setRowCount(0);

		for(Prestamo prestamo : Controladora.getInstance().mostrarListaPrestamos().values())
		{
			modelo.addRow(new Object[]
			{
					prestamo.getUsuario().getNombre(), prestamo.getNombresItems(),prestamo.getAlerta() != null
			});
		}
	}
	
}
