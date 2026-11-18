/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.edu.myemeris.st10512859.prog6112exam;

public class PrintProduct1 {

    private IProduct1 product;

    public PrintProduct1(IProduct1 product1) {
        this.product = product;
    }

    public void PrintTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    public void PrintAverageProductSales() {
        System.out.println("AVERAGE PRODUCT SALES: " + Math.round(product.GetAverageProductSold()));
    }

    public void PrintMostPopularProductSale() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }

    public void PrintReport() {
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("*****************************************************");
        PrintTotalProductSales();
        PrintAverageProductSales();
        PrintMostPopularProductSale();
        System.out.println("*****************************************************");
    }
}
