import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupRun {

    public static void main(String[] args) throws IOException{
        Document doc = Jsoup.connect("https://www.imdb.com/chart/top")
                .timeout(10000).get();
        Elements body = doc.select("tbody.lister-list");
        //System.out.println(body.select("tr").size());
        for(Element e : body.select("tr"))
        {
            String img = e.select("td.posterColumn img").attr("src");
            String title = e.select("td.posterColumn img").attr("alt");
            System.out.println(title);
        }
    }
}
