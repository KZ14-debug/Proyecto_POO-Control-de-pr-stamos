package Interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class PantallaPrincipal {

	private JFrame frame;
	private JButton btnPantallaUsuario;
	private JButton btnPantallaItem;
	private JButton btnPantallaPrestamo;
	private JButton btnPantallaCategoria;
	private JButton btnPantallaTipo;
	private JButton btnPantallaAlerta;
	private JTable table;

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
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panelPantallaPrincipal = new JPanel();
		tabbedPane.addTab("Pantalla Principal", null, panelPantallaPrincipal, null);
		panelPantallaPrincipal.setLayout(null);
		
		btnPantallaUsuario = new JButton("Usuarios");
		btnPantallaUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPantallaUsuario.setBounds(266, 82, 89, 23);
		panelPantallaPrincipal.add(btnPantallaUsuario);
		
		JLabel lblNewLabel = new JLabel("Pantalla Principal");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(221, 27, 171, 23);
		panelPantallaPrincipal.add(lblNewLabel);
		
		btnPantallaItem = new JButton("Item");
		btnPantallaItem.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPantallaItem.setBounds(266, 130, 89, 23);
		panelPantallaPrincipal.add(btnPantallaItem);
		
		btnPantallaPrestamo = new JButton("Prestamos");
		btnPantallaPrestamo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPantallaPrestamo.setBounds(254, 178, 112, 23);
		panelPantallaPrincipal.add(btnPantallaPrestamo);
		
		btnPantallaCategoria = new JButton("Categorias");
		btnPantallaCategoria.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPantallaCategoria.setBounds(254, 226, 112, 23);
		panelPantallaPrincipal.add(btnPantallaCategoria);
		
		btnPantallaTipo = new JButton("Tipos");
		btnPantallaTipo.setFont(new Font("Arial", Font.PLAIN, 14));
		btnPantallaTipo.setBounds(266, 274, 89, 23);
		panelPantallaPrincipal.add(btnPantallaTipo);
		
		btnPantallaAlerta = new JButton("Alertas");
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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(491, 81, 89, 23);
		panelPantallaTipo.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(501, 125, 89, 23);
		panelPantallaTipo.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(511, 180, 89, 23);
		panelPantallaTipo.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 69, 343, 216);
		panelPantallaTipo.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panelPantallaAlerta = new JPanel();
		tabbedPane.addTab("Alerta", null, panelPantallaAlerta, null);
		panelPantallaAlerta.setLayout(null);
	}

}
