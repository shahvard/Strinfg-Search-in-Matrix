package ca.sheridancollege.beans;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Checking  implements Serializable {
	
	private static final long serialVersionUID = 6351540202714730811L;
	
	private String s;
	private String client_name;
	private String street;
	private String city;
	private String province;
	private String phone;

	
	
}