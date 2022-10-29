package org.example.sites;


import org.example.list.AllList;
import org.example.products.Products;
import org.example.sites.Amazon;
import org.example.sites.NN;
import org.example.sites.Teknosa;
import org.example.sites.Trendyol;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {



    public static void main(String[] args) {
        Connection connection=null;
        String jdbcURL="jdbc:postgresql://localhost:5432/WebScrapping";
        String username="postgres";
        String password="Trabzon_3461?";
        //producstİd,productsName,productsPrice,produtcsLink
        AllList allList=new AllList();
        Teknosa teknosa=new Teknosa();
        try {
            teknosa.scrapeProductsTeknosa();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        List<Products> teknosaList=new ArrayList<>();
        teknosaList=teknosa.productsList;


        NN productN11=new NN();
        try {
            productN11.scrapeProductsN11();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<Products> n11list=new ArrayList<>();
        n11list=productN11.productsList;



        Trendyol trendyol=new Trendyol();
        try {
            trendyol.scrapeProductsTrendyol();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Products> trendyolList=new ArrayList<>();
        trendyolList=trendyol.productsList;



     Amazon amazon=new Amazon();
        try {
            amazon.scrapeProductsAmazon();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Products> amazonlList=new ArrayList<>();
       amazonlList=amazon.productsList;










        //allList.AddList(teknosaList,n11list,trendyolList);
        //System.out.println(allList.getAlllist(teknosaList,n11list,trendyolList));
       allList.AddList(teknosaList,n11list,trendyolList);
       List<List<Products>> newlist=allList.getAlllist(teknosaList,n11list,trendyolList);





        String PrSql="INSERT INTO products (productsname,productsprice,productslink,productid) VALUES (?,?,?,?)";

        try {
            connection= DriverManager.getConnection(jdbcURL,username,password);
            System.out.println("Bağlantı başarılı");
            PreparedStatement preparedStatement = connection.prepareStatement(PrSql);

            int i=1;
    for (Products a: teknosaList) {
        preparedStatement.setString(1,a.getProductName());
        preparedStatement.setString(2, a.getProductPrice());
        preparedStatement.setString(3, a.getProductLink());
        preparedStatement.setInt(4,i);
        preparedStatement.executeUpdate();
        i++;
    }

    for (Products a: n11list) {
        preparedStatement.setString(1,a.getProductName());
        preparedStatement.setString(2, a.getProductPrice());
        preparedStatement.setString(3, a.getProductLink());
        preparedStatement.setInt(4,i);
        preparedStatement.executeUpdate();
        i++;
    }

        for (Products a: trendyolList) {
                preparedStatement.setString(1,a.getProductName());
                preparedStatement.setString(2, a.getProductPrice());
                preparedStatement.setString(3, a.getProductLink());
                preparedStatement.setInt(4,i);
                preparedStatement.executeUpdate();
                i++;

            }


            for (Products a: amazonlList) {
                preparedStatement.setString(1,a.getProductName());
                preparedStatement.setString(2, a.getProductPrice());
                preparedStatement.setString(3, a.getProductLink());
                preparedStatement.setInt(4,i);
                preparedStatement.executeUpdate();
                i++;


            }




            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }














































    }

    public List<Products> AddList(List<Products>a, List<Products>b, List<Products>c){

        List<Products>AllProducts=new ArrayList<>();

        AllProducts.add((Products) a);
        AllProducts.add((Products) b);
        AllProducts.add((Products) c);
        return AllProducts;


    }








    }



