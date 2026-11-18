/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.edu.myemeris.st10512859.prog6112exam;

import java.util.Scanner;

public class Product1Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] productNames = {
            "Cozy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"
        };

        int[][] salesData = new int[3][3];

        for (int i = 0; i < productNames.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + productNames[i] + ": ");
                salesData[i][j] = scanner.nextInt();
            }
        }

        Product1 product = new Product1(productNames, salesData);
        PrintProduct1 printer = new PrintProduct1(product);

        printer.PrintReport();

        scanner.close();
    }
}
