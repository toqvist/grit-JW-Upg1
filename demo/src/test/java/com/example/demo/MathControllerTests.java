package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

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
}
