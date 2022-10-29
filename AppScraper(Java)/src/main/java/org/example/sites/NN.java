package org.example.sites;

import org.example.products.Products;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NN {

  public  List<Products> productsList=new ArrayList<>();


    public  void scrapeProductsN11() throws IOException {
        final String url =
                "https://www.n11.com/bilgisayar/dizustu-bilgisayar";
        final Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.38 Safari/537.36")
                .timeout(10000).get();


        final Elements body = document.selectXpath("//*[@id=\"listingUl\"]");


        for (Element e :body.select("li.column")) {
            String name = e.select("h3.productName").text();
            String price = e.select("ins").text();
            String link = e.select("a.plink").attr("href");
            String image = e.select("img.lazy.cardImage").attr(" src=");


            Products products=new Products(name,price,"https://www.n11.com/"+link);
            productsList.add(products);






            System.out.println(name);
            System.out.println(price);
            System.out.println(image);

            System.out.println("https://www.n11.com/" + link);
            System.out.println();
        }
    }



   // div.list-ul"


    public List<Products> getProductsList() {
        return productsList;
    }
}
