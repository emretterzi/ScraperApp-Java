package org.example.products;

import java.util.List;


public class Products {

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductLink() {
        return productLink;
    }

    public void setProductLink(String productLink) {
        this.productLink = productLink;
    }

    public List<Products> getAllProductsList() {
        return AllProductsList;
    }

    public void setAllProductsList(List<Products> allProductsList) {
        AllProductsList = allProductsList;
    }


    private String productName;
    private String productPrice;
    private String productLink;

    List<Products> AllProductsList;


    public Products( String productName, String productPrice, String productLink) {

        this.productName = productName;
        this.productPrice = productPrice;
        this.productLink = productLink;
    }

    @Override
    public String toString() {
        return "Products{" +
                ", productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productLink='" + productLink + '\'' +
                '}';
    }


}
