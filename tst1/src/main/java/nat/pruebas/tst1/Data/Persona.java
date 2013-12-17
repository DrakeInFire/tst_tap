package nat.pruebas.tst1.Data;

import org.apache.tapestry5.beaneditor.Validate;

public class Persona {
	@Validate("required")
	private String nombre;

	@Validate("required")
	private String apellido;

	@Validate("required")
	private String dni;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

}
