package ca.sheridancollege.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import ca.sheridancollege.beans.Checking;
import ca.sheridancollege.beans.Matrix;
import ca.sheridancollege.beans.StringSearch;
import ca.sheridancollege.database.DatabaseAccess;

@Controller
public class HomeController {
	@Autowired
    private DatabaseAccess two;
	private char[][] charArray;
	
	@GetMapping("/") //localhost:8080
	public String input(Model model) {
		model.addAttribute("matrix",new Matrix());
		return("input.html");
	}
	
	
	@GetMapping("/generate")
	public String generateMatrix(Model model,@ModelAttribute Matrix matrix) {
		
		 
    	charArray=matrix.generateMatrix();
		 model.addAttribute("matrixOne",charArray);
		 model.addAttribute("check",new Checking() );
		 
		return ("output.html");
	
	}
	
	
	@GetMapping("/next")
	public String checkString(Model model, @ModelAttribute Checking check) {
	   
	    String word=check.getS().toLowerCase();
		
	    StringSearch one = new StringSearch();
		
		
		two.addClient(check);
		 
		String returnPage="";
		if(one.search(word,charArray)) {
		   returnPage="success.html";
		}else {
			returnPage = "fail.html";
		}
		
		 model.addAttribute("word",word);
		return returnPage;

	}
	
	
	@GetMapping("/gameDone")
	public String gameDone() {
		return "done.html";
	}
	
	
}

