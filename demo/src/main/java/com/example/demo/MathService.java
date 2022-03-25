package com.example.demo;

public class MathService {
    
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

    
    public String errorPage() {
        String htmlString = "";
        htmlString += "<!DOCTYPE html>";
        htmlString += "<html lang=\"en\">";
        htmlString += "<head><meta charset=\"UTF-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><title>Page not found</title></head>";
        htmlString += "<body><h1>Page does not exist</h1><h2>Valid endpoints:</h2><ul>";
        htmlString += "<li>/math - accepts parameters OPERATION, value1 and value2</li></ul></body>";
        htmlString += "</html>";
        return htmlString;
    }

    
    public String getErrorPath() {
        
        return PATH;
    }
}
