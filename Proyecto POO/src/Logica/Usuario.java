package Logica;

import java.util.Map;


public class Usuario {
	
	private String nombre;
	private String correo;
	private String telefono;
	
	private Map<Integer,Prestamo> prestamos;
	
	
	public Usuario(String nombre, String correo, String telefono, Map<Integer,Prestamo> prestamos)
	{
		this.nombre = nombre;
		this.correo = correo;
		this.telefono = telefono;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	public Map<Integer, Prestamo> getPrestamos() {
		return prestamos;
	}


	public void setPrestamos(Map<Integer, Prestamo> prestamos) {
		this.prestamos = prestamos;
	}


	public void agregarPrestamo(Prestamo prestamo)
	{
        prestamos.put(prestamo.getIdPrestamo(), prestamo);
	}
	
	public void borrarPrestamo(int idPrestamo) {
        prestamos.remove(idPrestamo);
    }
	
	
	public String toString()
	{
		String resultado = "Nombre: " + nombre + "\n" + "Telefono: " + telefono + "\n" + "Correo: " + correo + "\n" + "Prestamos: " + prestamos;
		
		return resultado;
	
	}
	

}
