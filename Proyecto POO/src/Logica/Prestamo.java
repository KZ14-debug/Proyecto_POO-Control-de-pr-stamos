package Logica;

import java.util.HashMap;
import java.util.Map;


public class Prestamo {
	
	private int idPrestamo;
	private static int numeroId = 1;
	private boolean estado;
	
	private Map<Integer, Item> items;
	private Alerta alerta;
	private Usuario usuario;

	
	public Prestamo(int idPrestamo, boolean estado)
	{
		this.idPrestamo = numeroId;
		numeroId++;
		this.estado = estado;
		this.items = new HashMap<>();
	}


	public boolean getEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public Map<Integer, Item> getItems() {
		return items;
	}

	

	public void setItems(Map<Integer, Item> items) {
		this.items = items;
	}


	public Alerta getAlerta() {
		return alerta;
	}


	public void setAlerta(Alerta alerta) {
		this.alerta = alerta;
	}


	public int getIdPrestamo() {
		return idPrestamo;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public void agregarItem(Item item) {
        items.put(item.getCodigoI(), item);
    }

    public void borrarItem(int codigoI) {
        items.remove(codigoI);
    }
	
    
    public String toString() {
    	
    	String resultado = "ID Prestamo: " + idPrestamo + "\n  + Estado: " + estado +
                "\n + Usuario: " +  usuario.getNombre()  +
                "\n" + "Alerta: " + (alerta != null ? alerta : "Sin alerta") +
                "\n";
        return  resultado;
    }

}
