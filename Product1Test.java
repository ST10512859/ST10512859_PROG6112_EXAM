/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.edu.myemeris.st10512859.prog6112exam;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Product1Test {

    @Test
    public void GetTotalProductSales_ValidData_ReturnsCorrectValue() {
        String[] products = {"Product A", "Product B"};
        int[][] sales = {
            {25, 18, 20},
            {15, 10, 12}
        };
        Product1 product1 = new Product1(products, sales);

        int totalSales = product.GetTotalProductsSold();

        assertEquals(100, totalSales);
    }

    @Test
    public void GetAverageSales_ValidData_ReturnsCorrectValue() {
        String[] products = {"Product A", "Product B"};
        int[][] sales = {
            {10, 20, 30}, 0
            {10, 20, 30}  
        };
    
        Product1 product = new Product1(products, sales) {};      
        
        double averageSales = product.GetAverageProductSold();
        
        assertEquals(20.0, averageSales, 0.001);
    }
}
