package Logica;

import java.util.List;
import java.util.Map;


public class Item {
	
	private String nombre;
	private String descripcion;
	private boolean disponible;
	private int codigoI;
	private int codigoNumerico = 1;
	private Tipo tipo;
	private List<Categoria> categorias;
	private Prestamo prestamo;
	
	public Item(String nombre, String descripcion, boolean disponible, int codigo, Tipo tipo, List<Categoria> categorias, Prestamo prestamo)
	{
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.disponible = true;
		this.codigoI = codigoNumerico;
		codigoNumerico++;
		this.tipo = tipo;
		this.categorias = categorias;
		this.prestamo = prestamo;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public int getCodigoNumerico() {
		return codigoNumerico;
	}

	public void setCodigoNumerico(int codigoNumerico) {
		this.codigoNumerico = codigoNumerico;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
		tipo.agregarItem(this);
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public int getCodigoI() {
		return codigoI;
	}
	
	
	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public void agregarCategoria(Categoria categoria){
		
		categorias.add(categoria);
		categoria.agregarItem(this);
	}
	
	public void eliminarCategoria(Categoria categoria) {
		
		categorias.remove(categoria);
	}
	
	
	public String toString()
	{
		
		String resultado= "Item: " + nombre + "\n" + "Disponibilidad: " + disponible + "\n" + "Codigo: " + codigoI + "\n" + "Tipo: " + tipo + "\n"
				+ "Categorias: " + categorias;

	    return resultado;
		
	}
	
	
	
	
	

}
