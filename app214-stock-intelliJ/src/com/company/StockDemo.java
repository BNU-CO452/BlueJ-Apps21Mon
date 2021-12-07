package com.company;

/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;
    
    //private Random random;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stock)
    {
        this.stock = stock;
        //this.random = new Random();
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers

        stock.add(new Product(101, "Nomads of the North"));
        stock.add(new Product(102, "Butterfly Lion"));
        stock.add(new Product(103, "Golden Compass"));
        stock.add(new Product(104, "Necromancer"));
    }

    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.

        stock.print();

        buyProducts();
        stock.print();        

        sellProducts();
        stock.print();        
    }

    private void buyProducts()
    {
        stock.buyProduct(101, 912);
        stock.buyProduct(102, 100);
        stock.buyProduct(103, 48);
        stock.buyProduct(104, 128);
    }

    private void sellProducts()
    {
        stock.sellProduct(101, 123);
        stock.sellProduct(102, 100);
        stock.sellProduct(103, 500);
    }    
}