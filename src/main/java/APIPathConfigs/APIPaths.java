package APIPathConfigs;

public enum APIPaths {
	
	
	AddUser("/v1/Account/Register"),
	GetToken("/v1/Account/GetToken");
	private String resource;
	
	
	APIPaths(String resource) {
		
		this.resource=resource;
		
		
	}
	
	public String getResource()
	{
		return resource;
	}
	
	

}
