package Utility;

public enum Resources {
	AddUserEndPoint("/api/users");
	private String resource;
	

	Resources(String resource) {
		this.resource=resource;
	}
	public String getResource() {
		return this.resource;
	}
}
