package PojoClasses;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginClaims {

	//This is just a practice
	//This is my code
	@JsonProperty("key")
	private String key;
	@JsonProperty("value")
	private Boolean value;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("key")
	public String getKey() {
	return key;
	}

	@JsonProperty("key")
	public void setKey(String key) {
	this.key = key;
	}

	@JsonProperty("value")
	public Boolean getValue() {
	return value;
	}

	@JsonProperty("value")
	public void setValue(Boolean value) {
	this.value = value;
	}

}
