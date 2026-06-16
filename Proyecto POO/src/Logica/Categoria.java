package Logica;

import java.util.ArrayList;
import java.util.List;


public class Categoria {
	
	private String categoria;
	private List<Item> items;
	
	
	public Categoria(String categoria)
	{
		this.categoria = categoria;
        this.items = new ArrayList<>();

	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
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
		
		String resultado= categoria;

	    return resultado;
		
	}


}
