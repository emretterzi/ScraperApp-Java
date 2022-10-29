package org.example.sites;

import org.example.products.Products;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Teknosa {





   public List<Products> productsList = new ArrayList<>();


    public void scrapeProductsTeknosa() throws IOException {
        final String url = "https://www.teknosa.com/laptop-notebook-c-116004";

        final Document document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.38 Safari/537.36").timeout(10000).get();
        // attr("src")


        final Elements body = document.select("div.products");
        for (Element a : body.select("div#product-item.prd")) {


            String name = a.select("h3.prd-title.prd-title-style").text();

            String img = a.select("img").attr("src");
            String price = a.select("span.prc.prc-last").text();
            String link = a.select("a.prd-link").attr("href");

            Products products = new Products(name, price,"https://www.teknosa.com.tr/"+link);
            productsList.add(products);

            System.out.println(name);
            System.out.println(price);
            System.out.println(img);
            System.out.println("https://www.teknosa.com.tr/" + link);
            System.out.println();









        }
        ;


    }




    public List<Products> getProductsList() {
        return productsList;
    }


}
