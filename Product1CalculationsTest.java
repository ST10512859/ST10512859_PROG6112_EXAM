/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.edu.myemeris.st10512859.prog6112exam;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Product1CalculationsTest {

    @Test
    public void GetVat_WithValidData_ReturnsCorrectValue() {

        double price = 3500.0;
        Product1Calculations calculations = new Product1Calculations(price);

        double vat = calculations.GetVat();

        assertEquals(525.0, vat, 0.001);
    }
}
