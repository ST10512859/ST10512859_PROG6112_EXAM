/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.edu.myemeris.st10512859.prog6112exam;

public abstract class Product1 implements IProduct1 {

    private String[] productNames;
    private int[][] salesData;

    public Product1(String[] productNames, int[][] salesData) {
        this.productNames = productNames;
        this.salesData = salesData;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < salesData.length; i++) {
            for (int j = 0; j < salesData[i].length; j++) {
                total += salesData[i][j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int total = GetTotalProductsSold();
        int count = 0;
        for (int i = 0; i < salesData.length; i++) {
            count += salesData[i].length;
        }
        return count == 0 ? 0.0 : (double) total / count;
    }

    @Override
    public String GetMostPopularProduct() {
        int maxTotal = -1;
        int bestProductIndex = 0;
        int maxMonthSale = 0;

        for (int i = 0; i < salesData.length; i++) {
            int currentProductTotal = 0;
            int currentMaxMonth = salesData[i][0];
            for (int j = 0; j < salesData[i].length; j++) {
                currentProductTotal += salesData[i][j];
                if (salesData[i][j] > currentMaxMonth) {
                    currentMaxMonth = salesData[i][j];
                }
            }
            if (currentProductTotal > maxTotal) {
                maxTotal = currentProductTotal;
                bestProductIndex = i;
                maxMonthSale = currentMaxMonth;
            }
        }
        return productNames[bestProductIndex] + " (" + maxMonthSale + ")";
    }

    @Override
    public int GettotalProductsSold() {
        return GetTotalProductsSold();
    }
}
