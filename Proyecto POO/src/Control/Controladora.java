package Control;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import Logica.Alerta;
import Logica.Categoria;
import Logica.Item;
import Logica.Prestamo;
import Logica.Tipo;
import Logica.Usuario;

public class Controladora {

	 private Map<Integer, Item> items;
	 private Map<String, Usuario> usuarios;
	 private Map<Integer, Prestamo> prestamos;
	 private List<Categoria> categorias;
	 private List<Tipo> tipos;
	 private List<Alerta> alertas;
	
	 
	 public Controladora() 
	 {
		 items = new TreeMap<>();
		 usuarios = new TreeMap<>();
		 prestamos = new TreeMap<>();
		 categorias = new ArrayList<>();
		 tipos = new ArrayList<>();
		 alertas = new ArrayList<>();
	 }
	 
	 
	 public void crearItem(Item item)
	 {
		 items.put(item.getCodigoI(), item);
	 }
	 
	 
	 public void editarItem(int codigoI, Item item) throws Exception
	 {
		 
		 if(!items.containsKey(codigoI))
		 {
			 throw new Exception("El codigo de item no es valido");
		 }
		 
		 items.put(codigoI, item);
	 }
	 
	 public void borrarItem(int codigoI) throws Exception
	 {
		 
		 if(!items.containsKey(codigoI))
		 {
			 throw new Exception("El codigo de item no es valido");
		 }
		 
		 items.remove(codigoI);
	 }
	 
	 public Item buscarItem(int codigoI)
	 {
		 return items.get(codigoI);
	 }

	 
	 
	 
	 
	 
	 public void crearUsuario(Usuario usuario)
	 {
		 usuarios.put(usuario.getCorreo(), usuario);
	 }
	 
	 
	 public void editarUsuario(String correo, Usuario usuario) throws Exception
	 {
		 
		 if(!usuarios.containsKey(correo))
		 {
			 throw new Exception("El correo del usuario no es valido");
		 }
		 
		 usuarios.put(correo, usuario);
	 }
	 
	 public void borrarUsuario(String correo) throws Exception
	 {
		 
		 if(!usuarios.containsKey(correo))
		 {
			 throw new Exception("El correo del usuario no es valido");
		 }
		 
		 usuarios.remove(correo);
	 }
	 
	 public Usuario buscarUsuario(String correo)
	 {
		 return usuarios.get(correo);
	 }
	 
	 
	 
	 
	 
	 
	 
	 public void crearCategoria(Categoria categoria) 
	 {
		 categorias.add(categoria);
	 }
	 
	 public void editarCategoria(Categoria categoria) throws Exception
	 {
		 
		 for(int i = 0; i < categorias.size(); i++)
		 {
			 if(categorias.get(i).getCategoria().equals(categoria.getCategoria()))
			 {
				 categorias.set(i, categoria);
	             return;
			 }
		 }
		 
		 
	     throw new Exception("Categoria no encontrada");

	 }
	 
	 public void borrarCategoria(Categoria categoria) throws Exception
	 {
		 
		 for(int i = 0; i < categorias.size(); i++)
		 {
			 if(categorias.get(i).getCategoria().equals(categoria.getCategoria()))
			 {
				 categorias.remove(i);
	             return;
			 }
		 }
		 
		 
	     throw new Exception("Categoria no encontrada");
	 }
	 
	 public Categoria buscarCategoria(Categoria categoria) throws Exception
	 {
		 for(int i = 0; i < categorias.size(); i++)
		 {
			 if(categorias.get(i).getCategoria().equals(categoria.getCategoria()))
			 {
				 return categorias.get(i);
	             
			 }
		 }
		 
		 
	     throw new Exception("Categoria no encontrada");
	 }
	 
	 
	 
	 
	 
	 
	 public void crearTipo(Tipo tipo) 
	 {
		 tipos.add(tipo);
	 }
	 
	 public void editarTipo(Tipo tipo) throws Exception
	 {
		 
		 for(int i = 0; i < tipos.size(); i++)
		 {
			 if(tipos.get(i).getTipo().equals(tipo.getTipo()))
			 {
				 tipos.set(i, tipo);
	             return;
			 }
		 }
		 
		 
	     throw new Exception("Tipo no encontrada");

	 }
	 
	 public void borrarTipo(Tipo tipo) throws Exception
	 {
		 
		 for(int i = 0; i < tipos.size(); i++)
		 {
			 if(tipos.get(i).getTipo().equals(tipo.getTipo()))
			 {
				 tipos.remove(i);
	             return;
			 }
		 }
		 
		 
	     throw new Exception("Tipo no encontrada");
	 }
	 
