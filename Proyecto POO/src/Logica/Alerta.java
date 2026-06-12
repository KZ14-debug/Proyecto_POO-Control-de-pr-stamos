package Logica;

import java.time.LocalDateTime;

public class Alerta {
	
	private String mensaje;
	private int frecuencia;
	private LocalDateTime tiempoDeAlerta;
	
	
	public Alerta(String mensaje, int frecuencia)
	{
		this.mensaje = mensaje;
		this.frecuencia = frecuencia;
		tiempoDeAlerta = LocalDateTime.now();
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public int getFrecuencia() {
		return frecuencia;
	}


	public void setFrecuencia(int frecuencia) {
		this.frecuencia = frecuencia;
	}
	
	
	
	public LocalDateTime getTiempoDeAlerta() {
		return tiempoDeAlerta;
	}


	public String toString()
	{
		
		String resultado= "Mensaje de alerta: " + mensaje + "\n" + "Frecuencia de aparicion: " + frecuencia;

	    return resultado;
		
	}

}
