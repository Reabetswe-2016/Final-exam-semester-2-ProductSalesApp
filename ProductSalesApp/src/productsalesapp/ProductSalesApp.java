/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package productsalesapp;

/**
 *
 * @author tmpe
 */
public class ProductSalesApp {


    public static void main(String[] args) {

        Product p = new Product();

        PrintProduct print = new PrintProduct();

        System.out.println("PRODUCT SALES REPORT - 2026");

        System.out.println("********************************");

        print.PrintTotal(p.GetTotalProductsSold());

        print.PrintAverage(p.GetAverageProductSold());

        print.PrintPopular(p.GetMostPopularProduct());
    }
}
