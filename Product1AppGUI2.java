/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.edu.myemeris.st10512859.prog6112exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Product1AppGUI2 extends JFrame {

    private JTextField txtCustomerName;
    private JComboBox<String> cmbProduct;
    private JTextField txtPrice;
    private JButton btnProcess;

    public Product1AppGUI2() {
        setTitle("Product App");
        setSize(450, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        JMenuItem itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(e -> System.exit(0));
        menuFile.add(itemExit);

        JMenu menuTools = new JMenu("Tools");
        JMenuItem itemProcess = new JMenuItem("Process");
        itemProcess.addActionListener(e -> processSalesData());

        JMenuItem itemClear = new JMenuItem("Clear");
        itemClear.addActionListener(e -> clearFields());

        menuTools.add(itemProcess);
        menuTools.add(itemClear);

        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Customer Name:"), gbc);
        txtCustomerName = new JTextField(15);
        gbc.gridx = 1;
        panel.add(txtCustomerName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Select Product:"), gbc);
        String[] products = {
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        };
        cmbProduct = new JComboBox<>(products);
        gbc.gridx = 1;
        panel.add(cmbProduct, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Enter Price:"), gbc);
        txtPrice = new JTextField(15);
        gbc.gridx = 1;
        panel.add(txtPrice, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        btnProcess = new JButton("PROCESS");
        btnProcess.addActionListener(e -> processSalesData());
        panel.add(btnProcess, gbc);

        add(panel);
    }

    private void processSalesData() {
        try {
            String customerName = txtCustomerName.getText().trim();
            String productName = (String) cmbProduct.getSelectedItem();

            if (customerName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a customer name.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double price = Double.parseDouble(txtPrice.getText().trim());

            Product1Calculations calc = new Product1Calculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            String message = String.format(
                    "Customer Name: %s\nProduct: %s\nVAT: R %.1f\nCOMMISSION: R %.1f\nTOTAL: R %.1f",
                    customerName, productName, vat, commission, total
            );
            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            saveToFile(customerName, productName, vat, commission, total);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtCustomerName.setText("");
        cmbProduct.setSelectedIndex(0);
        txtPrice.setText("");
    }

    private void saveToFile(String customer, String product, double vat, double commission, double total) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true))) {
            writer.println("DATA LOG");
            writer.println("*****************************************************");
            writer.println("Customer Name: " + customer);
            writer.println("Product: " + product);
            writer.println(String.format("VAT: R %.1f", vat));
            writer.println(String.format("COMMISSION: R %.1f", commission));
            writer.println(String.format("TOTAL: R %.1f", total));
            writer.println("*****************************************************");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving to file: " + e.getMessage(), "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Product1AppGUI2().setVisible(true));
    }
}
