package org.example;

import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ArticleSearch {
    ArticleInfObj[] articleInfo = new ArticleInfObj[4];
    public ArticleInfObj[] Search() throws IOException {
        String searchUrl = "https://link.springer.com/search?new-search=true&query=Page+Object+Model+Selenium+OR+Testing&content-type=article&date=custom&dateFrom=2024";
        Document doc = Jsoup.connect(searchUrl)
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();

        Elements articles = doc.select("li.app-card-open");


        int articlesToRetrieve = 4;
        for (int i = 0; i < articlesToRetrieve; i++) {
            Element article = articles.get(i);
            String title = article.select("a.app-card-open__link").text();
            String articleUrl = "https://link.springer.com" + article.select("a").attr("href");
            Document articleDoc = Jsoup.connect(articleUrl)
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get();

            Element metaElement = articleDoc.selectFirst("meta[name=prism.doi]");

            String doi = "";
            if (metaElement != null) {
                doi = metaElement.attr("content");
            }

            Elements liElements = articleDoc.select("li:has(time[datetime])");
            String publicationDate = "";
            for (Element liElement : liElements) {
                Element timeElement = liElement.selectFirst("time[datetime]");
                publicationDate = timeElement.attr("datetime");
            }
            articleInfo[i] = new ArticleInfObj(title, doi,publicationDate);

        }
        return articleInfo;
    }
}




