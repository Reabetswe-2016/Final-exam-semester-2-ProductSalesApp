/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package productapp;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ProductGUI extends JFrame {

    JTextField txtName, txtPrice;
    JComboBox<String> cmbProduct;

    JButton btnProcess;

    public ProductGUI() {

        setTitle("Product App");

        setSize(450, 300);

        setLayout(new GridLayout(5, 2, 10, 10));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu tools = new JMenu("Tools");

        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem process = new JMenuItem("Process");
        JMenuItem clear = new JMenuItem("Clear");

        exit.addActionListener(e -> System.exit(0));

        process.addActionListener(e -> calculate());

        clear.addActionListener(e -> clearFields());

        file.add(exit);

        tools.add(process);
        tools.add(clear);

        menuBar.add(file);
        menuBar.add(tools);

        setJMenuBar(menuBar);

        txtName = new JTextField();

        txtPrice = new JTextField();

        cmbProduct = new JComboBox<>(new String[]{
            "Cozy Nights Monarch",
            "Restonic Barbados",
            "Sealy Phuket"
        });

        btnProcess = new JButton("PROCESS");

        add(new JLabel("Customer Name:"));
        add(txtName);

        add(new JLabel("Select Product:"));
        add(cmbProduct);

        add(new JLabel("Enter Price:"));
        add(txtPrice);

        add(new JLabel(""));
        add(btnProcess);

        btnProcess.addActionListener(e -> calculate());

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public void calculate() {

        try {

            String name = txtName.getText();

            String product = cmbProduct.getSelectedItem().toString();

            double price = Double.parseDouble(txtPrice.getText());

            ProductCalculations calc =
                    new ProductCalculations(price);

            double vat = calc.GetVat();

            double commission = calc.GetCommission();

            double total = calc.GetTotal();

            String result =
                    "Customer Name: " + name +
                    "\nProduct: " + product +
                    "\nVAT: R " + vat +
                    "\nCOMMISSION: R " + commission +
                    "\nTOTAL: R " + total;

            JOptionPane.showMessageDialog(this, result);

            try (PrintWriter writer =
                    new PrintWriter(new FileWriter("data.txt", true))) {

                writer.println("DATA LOG");
                writer.println("************************");
                writer.println("Customer Name: " + name);
                writer.println("Product: " + product);
                writer.println("VAT: R " + vat);
                writer.println("COMMISSION: R " + commission);
                writer.println("TOTAL: R " + total);
                writer.println("************************");

            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(this,
                    "Please enter a valid price.");

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(this,
                    "Error saving file.");

        }
    }

    public void clearFields() {

        txtName.setText("");

        txtPrice.setText("");

        cmbProduct.setSelectedIndex(0);
    }

    public static void main(String[] args) {

        new ProductGUI();
    }
}