	 public Tipo buscarTipo(Tipo tipo) throws Exception
	 {
		 for(int i = 0; i < tipos.size(); i++)
		 {
			 if(tipos.get(i).getTipo().equals(tipo.getTipo()))
			 {
				 return tipos.get(i);
	             
			 }
		 }
		 
		 
	     throw new Exception("Tipo no encontrada");
	 }
	 
	 
	 
	 
	 
	 
	 public Prestamo buscarPrestamo(int idPrestamo) 
	 {
		 return prestamos.get(idPrestamo);
	 }
	 
	 public Prestamo hacerPrestamo(String correo) throws Exception
	 {
		 
		 if(!usuarios.containsKey(correo))
		 {
			 throw new Exception("Usuario no encontrado");
		 }
		 
		 Usuario usuario = usuarios.get(correo);
		 
		 Prestamo prestamo = new Prestamo(0, true);
		 
		 prestamo.setUsuario(usuario);
		 
		 prestamos.put(prestamo.getIdPrestamo(), prestamo);
		 
		 usuario.agregarPrestamo(prestamo);
		 
		 return prestamo; 
	 }
	 
	 public void agregarItemAlPrestamo(int idPrestamo, int codigoI) throws Exception
	 {
		 
		 if(!prestamos.containsKey(idPrestamo))
		 {
		     throw new Exception("Prestamo no encontrado");
		 }

		 if(!items.containsKey(codigoI))
		 {
		     throw new Exception("Item no encontrado");
		 }
		 
		 Prestamo prestamo = prestamos.get(idPrestamo);
		 Item item = items.get(codigoI);

		 if(!item.isDisponible())
		 {
		     throw new Exception("Item no disponible");
		 }
		 
		 prestamo.agregarItem(item);
	     item.setDisponible(false);
	 }
	 
	 public void eliminarItemDelPrestamo(int idPrestamo,int codigoI) throws Exception 
	 {
		 
		 if(!prestamos.containsKey(idPrestamo))
		 {
		     throw new Exception("Prestamo no encontrado");
		 }

		 if(!items.containsKey(codigoI))
		 {
		     throw new Exception("Item no encontrado");
		 }

		 Prestamo prestamo = prestamos.get(idPrestamo);
		 Item item = items.get(codigoI);

		 prestamo.borrarItem(codigoI);
	     item.setDisponible(true);
	     
	 }

	 public void retornarItemDelPrestamo(int idPrestamo,int codigoI) throws Exception 
	 {
		 eliminarItemDelPrestamo(idPrestamo,codigoI);
	 }
	 
	 public void terminarPrestamo(int idPrestamo) throws Exception 
	 {
		 if(!prestamos.containsKey(idPrestamo))
		 {
		     throw new Exception("Prestamo no encontrado");
		 }

		 Prestamo prestamo = prestamos.get(idPrestamo);
		 	 
		 prestamo.setEstado(false);
	 }
	 
	 
	 
	 
	 
	 
	 public String reporteUsuario(String correo) throws Exception 
	 {
		 if(!usuarios.containsKey(correo))
		 {
			 throw new Exception("Usuario no encontrado");
		 }
		 Usuario usuario = usuarios.get(correo);
		 
		 return usuario.toString();
	 }
	 
	 public String reporteItem(int codigoI) throws Exception 
	 {
		 if(!items.containsKey(codigoI))
		 {
		     throw new Exception("Item no encontrado");
		 }
		 
		 Item item = items.get(codigoI);
		 
		 return item.toString();
	 }
	 
	 public String reporteCategoria(Categoria categoria) 
	 {
		 return categoria.toString();
	 }
	 
	 public String reporteTipo(Tipo tipo) 
	 {
		 return tipo.toString();
	 }
	 
	 
	 
	 
	 
	 
	 public Map<String, Usuario> mostrarListaUsuarios()
	 {
		 return usuarios;
	 }
	 
	 public Map<Integer, Item> mostrarListaItems()
	 {
		 return items;
	 }
	 
	 public List<Categoria> mostrarListaCategorias() 
	 {
		 return new ArrayList<>(categorias);
	 }
	 
	 public List<Tipo> mostrarListaTipos() 
	 {
		 return new ArrayList<>(tipos);
	 }
	 
	 public Map<Integer, Prestamo> mostrarListaPrestamos() 
	 {
		 return prestamos;
	 }
	 
	 public List<Item> mostrarListaItemsPrestados() 
	 {
		 List<Item> resultado = new ArrayList<>();
		 
		 
		 for (Item item : items.values())
		 {
			 
			 if (item.isDisponible() == false) 
			 {
				 resultado.add(item);	 
			 }
			 
	     }
		 
		 return resultado;
	    
	 }
	 
	 public List<Item> mostrarListaItemsDisponibles() 
	 {
		 List<Item> resultado = new ArrayList<>();
		 
		 
		 for (Item item : items.values())
		 {
			 
			 if (item.isDisponible() == true) 
			 {
				 resultado.add(item);	 
			 }
			 
	     }
		 
		 return resultado;
	    
	 }
}
