package Logica;

public class Tipo {
	
	private String tipo; 
	
	
	public Tipo (String tipo)
	{
		this.tipo = tipo;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	public String toString()
	{
		
		String resultado= "Tipo del item: " + tipo + "\n";

	    return resultado;
		
	}

	

}
