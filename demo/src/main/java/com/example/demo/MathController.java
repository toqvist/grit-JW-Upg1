package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class MathController {
    
	//http://localhost:8080/math/?operation=addition&value1=1&value2=2
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

	//Ignore this
	//Attempt at multiple params, will ask later
	@RequestMapping("/mathAdvanced/")
	public String mathAdvanced(String operation, float... values) {
		System.out.println("doing math");
		float result = values[0];
		switch(operation) {
			case "addition":	
				for (int i=1;i<values.length;i++) {
					result += values[i];
				}
				break;
			case "subtraction":
				for (int i=1;i<values.length;i++) {
					result -= values[i];
				}
				break;
			case "multiplication":
				for (int i=1;i<values.length;i++) {
					result *= values[i];
				}
				break;
			case "division":
				for (int i=1;i<values.length;i++) {
					result /= values[i];
				}
				break;
		}
		System.out.println(result);
		String returnValue = String.valueOf(result);
		return returnValue;


	}
    
}
