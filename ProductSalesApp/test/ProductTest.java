/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
import productsalesapp.Product;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {

        Product p = new Product();

        int result = p.GetTotalProductsSold();

        assertEquals(153, result);
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {

        Product p = new Product();

        double result = p.GetAverageProductSold();

        assertEquals(17.0, result, 0.001);
    }
}
