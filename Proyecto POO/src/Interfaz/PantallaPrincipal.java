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
import Logica.Tipo;

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
		frame.setBounds(100, 100, 642, 441);
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
		
		JPanel panelPantallaItem = new JPanel();
		tabbedPane.addTab("Item", null, panelPantallaItem, null);
		
		JPanel panelPantallaPrestamo = new JPanel();
		tabbedPane.addTab("Prestamo", null, panelPantallaPrestamo, null);
		
		JPanel panelPantallaCategoria = new JPanel();
		tabbedPane.addTab("Categoria", null, panelPantallaCategoria, null);
		
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
	}
	
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

		DefaultTableModel model = (DefaultTableModel)tableListaTipos.getModel();

		String nombreTipo = tableListaTipos.getValueAt(fila, 0).toString();

		EditarTipo dialogo = new EditarTipo(frame,nombreTipo);

		dialogo.setVisible(true);

		if(dialogo.isGuardado())
		{
			cargarTablaTipos();
		}
		
		
	}
	
}
