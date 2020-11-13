package ca.sheridancollege.database;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.beans.Checking;
@Repository
public class DatabaseAccess {

	@Autowired
	NamedParameterJdbcTemplate jdbc;
	
	public void addClient(Checking check) {
	
		
		String query="INSERT INTO client VALUES ('"+check.getClient_name()+"','"+check.getStreet()+"','"+check.getCity()+"','"+check.getProvince()+"','"+check.getPhone()+"')";
		jdbc.update(query, new HashMap());
	}
	
}
