package Logica;

import java.util.ArrayList;
import java.util.List;

public class Tipo {
	
	private String tipo; 
	private List<Item> items;
	
	
	public Tipo (String tipo)
	{
		this.tipo = tipo;
		this.items = new ArrayList<>();
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public List<Item> getItems() {
        return items;
    }

	
    public void setItems(List<Item> items) {
        this.items = items;
    }
	
    
    
    public void agregarItem(Item item) {
        items.add(item);
    }

    
    public void borrarItem(int codigoI) {

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getCodigoI() == codigoI) {
                items.remove(i);
                return;
            }
        }
    }
    
    
	public String toString()
	{
		
		String resultado= "Tipo del item: " + tipo + "\n";

	    return resultado;
		
	}

	

}
