package org.example.sites;

import org.example.products.Products;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Amazon {

    public List<Products> productsList=new ArrayList<>();

    public  void scrapeProductsAmazon() throws IOException {
        final String url =
                "https://www.amazon.com.tr/s?k=laptop&__mk_tr_TR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&crid=2Q6RONOO8E31K&sprefix=laptop%2Caps%2C140&ref=nb_sb_noss_1" ;

        final Document document = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.38 Safari/537.36")
                .get();


        // h2.a-size-mini.a-spacing-none.a-color-base.s-line-clamp-4
        //span.a-size-base.a-color-base.a-text-normal


        final Elements body = document.selectXpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]");
        for (Element a :body.select("div.a-section.a-spacing-base")) {
            String price = a.select("span.a-offscreen").text();
            String img = a.select("img.s-image").attr("src");
            String name = a.select(" h2.a-size-mini.a-spacing-none.a-color-base.s-line-clamp-4").text();
            String link = a.select("a.a-link-normal.s-underline-text.s-underline-link-text.s-link-style.a-text-normal").attr("href");


            Products products=new Products(name,price,"https://www.amazon.com.tr/"+link);
            productsList.add(products);



             System.out.println(name);
             System.out.println(price);
             System.out.println(img);
             System.out.println("https://www.amazon.com.tr/" + link);
             System.out.println();




    }



}

    public List<Products> getProductsList() {
        return productsList;
    }

}

