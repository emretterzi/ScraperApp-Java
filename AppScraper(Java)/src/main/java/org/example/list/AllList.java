package org.example.list;

import org.example.products.Products;

import java.util.ArrayList;
import java.util.List;

public class AllList  {


    public void  AddList (List<Products>a, List<Products>b, List<Products>c){

        List<List<Products>> AllProducts=new ArrayList<>();

        AllProducts.add(a);
        AllProducts.add(b);
        AllProducts.add(c);

        for (List<Products> i:AllProducts

             ) {
            System.out.println(i+"\n");
            System.out.println();

        }

    }

    public List<List<Products>> getAlllist (List<Products>a, List<Products>b, List<Products>c){

        List<List<Products>> AllProducts=new ArrayList<>();

        AllProducts.add(a);
        AllProducts.add(b);
        AllProducts.add(c);



        return AllProducts;



    }









}
