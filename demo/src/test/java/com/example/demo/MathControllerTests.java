package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MathControllerTests {
    
    @Test
    void testMath() {
        MathController controller = new MathController();
        int value1 = 10;
        int value2 = 5;
        
        String response = controller.math("addition",value1, value2);
        assertEquals("15.0", response);
        
        response = controller.math("subtraction", value1, value2);
        assertEquals("5.0", response);

        response = controller.math("multiplication", value1, value2);
        assertEquals("50.0", response);
        
        response = controller.math("division", value1, value2);
        assertEquals("2.0", response);
    }

    @Test
    void testFailMath() {
        MathController controller = new MathController();
        int value1 = 10;
        int value2 = 5;
        
        String response = controller.math("addition",value1, value2);
        assertNotEquals("1.0", response);
        
        response = controller.math("subtraction", value1, value2);
        assertNotEquals("1.0", response);

        response = controller.math("multiplication", value1, value2);
        assertNotEquals("1.0", response);
        
        response = controller.math("division", value1, value2);
        assertNotEquals("1.0", response);
    }

    @Test
    public void endpointTest() throws IOException {
		
        URL url = new URL("http://localhost:8080/math/?operation=addition&value1=1&value2=2");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("GET");
		connection.setRequestProperty("User-Agent", "Mozilla/5.0");
		
		int responseCode = connection.getResponseCode();
		System.out.println("Response code: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader isr = new BufferedReader(
					new InputStreamReader(
							connection.getInputStream()));
			String myText;
			StringBuffer myBuffert = new StringBuffer();
			
			while ( (myText = isr.readLine()) != null  ) {
				myBuffert.append(myText);
			}
			isr.close();
			
			String result = (myBuffert.toString());
            assertEquals("3.0", result);
		} else {
			System.out.println("Could not read URL");
		}
	}
    
}
