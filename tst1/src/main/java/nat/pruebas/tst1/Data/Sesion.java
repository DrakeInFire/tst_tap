package nat.pruebas.tst1.Data;

public class Sesion {

	private String name;
	private String id;
	private boolean isLoged=false;
	private boolean isUploadedFileUsers=false;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isLoged() {
		return isLoged;
	}
	public void setLoged(boolean isLoged) {
		this.isLoged = isLoged;
	}
	public boolean isUploadedFileUsers() {
		return isUploadedFileUsers;
	}
	public void setUploadedFileUsers(boolean isUploadedFileUsers) {
		this.isUploadedFileUsers = isUploadedFileUsers;
	}
}
	
