package movie4u.models;

public class Role {
	private String name;
	private String role;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @param name
	 * @param role
	 */
	public Role(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}
	
}
