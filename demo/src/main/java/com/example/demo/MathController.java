package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class MathController implements ErrorController{
    
	//http://localhost:8080/math/?operation=addition&value1=1&value2=2
	@CrossOrigin
	@RequestMapping("/math/")
	public String math(String operation, float value1, float value2) {
		System.out.println("doing math");
		float result = 0;
		switch(operation) {
			case "addition":	
				result = value1 + value2;
				break;
			case "subtraction":
				result = value1 - value2;
				break;
			case "multiplication":
				result = value1*value2;
				break;
			case "division":
				result = value1/value2;
				break;
		}
		String returnValue = String.valueOf(result);
		return returnValue;
	}    

	private static final String PATH = "/error";

	@RequestMapping(value = PATH, method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String errorPage() {
		String index = "";
		index += "<!DOCTYPE html>";
		index += "<html lang=\"en\">";
		index += "<head><meta charset=\"UTF-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><title>Page not found</title></head>";
		index += "<body><h1>Oops! Something went wrong</h1><h2><a href=\"https://www.youtube.com/watch?v=dQw4w9WgXcQ\">Learn about other annoyingly ambiguous error messages here</a></h2></body>";
		index += "</html>";
		index += "</body></html>";
		return index;
	}

	@Override
	public String getErrorPath() {
		
		return PATH;
	}
}
